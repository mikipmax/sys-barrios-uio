package com.pmaxsoft.managed;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import com.pmaxsoft.dto.Evento;
import com.pmaxsoft.dto.Foto;
import com.pmaxsoft.servicios.EventoServicioI;
import com.pmaxsoft.servicios.FotoServicioI;
import com.pmaxsoft.util.AbstractManagedBean;

@Named
@SessionScoped
public class ManagedFoto extends AbstractManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Foto fotos;
	private Evento eventoSelect;
	private List<Foto> listaFotos;
	private int idEvento;
	private StreamedContent foto;
	@Inject
	FotoServicioI cargaFoto;
	@Inject
	EventoServicioI eventoServicio;

	@PostConstruct
	public void init() {
		fotos = new Foto();
		foto = null;
		eventoSelect = new Evento();

	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public Foto getFotos() {
		return fotos;
	}

	public void setFotos(Foto fotos) {
		this.fotos = fotos;
	}

	public List<Foto> getListaFotos() {
		return listaFotos;
	}

	public void setListaFotos(List<Foto> listaFotos) {
		this.listaFotos = listaFotos;
	}

	public StreamedContent getFoto() {
		return foto;
	}

	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

	public void leerFila(Evento evento) {
		eventoSelect = evento;
	}

	public void previoListarPorEvento(Evento evento) {

		foto = null;
		leerFila(evento);
		listarPorEvento();
	}

	// Método que lista varias fotos por evento
	public void listarPorEvento() {
		try {

			fotos = cargaFoto.buscarFotoEvento(eventoSelect.getIdEvento()); // pasar el evento id
			foto = ConvertirImagen(fotos);
		} catch (Exception e) {
			mensajeError("Error:" + e.getMessage());
		}

	}

	@SuppressWarnings("deprecation")
	public StreamedContent ConvertirImagen(Foto foto) {

		if (fotos == null) {
			return null;
		} else {

			return new DefaultStreamedContent(new ByteArrayInputStream(fotos.getFoto()));// devolvemos la imagen
																							// reconstruida
		}
	}

	private byte[] convertirBufferedImageToArrayByte(BufferedImage bufImage, String ex) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufImage, ex, baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}

	public BufferedImage convertirArrayByteToBufferedImage(byte[] fotoByte) throws IOException {
		InputStream in = new ByteArrayInputStream(fotoByte);
		return ImageIO.read(in);
	}

//Metodo que reduce las dimensiones de la foto mediante un porcentaje
	public BufferedImage resize(byte[] originalImage, float porcentaje) {
		try {
			BufferedImage bimg = convertirArrayByteToBufferedImage(originalImage);
			BufferedImage imagenReducida;
			// Reduzco un cierto porcentaje%
			int ancho = bimg.getWidth();
			int altura = bimg.getHeight();
			// Solo para imagenes menores a 1080p
			if (altura <= 1920 && ancho <= 1080) {
				porcentaje = 0.20f;
				System.out.println("menor");
			}

			int nuevoAncho = (int) (ancho * (1 - porcentaje));
			int nuevaAltura = (int) (altura * (1 - porcentaje));
			imagenReducida = Scalr.resize(bimg, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, nuevoAncho, nuevaAltura);

			return imagenReducida;
		} catch (Exception e) {
			return null;
		}

	}

//Este metodo es por default para manejar el <p:fileUpload> debe tener como parametro un FileUploadEvent para que funcione
	public void handleFileUpload(FileUploadEvent event) {

		UploadedFile ufile = event.getFile();

		String extension = event.getFile().getContentType().split("/")[1];

		Foto f = new Foto();
		byte[] fotoByte = null;
		byte[] fotoByteAux = null;
		if (ufile != null) {

			try {

				fotoByte = IOUtils.toByteArray(ufile.getInputStream());
				System.out.println(fotoByte.length + " antes");
				fotoByteAux = convertirBufferedImageToArrayByte(resize(fotoByte, 0.40f), extension);
				System.out.println(fotoByteAux.length + " nuevo");
				// valido si la compresion no fue exitosa
				if (fotoByteAux.length >= fotoByte.length) {
					fotoByteAux = fotoByte;
					System.out.println("uso la original");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Foto fotoAux = cargaFoto.buscarFotoEvento(eventoSelect.getIdEvento());
			if (fotoAux != null) {
				cargaFoto.eliminar(fotoAux.getIdFoto());
			}

			f.setFoto(fotoByteAux);

			f.setIdEvento(eventoSelect);

			cargaFoto.crear(f);
		}
		FacesMessage message = new FacesMessage("Successful", " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		eventoSelect = new Evento();

	}

	public Evento getEventoSelect() {
		return eventoSelect;
	}

	public void setEventoSelect(Evento eventoSelect) {
		this.eventoSelect = eventoSelect;
	}
}

//	Adaptado de https://stackoverflow.com/questions/10073905/display-database-blob-images-in-pgraphicimage-inside-uirepeat