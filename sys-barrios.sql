PGDMP     6    5                y            d38a52vbb9c139     12.6 (Ubuntu 12.6-1.pgdg20.04+1)    13.0 �    L           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            M           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            N           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            O           1262    4122428    d38a52vbb9c139    DATABASE     c   CREATE DATABASE d38a52vbb9c139 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE d38a52vbb9c139;
                gdusfigkaaasfn    false            P           0    0    DATABASE d38a52vbb9c139    ACL     A   REVOKE CONNECT,TEMPORARY ON DATABASE d38a52vbb9c139 FROM PUBLIC;
                   gdusfigkaaasfn    false    4175            Q           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM postgres;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO gdusfigkaaasfn;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   gdusfigkaaasfn    false    3            R           0    0    LANGUAGE plpgsql    ACL     1   GRANT ALL ON LANGUAGE plpgsql TO gdusfigkaaasfn;
                   postgres    false    741            �            1259    4127562    acceso    TABLE     v   CREATE TABLE public.acceso (
    id_acceso integer NOT NULL,
    usuario text,
    password text,
    rol smallint
);
    DROP TABLE public.acceso;
       public         heap    gdusfigkaaasfn    false            �            1259    4127568    acceso_id_acceso_seq    SEQUENCE     �   CREATE SEQUENCE public.acceso_id_acceso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.acceso_id_acceso_seq;
       public          gdusfigkaaasfn    false    202            S           0    0    acceso_id_acceso_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.acceso_id_acceso_seq OWNED BY public.acceso.id_acceso;
          public          gdusfigkaaasfn    false    203            �            1259    4127570 
   act_evento    TABLE     v   CREATE TABLE public.act_evento (
    id_cat_act integer,
    id_evento integer,
    id_act_evento integer NOT NULL
);
    DROP TABLE public.act_evento;
       public         heap    gdusfigkaaasfn    false            �            1259    4127573    act_evento_id_act_evento_seq    SEQUENCE     �   CREATE SEQUENCE public.act_evento_id_act_evento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.act_evento_id_act_evento_seq;
       public          gdusfigkaaasfn    false    204            T           0    0    act_evento_id_act_evento_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.act_evento_id_act_evento_seq OWNED BY public.act_evento.id_act_evento;
          public          gdusfigkaaasfn    false    205            �            1259    4127575    barrios    TABLE     �   CREATE TABLE public.barrios (
    nombre_barrio text,
    num_hab numeric,
    fecha_creacion date,
    es_legal boolean,
    id_parr bigint,
    id_barrio integer NOT NULL,
    estado_barrio text DEFAULT 1,
    diagnostico text
);
    DROP TABLE public.barrios;
       public         heap    gdusfigkaaasfn    false            �            1259    4127582    barrios_id_barrio_seq    SEQUENCE     �   CREATE SEQUENCE public.barrios_id_barrio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.barrios_id_barrio_seq;
       public          gdusfigkaaasfn    false    206            U           0    0    barrios_id_barrio_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.barrios_id_barrio_seq OWNED BY public.barrios.id_barrio;
          public          gdusfigkaaasfn    false    207            �            1259    4127584    cargos    TABLE     ^   CREATE TABLE public.cargos (
    id_cargo integer NOT NULL,
    nombre_cargo text NOT NULL
);
    DROP TABLE public.cargos;
       public         heap    gdusfigkaaasfn    false            �            1259    4127590    cargos_id_cargo_seq    SEQUENCE     �   CREATE SEQUENCE public.cargos_id_cargo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.cargos_id_cargo_seq;
       public          gdusfigkaaasfn    false    208            V           0    0    cargos_id_cargo_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.cargos_id_cargo_seq OWNED BY public.cargos.id_cargo;
          public          gdusfigkaaasfn    false    209            �            1259    4127595    carreras    TABLE     ~   CREATE TABLE public.carreras (
    id_carr integer NOT NULL,
    nombre_carr text NOT NULL,
    estado_carr text DEFAULT 1
);
    DROP TABLE public.carreras;
       public         heap    gdusfigkaaasfn    false            �            1259    4127602    carreras_id_carr_seq    SEQUENCE     �   CREATE SEQUENCE public.carreras_id_carr_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.carreras_id_carr_seq;
       public          gdusfigkaaasfn    false    210            W           0    0    carreras_id_carr_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.carreras_id_carr_seq OWNED BY public.carreras.id_carr;
          public          gdusfigkaaasfn    false    211            �            1259    4127604    catalogo_act    TABLE     �   CREATE TABLE public.catalogo_act (
    id_cat_act integer NOT NULL,
    nombre_cat_act text,
    estado_cat_act text DEFAULT 1
);
     DROP TABLE public.catalogo_act;
       public         heap    gdusfigkaaasfn    false            �            1259    4127611    catalogo_act_id_cat_act_seq    SEQUENCE     �   CREATE SEQUENCE public.catalogo_act_id_cat_act_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.catalogo_act_id_cat_act_seq;
       public          gdusfigkaaasfn    false    212            X           0    0    catalogo_act_id_cat_act_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.catalogo_act_id_cat_act_seq OWNED BY public.catalogo_act.id_cat_act;
          public          gdusfigkaaasfn    false    213            �            1259    4127613 
   dirigentes    TABLE     o   CREATE TABLE public.dirigentes (
    id_persona bigint NOT NULL,
    id_barrio bigint,
    id_cargo integer
);
    DROP TABLE public.dirigentes;
       public         heap    gdusfigkaaasfn    false            �            1259    4127616 	   doc_event    TABLE     t   CREATE TABLE public.doc_event (
    id_doc_event integer NOT NULL,
    id_docente integer,
    id_evento integer
);
    DROP TABLE public.doc_event;
       public         heap    gdusfigkaaasfn    false            �            1259    4127619    doc_event_id_doc_event_seq    SEQUENCE     �   CREATE SEQUENCE public.doc_event_id_doc_event_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.doc_event_id_doc_event_seq;
       public          gdusfigkaaasfn    false    215            Y           0    0    doc_event_id_doc_event_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.doc_event_id_doc_event_seq OWNED BY public.doc_event.id_doc_event;
          public          gdusfigkaaasfn    false    216            �            1259    4127621    doc_programa    TABLE     |   CREATE TABLE public.doc_programa (
    id_doc_programa integer NOT NULL,
    id_programa integer,
    id_docente integer
);
     DROP TABLE public.doc_programa;
       public         heap    gdusfigkaaasfn    false            �            1259    4127624     doc_programa_id_doc_programa_seq    SEQUENCE     �   CREATE SEQUENCE public.doc_programa_id_doc_programa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.doc_programa_id_doc_programa_seq;
       public          gdusfigkaaasfn    false    217            Z           0    0     doc_programa_id_doc_programa_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.doc_programa_id_doc_programa_seq OWNED BY public.doc_programa.id_doc_programa;
          public          gdusfigkaaasfn    false    218            �            1259    4127626    docentes    TABLE     W   CREATE TABLE public.docentes (
    id_persona integer NOT NULL,
    id_carr integer
);
    DROP TABLE public.docentes;
       public         heap    gdusfigkaaasfn    false            �            1259    4127629    estudiantes    TABLE     o   CREATE TABLE public.estudiantes (
    id_persona bigint NOT NULL,
    id_carr bigint,
    semestre smallint
);
    DROP TABLE public.estudiantes;
       public         heap    gdusfigkaaasfn    false            �            1259    4127632    eventos    TABLE       CREATE TABLE public.eventos (
    id_evento integer NOT NULL,
    nombre_evento text,
    id_barrio integer,
    id_carr integer,
    fecha_inicio date,
    review text,
    estado_evento text DEFAULT 1,
    duracion double precision,
    id_proyecto integer
);
    DROP TABLE public.eventos;
       public         heap    gdusfigkaaasfn    false            �            1259    4127639    eventos_id_evento_seq    SEQUENCE     �   CREATE SEQUENCE public.eventos_id_evento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.eventos_id_evento_seq;
       public          gdusfigkaaasfn    false    221            [           0    0    eventos_id_evento_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.eventos_id_evento_seq OWNED BY public.eventos.id_evento;
          public          gdusfigkaaasfn    false    222            �            1259    4127641    fotos    TABLE     c   CREATE TABLE public.fotos (
    id_foto integer NOT NULL,
    foto bytea,
    id_evento integer
);
    DROP TABLE public.fotos;
       public         heap    gdusfigkaaasfn    false            �            1259    4127647    fotos_id_foto_seq    SEQUENCE     �   CREATE SEQUENCE public.fotos_id_foto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.fotos_id_foto_seq;
       public          gdusfigkaaasfn    false    223            \           0    0    fotos_id_foto_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.fotos_id_foto_seq OWNED BY public.fotos.id_foto;
          public          gdusfigkaaasfn    false    224            �            1259    4127649 
   parroquias    TABLE     v   CREATE TABLE public.parroquias (
    id_parr integer NOT NULL,
    nombre_parr text NOT NULL,
    estado_parr text
);
    DROP TABLE public.parroquias;
       public         heap    gdusfigkaaasfn    false            �            1259    4127655    parroquias_id_parr_seq    SEQUENCE     �   CREATE SEQUENCE public.parroquias_id_parr_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.parroquias_id_parr_seq;
       public          gdusfigkaaasfn    false    225            ]           0    0    parroquias_id_parr_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.parroquias_id_parr_seq OWNED BY public.parroquias.id_parr;
          public          gdusfigkaaasfn    false    226            �            1259    4127657    personas    TABLE     �   CREATE TABLE public.personas (
    id_persona integer NOT NULL,
    cedula text,
    nombre text,
    apellido text,
    telefono text,
    correo text,
    genero character(1),
    estado_persona text DEFAULT 1
);
    DROP TABLE public.personas;
       public         heap    gdusfigkaaasfn    false            �            1259    4127664    personas_id_persona_seq    SEQUENCE     �   CREATE SEQUENCE public.personas_id_persona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.personas_id_persona_seq;
       public          gdusfigkaaasfn    false    227            ^           0    0    personas_id_persona_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.personas_id_persona_seq OWNED BY public.personas.id_persona;
          public          gdusfigkaaasfn    false    228            �            1259    4127666 	   programas    TABLE     �   CREATE TABLE public.programas (
    id_programa integer NOT NULL,
    nombre_programa text,
    mision text,
    vision text,
    objetivo text,
    antecedentes text
);
    DROP TABLE public.programas;
       public         heap    gdusfigkaaasfn    false            �            1259    4127672    programas_id_programa_seq    SEQUENCE     �   CREATE SEQUENCE public.programas_id_programa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.programas_id_programa_seq;
       public          gdusfigkaaasfn    false    229            _           0    0    programas_id_programa_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.programas_id_programa_seq OWNED BY public.programas.id_programa;
          public          gdusfigkaaasfn    false    230            �            1259    4127674 	   proyectos    TABLE     �   CREATE TABLE public.proyectos (
    id_proyecto integer NOT NULL,
    nombre_proyecto text,
    objetivo text,
    marco_referencial text,
    marco_teorico text,
    periodo text,
    id_programa integer
);
    DROP TABLE public.proyectos;
       public         heap    gdusfigkaaasfn    false            �            1259    4127680    proyectos_id_proyecto_seq    SEQUENCE     �   CREATE SEQUENCE public.proyectos_id_proyecto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.proyectos_id_proyecto_seq;
       public          gdusfigkaaasfn    false    231            `           0    0    proyectos_id_proyecto_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.proyectos_id_proyecto_seq OWNED BY public.proyectos.id_proyecto;
          public          gdusfigkaaasfn    false    232            �            1259    4127682    revistas    TABLE     q   CREATE TABLE public.revistas (
    id_revista integer NOT NULL,
    nombre_revista text,
    url_revista text
);
    DROP TABLE public.revistas;
       public         heap    gdusfigkaaasfn    false            �            1259    4127688    revistas_id_revista_seq    SEQUENCE     �   CREATE SEQUENCE public.revistas_id_revista_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.revistas_id_revista_seq;
       public          gdusfigkaaasfn    false    233            a           0    0    revistas_id_revista_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.revistas_id_revista_seq OWNED BY public.revistas.id_revista;
          public          gdusfigkaaasfn    false    234            �            1259    4127690    vinculacion    TABLE     �   CREATE TABLE public.vinculacion (
    id_vinculacion integer NOT NULL,
    id_estudiante integer,
    id_evento integer,
    estado_vinculacion text DEFAULT 1
);
    DROP TABLE public.vinculacion;
       public         heap    gdusfigkaaasfn    false            �            1259    4127697    vinculacion_id_vinculacion_seq    SEQUENCE     �   CREATE SEQUENCE public.vinculacion_id_vinculacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.vinculacion_id_vinculacion_seq;
       public          gdusfigkaaasfn    false    235            b           0    0    vinculacion_id_vinculacion_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.vinculacion_id_vinculacion_seq OWNED BY public.vinculacion.id_vinculacion;
          public          gdusfigkaaasfn    false    236            V           2604    4127699    acceso id_acceso    DEFAULT     t   ALTER TABLE ONLY public.acceso ALTER COLUMN id_acceso SET DEFAULT nextval('public.acceso_id_acceso_seq'::regclass);
 ?   ALTER TABLE public.acceso ALTER COLUMN id_acceso DROP DEFAULT;
       public          gdusfigkaaasfn    false    203    202            W           2604    4127700    act_evento id_act_evento    DEFAULT     �   ALTER TABLE ONLY public.act_evento ALTER COLUMN id_act_evento SET DEFAULT nextval('public.act_evento_id_act_evento_seq'::regclass);
 G   ALTER TABLE public.act_evento ALTER COLUMN id_act_evento DROP DEFAULT;
       public          gdusfigkaaasfn    false    205    204            Y           2604    4127701    barrios id_barrio    DEFAULT     v   ALTER TABLE ONLY public.barrios ALTER COLUMN id_barrio SET DEFAULT nextval('public.barrios_id_barrio_seq'::regclass);
 @   ALTER TABLE public.barrios ALTER COLUMN id_barrio DROP DEFAULT;
       public          gdusfigkaaasfn    false    207    206            Z           2604    4127702    cargos id_cargo    DEFAULT     r   ALTER TABLE ONLY public.cargos ALTER COLUMN id_cargo SET DEFAULT nextval('public.cargos_id_cargo_seq'::regclass);
 >   ALTER TABLE public.cargos ALTER COLUMN id_cargo DROP DEFAULT;
       public          gdusfigkaaasfn    false    209    208            \           2604    4127703    carreras id_carr    DEFAULT     t   ALTER TABLE ONLY public.carreras ALTER COLUMN id_carr SET DEFAULT nextval('public.carreras_id_carr_seq'::regclass);
 ?   ALTER TABLE public.carreras ALTER COLUMN id_carr DROP DEFAULT;
       public          gdusfigkaaasfn    false    211    210            ^           2604    4127704    catalogo_act id_cat_act    DEFAULT     �   ALTER TABLE ONLY public.catalogo_act ALTER COLUMN id_cat_act SET DEFAULT nextval('public.catalogo_act_id_cat_act_seq'::regclass);
 F   ALTER TABLE public.catalogo_act ALTER COLUMN id_cat_act DROP DEFAULT;
       public          gdusfigkaaasfn    false    213    212            _           2604    4127705    doc_event id_doc_event    DEFAULT     �   ALTER TABLE ONLY public.doc_event ALTER COLUMN id_doc_event SET DEFAULT nextval('public.doc_event_id_doc_event_seq'::regclass);
 E   ALTER TABLE public.doc_event ALTER COLUMN id_doc_event DROP DEFAULT;
       public          gdusfigkaaasfn    false    216    215            `           2604    4127706    doc_programa id_doc_programa    DEFAULT     �   ALTER TABLE ONLY public.doc_programa ALTER COLUMN id_doc_programa SET DEFAULT nextval('public.doc_programa_id_doc_programa_seq'::regclass);
 K   ALTER TABLE public.doc_programa ALTER COLUMN id_doc_programa DROP DEFAULT;
       public          gdusfigkaaasfn    false    218    217            b           2604    4127707    eventos id_evento    DEFAULT     v   ALTER TABLE ONLY public.eventos ALTER COLUMN id_evento SET DEFAULT nextval('public.eventos_id_evento_seq'::regclass);
 @   ALTER TABLE public.eventos ALTER COLUMN id_evento DROP DEFAULT;
       public          gdusfigkaaasfn    false    222    221            c           2604    4127708    fotos id_foto    DEFAULT     n   ALTER TABLE ONLY public.fotos ALTER COLUMN id_foto SET DEFAULT nextval('public.fotos_id_foto_seq'::regclass);
 <   ALTER TABLE public.fotos ALTER COLUMN id_foto DROP DEFAULT;
       public          gdusfigkaaasfn    false    224    223            d           2604    4127709    parroquias id_parr    DEFAULT     x   ALTER TABLE ONLY public.parroquias ALTER COLUMN id_parr SET DEFAULT nextval('public.parroquias_id_parr_seq'::regclass);
 A   ALTER TABLE public.parroquias ALTER COLUMN id_parr DROP DEFAULT;
       public          gdusfigkaaasfn    false    226    225            f           2604    4127710    personas id_persona    DEFAULT     z   ALTER TABLE ONLY public.personas ALTER COLUMN id_persona SET DEFAULT nextval('public.personas_id_persona_seq'::regclass);
 B   ALTER TABLE public.personas ALTER COLUMN id_persona DROP DEFAULT;
       public          gdusfigkaaasfn    false    228    227            g           2604    4127711    programas id_programa    DEFAULT     ~   ALTER TABLE ONLY public.programas ALTER COLUMN id_programa SET DEFAULT nextval('public.programas_id_programa_seq'::regclass);
 D   ALTER TABLE public.programas ALTER COLUMN id_programa DROP DEFAULT;
       public          gdusfigkaaasfn    false    230    229            h           2604    4127712    proyectos id_proyecto    DEFAULT     ~   ALTER TABLE ONLY public.proyectos ALTER COLUMN id_proyecto SET DEFAULT nextval('public.proyectos_id_proyecto_seq'::regclass);
 D   ALTER TABLE public.proyectos ALTER COLUMN id_proyecto DROP DEFAULT;
       public          gdusfigkaaasfn    false    232    231            i           2604    4127713    revistas id_revista    DEFAULT     z   ALTER TABLE ONLY public.revistas ALTER COLUMN id_revista SET DEFAULT nextval('public.revistas_id_revista_seq'::regclass);
 B   ALTER TABLE public.revistas ALTER COLUMN id_revista DROP DEFAULT;
       public          gdusfigkaaasfn    false    234    233            k           2604    4127714    vinculacion id_vinculacion    DEFAULT     �   ALTER TABLE ONLY public.vinculacion ALTER COLUMN id_vinculacion SET DEFAULT nextval('public.vinculacion_id_vinculacion_seq'::regclass);
 I   ALTER TABLE public.vinculacion ALTER COLUMN id_vinculacion DROP DEFAULT;
       public          gdusfigkaaasfn    false    236    235            '          0    4127562    acceso 
   TABLE DATA           C   COPY public.acceso (id_acceso, usuario, password, rol) FROM stdin;
    public          gdusfigkaaasfn    false    202   �       )          0    4127570 
   act_evento 
   TABLE DATA           J   COPY public.act_evento (id_cat_act, id_evento, id_act_evento) FROM stdin;
    public          gdusfigkaaasfn    false    204   ��       +          0    4127575    barrios 
   TABLE DATA           �   COPY public.barrios (nombre_barrio, num_hab, fecha_creacion, es_legal, id_parr, id_barrio, estado_barrio, diagnostico) FROM stdin;
    public          gdusfigkaaasfn    false    206   ��       -          0    4127584    cargos 
   TABLE DATA           8   COPY public.cargos (id_cargo, nombre_cargo) FROM stdin;
    public          gdusfigkaaasfn    false    208   ��       /          0    4127595    carreras 
   TABLE DATA           E   COPY public.carreras (id_carr, nombre_carr, estado_carr) FROM stdin;
    public          gdusfigkaaasfn    false    210   �       1          0    4127604    catalogo_act 
   TABLE DATA           R   COPY public.catalogo_act (id_cat_act, nombre_cat_act, estado_cat_act) FROM stdin;
    public          gdusfigkaaasfn    false    212   T�       3          0    4127613 
   dirigentes 
   TABLE DATA           E   COPY public.dirigentes (id_persona, id_barrio, id_cargo) FROM stdin;
    public          gdusfigkaaasfn    false    214   L�       4          0    4127616 	   doc_event 
   TABLE DATA           H   COPY public.doc_event (id_doc_event, id_docente, id_evento) FROM stdin;
    public          gdusfigkaaasfn    false    215   y�       6          0    4127621    doc_programa 
   TABLE DATA           P   COPY public.doc_programa (id_doc_programa, id_programa, id_docente) FROM stdin;
    public          gdusfigkaaasfn    false    217   ��       8          0    4127626    docentes 
   TABLE DATA           7   COPY public.docentes (id_persona, id_carr) FROM stdin;
    public          gdusfigkaaasfn    false    219   ɺ       9          0    4127629    estudiantes 
   TABLE DATA           D   COPY public.estudiantes (id_persona, id_carr, semestre) FROM stdin;
    public          gdusfigkaaasfn    false    220   �       :          0    4127632    eventos 
   TABLE DATA           �   COPY public.eventos (id_evento, nombre_evento, id_barrio, id_carr, fecha_inicio, review, estado_evento, duracion, id_proyecto) FROM stdin;
    public          gdusfigkaaasfn    false    221   w�       <          0    4127641    fotos 
   TABLE DATA           9   COPY public.fotos (id_foto, foto, id_evento) FROM stdin;
    public          gdusfigkaaasfn    false    223    �       >          0    4127649 
   parroquias 
   TABLE DATA           G   COPY public.parroquias (id_parr, nombre_parr, estado_parr) FROM stdin;
    public          gdusfigkaaasfn    false    225   ��       @          0    4127657    personas 
   TABLE DATA           r   COPY public.personas (id_persona, cedula, nombre, apellido, telefono, correo, genero, estado_persona) FROM stdin;
    public          gdusfigkaaasfn    false    227   C�       B          0    4127666 	   programas 
   TABLE DATA           i   COPY public.programas (id_programa, nombre_programa, mision, vision, objetivo, antecedentes) FROM stdin;
    public          gdusfigkaaasfn    false    229   B      D          0    4127674 	   proyectos 
   TABLE DATA           �   COPY public.proyectos (id_proyecto, nombre_proyecto, objetivo, marco_referencial, marco_teorico, periodo, id_programa) FROM stdin;
    public          gdusfigkaaasfn    false    231   �      F          0    4127682    revistas 
   TABLE DATA           K   COPY public.revistas (id_revista, nombre_revista, url_revista) FROM stdin;
    public          gdusfigkaaasfn    false    233   �      H          0    4127690    vinculacion 
   TABLE DATA           c   COPY public.vinculacion (id_vinculacion, id_estudiante, id_evento, estado_vinculacion) FROM stdin;
    public          gdusfigkaaasfn    false    235         c           0    0    acceso_id_acceso_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.acceso_id_acceso_seq', 28, true);
          public          gdusfigkaaasfn    false    203            d           0    0    act_evento_id_act_evento_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.act_evento_id_act_evento_seq', 19, true);
          public          gdusfigkaaasfn    false    205            e           0    0    barrios_id_barrio_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.barrios_id_barrio_seq', 6, true);
          public          gdusfigkaaasfn    false    207            f           0    0    cargos_id_cargo_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.cargos_id_cargo_seq', 2, true);
          public          gdusfigkaaasfn    false    209            g           0    0    carreras_id_carr_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.carreras_id_carr_seq', 8, true);
          public          gdusfigkaaasfn    false    211            h           0    0    catalogo_act_id_cat_act_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.catalogo_act_id_cat_act_seq', 85, true);
          public          gdusfigkaaasfn    false    213            i           0    0    doc_event_id_doc_event_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.doc_event_id_doc_event_seq', 12, true);
          public          gdusfigkaaasfn    false    216            j           0    0     doc_programa_id_doc_programa_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.doc_programa_id_doc_programa_seq', 6, true);
          public          gdusfigkaaasfn    false    218            k           0    0    eventos_id_evento_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.eventos_id_evento_seq', 7, true);
          public          gdusfigkaaasfn    false    222            l           0    0    fotos_id_foto_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.fotos_id_foto_seq', 86, true);
          public          gdusfigkaaasfn    false    224            m           0    0    parroquias_id_parr_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.parroquias_id_parr_seq', 67, true);
          public          gdusfigkaaasfn    false    226            n           0    0    personas_id_persona_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.personas_id_persona_seq', 75, true);
          public          gdusfigkaaasfn    false    228            o           0    0    programas_id_programa_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.programas_id_programa_seq', 1, true);
          public          gdusfigkaaasfn    false    230            p           0    0    proyectos_id_proyecto_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.proyectos_id_proyecto_seq', 1, true);
          public          gdusfigkaaasfn    false    232            q           0    0    revistas_id_revista_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.revistas_id_revista_seq', 1, true);
          public          gdusfigkaaasfn    false    234            r           0    0    vinculacion_id_vinculacion_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.vinculacion_id_vinculacion_seq', 11, true);
          public          gdusfigkaaasfn    false    236            m           2606    4127717    acceso acceso_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.acceso
    ADD CONSTRAINT acceso_pkey PRIMARY KEY (id_acceso);
 <   ALTER TABLE ONLY public.acceso DROP CONSTRAINT acceso_pkey;
       public            gdusfigkaaasfn    false    202            q           2606    4127719    act_evento act_evento_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.act_evento
    ADD CONSTRAINT act_evento_pkey PRIMARY KEY (id_act_evento);
 D   ALTER TABLE ONLY public.act_evento DROP CONSTRAINT act_evento_pkey;
       public            gdusfigkaaasfn    false    204            s           2606    4127721    barrios barrios_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.barrios
    ADD CONSTRAINT barrios_pkey PRIMARY KEY (id_barrio);
 >   ALTER TABLE ONLY public.barrios DROP CONSTRAINT barrios_pkey;
       public            gdusfigkaaasfn    false    206            u           2606    4127723    cargos cargos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.cargos
    ADD CONSTRAINT cargos_pkey PRIMARY KEY (id_cargo);
 <   ALTER TABLE ONLY public.cargos DROP CONSTRAINT cargos_pkey;
       public            gdusfigkaaasfn    false    208            w           2606    4127725    carreras carreras_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.carreras
    ADD CONSTRAINT carreras_pkey PRIMARY KEY (id_carr);
 @   ALTER TABLE ONLY public.carreras DROP CONSTRAINT carreras_pkey;
       public            gdusfigkaaasfn    false    210            y           2606    4127727    catalogo_act catalogo_act_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.catalogo_act
    ADD CONSTRAINT catalogo_act_pkey PRIMARY KEY (id_cat_act);
 H   ALTER TABLE ONLY public.catalogo_act DROP CONSTRAINT catalogo_act_pkey;
       public            gdusfigkaaasfn    false    212            {           2606    4127729    dirigentes dirigentes_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.dirigentes
    ADD CONSTRAINT dirigentes_pkey PRIMARY KEY (id_persona);
 D   ALTER TABLE ONLY public.dirigentes DROP CONSTRAINT dirigentes_pkey;
       public            gdusfigkaaasfn    false    214            }           2606    4127731    doc_event doc_event_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.doc_event
    ADD CONSTRAINT doc_event_pkey PRIMARY KEY (id_doc_event);
 B   ALTER TABLE ONLY public.doc_event DROP CONSTRAINT doc_event_pkey;
       public            gdusfigkaaasfn    false    215                       2606    4127733    doc_programa doc_programa_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.doc_programa
    ADD CONSTRAINT doc_programa_pkey PRIMARY KEY (id_doc_programa);
 H   ALTER TABLE ONLY public.doc_programa DROP CONSTRAINT doc_programa_pkey;
       public            gdusfigkaaasfn    false    217            �           2606    4127735    docentes docente_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.docentes
    ADD CONSTRAINT docente_pkey PRIMARY KEY (id_persona);
 ?   ALTER TABLE ONLY public.docentes DROP CONSTRAINT docente_pkey;
       public            gdusfigkaaasfn    false    219            �           2606    4127737    estudiantes estudiantes_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT estudiantes_pkey PRIMARY KEY (id_persona);
 F   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT estudiantes_pkey;
       public            gdusfigkaaasfn    false    220            �           2606    4127742    eventos eventos_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.eventos
    ADD CONSTRAINT eventos_pkey PRIMARY KEY (id_evento);
 >   ALTER TABLE ONLY public.eventos DROP CONSTRAINT eventos_pkey;
       public            gdusfigkaaasfn    false    221            �           2606    4127744    fotos fotos_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.fotos
    ADD CONSTRAINT fotos_pkey PRIMARY KEY (id_foto);
 :   ALTER TABLE ONLY public.fotos DROP CONSTRAINT fotos_pkey;
       public            gdusfigkaaasfn    false    223            �           2606    4127746    parroquias parroquias_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.parroquias
    ADD CONSTRAINT parroquias_pkey PRIMARY KEY (id_parr);
 D   ALTER TABLE ONLY public.parroquias DROP CONSTRAINT parroquias_pkey;
       public            gdusfigkaaasfn    false    225            �           2606    4127748    personas personas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY (id_persona);
 @   ALTER TABLE ONLY public.personas DROP CONSTRAINT personas_pkey;
       public            gdusfigkaaasfn    false    227            �           2606    4127750    programas programas_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.programas
    ADD CONSTRAINT programas_pkey PRIMARY KEY (id_programa);
 B   ALTER TABLE ONLY public.programas DROP CONSTRAINT programas_pkey;
       public            gdusfigkaaasfn    false    229            �           2606    4127752    proyectos proyectos_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.proyectos
    ADD CONSTRAINT proyectos_pkey PRIMARY KEY (id_proyecto);
 B   ALTER TABLE ONLY public.proyectos DROP CONSTRAINT proyectos_pkey;
       public            gdusfigkaaasfn    false    231            �           2606    4127754    revistas revistas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.revistas
    ADD CONSTRAINT revistas_pkey PRIMARY KEY (id_revista);
 @   ALTER TABLE ONLY public.revistas DROP CONSTRAINT revistas_pkey;
       public            gdusfigkaaasfn    false    233            o           2606    4127756    acceso unique_usuario 
   CONSTRAINT     S   ALTER TABLE ONLY public.acceso
    ADD CONSTRAINT unique_usuario UNIQUE (usuario);
 ?   ALTER TABLE ONLY public.acceso DROP CONSTRAINT unique_usuario;
       public            gdusfigkaaasfn    false    202            �           2606    4127758    vinculacion vinculacion_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.vinculacion
    ADD CONSTRAINT vinculacion_pkey PRIMARY KEY (id_vinculacion);
 F   ALTER TABLE ONLY public.vinculacion DROP CONSTRAINT vinculacion_pkey;
       public            gdusfigkaaasfn    false    235            �           2606    4127759    dirigentes fk_id_barrio    FK CONSTRAINT     �   ALTER TABLE ONLY public.dirigentes
    ADD CONSTRAINT fk_id_barrio FOREIGN KEY (id_barrio) REFERENCES public.barrios(id_barrio);
 A   ALTER TABLE ONLY public.dirigentes DROP CONSTRAINT fk_id_barrio;
       public          gdusfigkaaasfn    false    214    3955    206            �           2606    4127764    eventos fk_id_barrio    FK CONSTRAINT     ~   ALTER TABLE ONLY public.eventos
    ADD CONSTRAINT fk_id_barrio FOREIGN KEY (id_barrio) REFERENCES public.barrios(id_barrio);
 >   ALTER TABLE ONLY public.eventos DROP CONSTRAINT fk_id_barrio;
       public          gdusfigkaaasfn    false    221    3955    206            �           2606    4127769    dirigentes fk_id_cargo    FK CONSTRAINT     �   ALTER TABLE ONLY public.dirigentes
    ADD CONSTRAINT fk_id_cargo FOREIGN KEY (id_cargo) REFERENCES public.cargos(id_cargo) NOT VALID;
 @   ALTER TABLE ONLY public.dirigentes DROP CONSTRAINT fk_id_cargo;
       public          gdusfigkaaasfn    false    214    208    3957            �           2606    4127774    docentes fk_id_carr    FK CONSTRAINT     �   ALTER TABLE ONLY public.docentes
    ADD CONSTRAINT fk_id_carr FOREIGN KEY (id_carr) REFERENCES public.carreras(id_carr) NOT VALID;
 =   ALTER TABLE ONLY public.docentes DROP CONSTRAINT fk_id_carr;
       public          gdusfigkaaasfn    false    210    3959    219            �           2606    4127779    eventos fk_id_carrera    FK CONSTRAINT     |   ALTER TABLE ONLY public.eventos
    ADD CONSTRAINT fk_id_carrera FOREIGN KEY (id_carr) REFERENCES public.carreras(id_carr);
 ?   ALTER TABLE ONLY public.eventos DROP CONSTRAINT fk_id_carrera;
       public          gdusfigkaaasfn    false    210    221    3959            �           2606    4127784    estudiantes fk_id_carrera    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT fk_id_carrera FOREIGN KEY (id_carr) REFERENCES public.carreras(id_carr) NOT VALID;
 C   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT fk_id_carrera;
       public          gdusfigkaaasfn    false    220    210    3959            �           2606    4127789    act_evento fk_id_cat_act    FK CONSTRAINT     �   ALTER TABLE ONLY public.act_evento
    ADD CONSTRAINT fk_id_cat_act FOREIGN KEY (id_cat_act) REFERENCES public.catalogo_act(id_cat_act);
 B   ALTER TABLE ONLY public.act_evento DROP CONSTRAINT fk_id_cat_act;
       public          gdusfigkaaasfn    false    212    3961    204            �           2606    4127794    doc_event fk_id_docente    FK CONSTRAINT     �   ALTER TABLE ONLY public.doc_event
    ADD CONSTRAINT fk_id_docente FOREIGN KEY (id_docente) REFERENCES public.docentes(id_persona);
 A   ALTER TABLE ONLY public.doc_event DROP CONSTRAINT fk_id_docente;
       public          gdusfigkaaasfn    false    215    219    3969            �           2606    4127799    doc_programa fk_id_docente    FK CONSTRAINT     �   ALTER TABLE ONLY public.doc_programa
    ADD CONSTRAINT fk_id_docente FOREIGN KEY (id_docente) REFERENCES public.docentes(id_persona);
 D   ALTER TABLE ONLY public.doc_programa DROP CONSTRAINT fk_id_docente;
       public          gdusfigkaaasfn    false    219    3969    217            �           2606    4127804    vinculacion fk_id_estudiante    FK CONSTRAINT     �   ALTER TABLE ONLY public.vinculacion
    ADD CONSTRAINT fk_id_estudiante FOREIGN KEY (id_estudiante) REFERENCES public.estudiantes(id_persona);
 F   ALTER TABLE ONLY public.vinculacion DROP CONSTRAINT fk_id_estudiante;
       public          gdusfigkaaasfn    false    235    3971    220            �           2606    4127809    vinculacion fk_id_evento    FK CONSTRAINT     �   ALTER TABLE ONLY public.vinculacion
    ADD CONSTRAINT fk_id_evento FOREIGN KEY (id_evento) REFERENCES public.eventos(id_evento);
 B   ALTER TABLE ONLY public.vinculacion DROP CONSTRAINT fk_id_evento;
       public          gdusfigkaaasfn    false    221    3973    235            �           2606    4127814    fotos fk_id_evento    FK CONSTRAINT     |   ALTER TABLE ONLY public.fotos
    ADD CONSTRAINT fk_id_evento FOREIGN KEY (id_evento) REFERENCES public.eventos(id_evento);
 <   ALTER TABLE ONLY public.fotos DROP CONSTRAINT fk_id_evento;
       public          gdusfigkaaasfn    false    3973    223    221            �           2606    4127819    doc_event fk_id_evento    FK CONSTRAINT     �   ALTER TABLE ONLY public.doc_event
    ADD CONSTRAINT fk_id_evento FOREIGN KEY (id_evento) REFERENCES public.eventos(id_evento);
 @   ALTER TABLE ONLY public.doc_event DROP CONSTRAINT fk_id_evento;
       public          gdusfigkaaasfn    false    3973    221    215            �           2606    4127824    act_evento fk_id_evento    FK CONSTRAINT     �   ALTER TABLE ONLY public.act_evento
    ADD CONSTRAINT fk_id_evento FOREIGN KEY (id_evento) REFERENCES public.eventos(id_evento);
 A   ALTER TABLE ONLY public.act_evento DROP CONSTRAINT fk_id_evento;
       public          gdusfigkaaasfn    false    3973    204    221            �           2606    4127829    barrios fk_id_parr    FK CONSTRAINT     �   ALTER TABLE ONLY public.barrios
    ADD CONSTRAINT fk_id_parr FOREIGN KEY (id_parr) REFERENCES public.parroquias(id_parr) NOT VALID;
 <   ALTER TABLE ONLY public.barrios DROP CONSTRAINT fk_id_parr;
       public          gdusfigkaaasfn    false    206    225    3977            �           2606    4127834    estudiantes fk_id_persona    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiantes
    ADD CONSTRAINT fk_id_persona FOREIGN KEY (id_persona) REFERENCES public.personas(id_persona);
 C   ALTER TABLE ONLY public.estudiantes DROP CONSTRAINT fk_id_persona;
       public          gdusfigkaaasfn    false    220    227    3979            �           2606    4127839    dirigentes fk_id_persona    FK CONSTRAINT     �   ALTER TABLE ONLY public.dirigentes
    ADD CONSTRAINT fk_id_persona FOREIGN KEY (id_persona) REFERENCES public.personas(id_persona);
 B   ALTER TABLE ONLY public.dirigentes DROP CONSTRAINT fk_id_persona;
       public          gdusfigkaaasfn    false    3979    214    227            �           2606    4127844    docentes fk_id_persona    FK CONSTRAINT     �   ALTER TABLE ONLY public.docentes
    ADD CONSTRAINT fk_id_persona FOREIGN KEY (id_persona) REFERENCES public.personas(id_persona);
 @   ALTER TABLE ONLY public.docentes DROP CONSTRAINT fk_id_persona;
       public          gdusfigkaaasfn    false    3979    227    219            �           2606    4127849    doc_programa fk_id_programa    FK CONSTRAINT     �   ALTER TABLE ONLY public.doc_programa
    ADD CONSTRAINT fk_id_programa FOREIGN KEY (id_programa) REFERENCES public.programas(id_programa);
 E   ALTER TABLE ONLY public.doc_programa DROP CONSTRAINT fk_id_programa;
       public          gdusfigkaaasfn    false    217    3981    229            �           2606    4127854    eventos fk_id_proyecto    FK CONSTRAINT     �   ALTER TABLE ONLY public.eventos
    ADD CONSTRAINT fk_id_proyecto FOREIGN KEY (id_proyecto) REFERENCES public.proyectos(id_proyecto) NOT VALID;
 @   ALTER TABLE ONLY public.eventos DROP CONSTRAINT fk_id_proyecto;
       public          gdusfigkaaasfn    false    221    3983    231            �           2606    4127859    proyectos id_programa    FK CONSTRAINT     �   ALTER TABLE ONLY public.proyectos
    ADD CONSTRAINT id_programa FOREIGN KEY (id_programa) REFERENCES public.programas(id_programa);
 ?   ALTER TABLE ONLY public.proyectos DROP CONSTRAINT id_programa;
       public          gdusfigkaaasfn    false    3981    229    231            '   �   x�-��
�0Dϓ�)&�ms� � ��e!�,n��T��T=�{ÌF�;O���U	���"(�R�m[fYa�y5��Ǿ�g@��Nopv,��m�|�F'~!�h��:`�q�'��h�18q��ztȥjm������mSgr+�R��/�      )      x�3�4�44�2Q\1z\\\ �w      +   �   x�M��N�@�g�)��-��.�R�XC����$Q��)w�O�5'�K�l�����Rߑ�@iD�lT�
��lO�}��j�M���21�rX�*>�y��)�����J#|��!8�PU_ي�ٗ�Ho�<ɥ򎹫���q�c?_=.�ݭ���ϱ��)�2��x��B�����]��]��������?��S�l����/Lq���:���m"�e�e?g�W      -   "   x�3�r�tq�q�2��tvE����� ��?      /   _   x�3�)JLJ��W�O�L��4�2�1�s��3�\cN�̜�����kA\Nϼ�Լ��" _�3/-�(���d��gbqJ�a�il�b���� >�/      1   �  x��WKr�8]ç@� )�)�F��LRv�D��f�"!.�`��*�m� �He7[]l^�(J��,�H���^wF⋪s��������R&��T�*农�dT)Fc���b]��W��,������g�&�.���1e���Q�'����?8+��ǔ���� ��ֺ�*�����eat��Tת������Up{�3��s�mj�?��O(>�-\���b-��YV:��)2�]1
��4�*�#&���qc����=B2���hؤ��g�ф<���H�m�(+_d�9�ۄbXƌ�#,�^��\f:O�=d���D��W��>��YG	W�;=�`fs��
U���Z��/og����9�%�!s��c�l�'��D��ߣ~�SW�[�6&�➊`�b�2M���/�,#�h�_�����;v(V6ߢ<9.r� ���r�N(�k���+k����_a ���r�Mﴓ�۰���J��5���3�y���t��I|O|��K����N�u#O@o���NŲD�B �̭u�Gti�o�ݸ@���5�g����Q�de�C�����a�H���p�E� :az0�����	���<_�����𺓐�;mt������$�׈��PPa_��Y�M�}u�����U���l��J��7�d|�6��ݠ;��V>�;�k���<[�L�wo]?!���,��Y����l y�U���̕���m�˲���·4��Mh7�������F J~�0�lxiCcP
O�v����+Ib%%�u�f:<���7Ά��V�dI�N<���"W���k���3���#��b+�A��`���w:~'�F}����߽z��3�7m(�Eͅ��
'UY��;��E�X��GO���1�*G[8����dA���,Ĝ'�K��b>��{��k�L��ذ���L1>^�kU�
TH�����Ӈ���_�� ��ݩ-3
������<vX�V	oG�f�����H�RVV<LT�'6�/�n�y�~6�������ٴ�Z��gk��[���!�d.\
#-?������ʈ���t́��
��gm�3	�AwĄ:�����g���|+j�!�l]��I�љ$���A�`E��M��0�t1��|�Hv�˃x怚�^��1���kS񁹛��c_����� �ܡ@m�dd.�ݰd�b�#'k�Qި�<:P��|����E'�*��ԥn�l �����#=�#,�T�P������1���ǻ_���rX�|�hsHˆi������x�^�^�wW�R��/��"W�:���f��
Y��(S<;��RYyGf�>�,�a�jF��z˛S4�����A��S��"��5T\�u[pv�H���Sm��z�x?m��S:kٍ���q�B�lSNcyf^Ś��x{����&n�/���ͳl�X��b�ۇ���Q���ae�>Y��NQ�ZXB�y�Mj�G3z�v1mv ���A���[�Z����?�]\\��
      3      x�3�4�4�2��\�F��@*F��� & �      4      x�34��4����� k�      6      x�3�4�4�2�&\f@҂+F��� "~�      8      x�3�4�2�4� �=... �      9   w   x�%��	�0E��UL����%���lt���+�=�����U�s�2�q̚��m &MJP���$%)IIJRJ^򒗼�-oy�[�>є�4�)C�P�2��e(C�R����,e)��9���3      :   �   x�-�1�0E��> EmY�+� bc1�A�R9m%n�1����?��؂@S֝Ur8�!���w���pcxy''��`]!!�Uv�"�SK��\�)[%*�D3�X�M�X���Ǹ���VpY7ԕ|�����hK������.��c��~:BW      <      x�ŽY�%��]��L-E�h�?�t5���_���b����nv��* r�i`��������v���<Ox��%�\�?��܏��^7�''�ڞ¯��/��W�W{ƳB~���ɯz�!=_�a��p��V|b�'V>Ƹb��k��WzRH�_�5��SK1�xR���w�U���
����+c������-�'������*�r�����We���Y��	�����级'�*W��t㙿w��}y�}�yU�u/��{����,W~���X�����c�5ll��c�q���}��cN��--ze�������ߧ{���J��JO�m���njn��xӛ��-o}���QR��-���J/����[K���^GK-���V[k��{깿���[�}.9x��7^0ƌ3�<�Yf�m�9f��zWYu����q����ˮ����	:����z��g|�ؗ���_��׾����˝��n��=���+�ٯx���տ����o��+yw���9����ǌ�����st�ܭ�G\������^�w���~����=�+w,���g�q����ڃu\w�~��z>	��5#6~?���ǵk�N\_o�Zqs:w�~��U���*˞v�_#�Կ��{����>�l�n9�S������R]i��n��������/�R:W:�U������޽�1{�e��XkB�u��^ީ��u,6�p+��g�o�񫻦o�����Ok#M���^�,��ɽ��V�9R8o�H�w�����a�k'j��9o������7v�����<�}��b���X�V��-�M�뛷['����k�|��^�۬{g�߳�j��S�^kl9ֱ�4�ỹ�8��/���i��i�n���>��2���M}��g�-������иޡ�mk�r �S��Ϝc&*���=|�!��� ݻg�cα�������i�iϷ3��z�2y�3W�����1�~���r��g��W|�~G�-�X��E�;�/f��l���k<�@�Y�'7�{�:��6q�{�k����;�:J�����o��_�b��9����q���o��,��4a�+�s�H_m�H����x����1{��p��S��}b�<܀%�U���+1͉�o���}B�̀0Q��mIT.�Wf!��ʒu~Ͼ&�>Y�����}��A� F*�T@o�zƞ�6��k�
q��:��W�`��L|b������?_�,Ml����a�%�t?�e'�R{������	o'E@��	:F�iS�6Vp��xA�{�?b#�K��s���xq�����<Dܡ��Y	G�yV����S�c�۱�Yrh�ϸ�Ӊh�&��Q	�|�9�o�>!��X'	*�����]���U���5��Y�)ߓ76��3���� �p��No��c�J� �6��!��sN��c�'/.;�ɦ�X	�_i_��8������lǨ�v'^���p� �uMB�G|R8@|�0�!�k�+�>�� ?��/�z���_Y聶�V� ��S@i��K����,`��0b�����|�ذ����8�P�k���D<�:x�`c�?�q��瞭�s�P+8�k������V.���-b�$�?�ኛ�n���$pk|.�q!@bI&k�1s���|�ߛ[���������;|0��}�JO�"b����a�V��+K��#���E�-�E;���E�*�sfP` η��8D�o�E��6�(�O�.ٸ��S:�q���@h����^x(h�ӍJ��U�,i��x�~2^ڡ0/�nR�w�"^Z`;@8UW��Q,��yU�2[
հ��]��yih�*�'��z�v��k��/�m�C��;]��Y�k�[ャ!����}&�xX�Q'�d>���� vX^�;[�>�Z	��[v�0�qN����e��"�G�"��(o1�{;�ωX>���ۘ�>4 R߅����a��Y+�C(�Yz.R��[�z�LBܽ�������26�ۈ��m���\�[��h�W^��D���ϑj����q��$�$�,���}�|������F��aƸЌ[*S�*�׈�*PI���l�s�aㆅ��`�	��@�H��x�g/���'�>��~���c��ȑH-���{�A"� uOD#^D8�md� ���]Q��d�q�vFxF#���vA� ��?����&���΄��)���o�.�۰��@°�����W��TaT����V����t5�A�7�����J�1��`̺F��"(F`�		g	@��Dȳ��Ez�\�7�#f/ th��j�3�=5���e���"t� ?�Q�Ph���g�� �'���@��` , �ƅ�<�L�a It�0`�<��x��U��tR�a�����q�-�r���K-HhL������~��\��
��gbfl��a��h����lKD#�C
t�I@�H1P3ș��d
x,]@�a>�r��q�
��^�́�ѯ#��p�5�7��90?(,����������|+/A�'և�����x��9{v��xwb-ѵ�J�6Q3,��+�r�����}�\L}�_ۜ��޽c�Yv�
�iH��Ȑ�䆔$*��؀ �$���/�'pw�B([���͎h(�c��ve��d� 	2Z6\�(;��`Q�>���Y)x+D9�mx.�$z�;�k��5�����A��S%�|��C��j�D�^0�����~�$�h�'�c�h<<�#U���3kDx��GJ􃻀@��m�no(y���	y,��^�Ę�T�+vI�v�CBR�]ì�N��ëoH���a��N 3��loXlL� 2;8����$\+��_��Oj���)��a�zQ� g��FXV�?�����ӡ�x�~�F��K½�/�]�.�lm�Iů`e�5����쩃v�A�y�����E����rw���s�ܰ$���A]6�*V�3p�7�o�����5*s� {�{�ҁ�*�|_%Bn����7x���}uw���#�2`P �9�0:)����=����p,�ȝ@b �g�'|���	�/�"�v�_�о��w�1��E���^����A��q{S�Kk�n]ư!qc!�����'"����-8؁�@���@;���$���2��M1�5��x����
��ݤ��4YɈ��b?B�Z�tsQ�xr4��?�?�� �!���(�M�ĳY�Z4�L���b�6�I��^�����Tƾ�?��.�#�k!.��(r��/�����H
k��`	�"'�����q����{�@���Ў`��墳bn7�<\-�¹S�i`(�~x���x���Vq�6�0�s
p��SlӦ��aɫ��,3�DAḴ&|4!A��E�"�mW�:T��]>�j��![5�~����އ{�\ݛ���"bo�a��= Gв�N!1�jg�z��	��H��^�;�)���
|�uS�n�&��¹aKS��,��4B(UK7Ȯ:���A���q'�H�/`7���X_ ���Ա3��[��s�YCԪ9&L:��dHH��h��AA�3ј=�FY�K�҆���H���������d���C�K���V�+��Z��^V*��������eL~c�H?����^�2})��L�����2U�6��H��X���,{�: 2��c���'H���(��a`\�q"�P�����k⽘����C����.h�R��?�`ۼ��2W�#���,*��	��" $,(���	�k���ꡚ`_�Y��I� y�������;��Y�w�˄\�H�)��A�����a���=�c���Y5nF[�K�!x�	~w��=�J�� P �&
����R���/��E}�{���e��P7�t<Ǯ5Ŝ����DAB���\�����>�w����h
�P�.+HP���};�8��Q��U 2��ƅ���P�� U��(`6T�6A���fG��#k�+)�DP jj�t��e��`#    {�����R��`[�Q (�X4z{��Sd��|�T3���N;�a0�<�\g��D踕q�_�D�>L��U�Ĺ��@Ё'�u�f�*d�� ɀL� @�X������1��J���,�E���qHPo��ޔ�e�mAT��2ԅ���n\�̉.t�.~�����C��3f�tgaM���I��g���@�Á�"�#"c?��W��Y8YP*�(��|�F`��h�`��4`J��l�����-��7GSc�����D���6�$d��W�o����:P��S ^�>�E4:Fe�i#~�iVoŇ���@�
S���gN}D��0<д�*؍�v`����yDO�YÌ5����b@��ڎɽ5�_@�3��͗#�.�I|��`
g��A(!~e����֛���'����-�S:5T��V�1a�V�x(�R�oB�@VA1@LW���H�i���=A�߀���U}E��WXnEc�?���h0����}-,��"��l,�.��^�t����>�5�7`�Q*>�F��Qr����~�c.A����/�x����y�C�Yv�X���K��i����5IT�w��≹h G�����<<���{�|6�fP�Q�W��lZ,5��'1Vgt��A��>��'wee7�!�C#�*jx��Ev#-�R��M��^(�W�\�@��
���>Ap�i �����a�C�NI���,�Z�J�ZF�5ʸ��S�T#W�"v� �'q;��O�Ab�Wcъ�Ҳ�my*�2k����޽�㭭������ŷ�5���S5CIA��Uho����� �~�?xY�-C^6�Z&Ո�&�a��O�(�q�(��L|�щ�q�x4��Rʥބ�#c���Îه�qS�C\�[V,��nI�EO>G}rT�z��Ă��,��(�)�.��tv+�5D7ɼ:��,�'���ի\��sv�� {p	 ����K�uH�eɵT�#���d|�)PcOY�P��L�a��Q]c�����rm���M(g��O^$�#����q�A"�a��{��I��0��3�/�@��iSFS{��%zt�K C:���)x��*D#[� g�X�3�zd�3|	9N�
��ߞ6��؉��`���)uѧ��`��"�дrQ~��UhZu��4�mcf�貕�;i�1�-�c�н༼jU�l! ��H.��ț@�<�egb:�a/}�:c0�g/����0��|�i�0C�(���/�_��!8B��w�4B�&c���*���~1T��L~&
��Ghm0|s�W�dxp!ր�6��e�n�/<,�b�/�]P ��
��V�,���H��LDڅ��h}s�*`l�`c;��@�t�yD�q�]wh�G$4e�3d�f�V�N4l	$�ic���i([ �1�ď1�(��S�HA`���MN���7�`1���֭-[8���|�x�4�>�|�f#�e-��(g�E!��0l�C�'.�%3Zf�]@��,lc({Q;�`m�I�LL$5P5׎��D;b�!�d6J���Y���F���Mv���Y���n�@�����y �jƬ��2��ú�*�؍�,�F'$��"p�tTc4����?S[�P�B|�|��g[�����R8��J}��B�&Y4̇���2~Ȋ�V�,�LsP�}��J,4W
9�P�X)�f#+ ��BMu�_6a��0��:i��?�X��F�d�Bp��q����^����y�V�O#5q��x-d�X0�M��/�7xc�dv3n#��Sh�� �إY���#/����`����,������2:���]a����yc�^���P�9���Q���ݗ�g��Ӹ���b; ��Qg��靀�,%Z��A���������E�"9t �{��Bk��0�����e  D:Ŷ�l�B0��D�W�z����т��y�[�FπDV8	��:Z,hS��d���6$(R�u��^<o�3�{�YWD���\TZ�T���Ozq��m+���T��N����ۜjă�C^�5ȇ�[��;�x",3��>n>p����Q���Rem[��X����ߚR���}.9��lxD(�x#~3�<c���K�z���=Dt9�{��XdF�{�g2��V|.��W�DÛV�J�YmV�x7ʿ�-�����_�t��f7�;�<G�����͗ٿ��)7�ZM0bȃ�'V+�������h%����&��/�
�XЙ�:x�o�{���ޑQ��΂W{��奾n]�|�,�fl|�A�9�i�, 侸z�I���n�����1�D��ع�T���`��Q�O��?e�c�y���v}�Z�
N�3��������q�����L !*0�dRl a	Y�����u��.��f@��+����9�ÀzOɫF���}6�TYZ4�k�3�J��A��M�i��(ˡX�K
���/�Z�l?n3m�	;��jI*

�
���H��P���8HL�͉mC
+�����ǭ4NS[@<]��z��?�!Oo�c����ZX�a�#4������2���͓ŀ���l���X�J�r��~"qj�T���žT���m�\;_%,�5/��9M��
aR�mb�芍��Z�+ ��)d��	кd� �{�ImZOߴ���]��"�=\��7PŸ�{K*�m�ۗf�88�B"��po�B��G(x�.�/�a稒_��,(�6s�@�;Ș�^2��Ćf��	H64C-,��6�F�v3�0�� =(�f�(��0{�]��-p_���7������ "�#��� �7��6�S'"��L��SoUd��߹ �����w�Q�~�ϒ�SR��{A�Ok|��&��ɏ��m�����y�Ņ>>x+Z �\.cC2#�p�s&��">v���ʣ���6��&���@X\��"��݄�	2���1M�qObR p�o��l����9�.��b"��N�p�o~0��}j��^Aɻ[��ٱc�C�A�[�33aZ�{�t���V�u˔v$8���>��)��� ��d&k�MHh�
����C�0�O��\���3�͍$��.��� ���b/���᷵�Y���Ň��K���E��V=p�����_�~6K͍Ɔ��}�a�[��b�r�I,�}�,�[��W�[�l2~�o�<a�� �G�
�j�8XdG�H��en	��9$D��A�{*m���h�~�Ȇ�J0j�D�^LV�m��uK��B4�GA��
�@7���М�M�A�N�/W�66����������kZ�)<2��؇i�6��@�e���1ݒ�e�hֺ�ߟF1���|٪�9:l�G�o���Dz-e�*!?�NV��.�}Mt� ��,��	E�����S}A/&k��������L���)��A�GM�E��w���[[ ��ǲ�X��h�~�F5,�]#rY��0D�ū��Im@��zj_�σ��	*�,e��m�Т�	�2���[rc"�57C�ϡDh\"�������o���A��#�X��})����`Bj1���v�_�6�����B��|���d3j���_v���v��V9����Y�&J�3[:��=�~�����q./���v1Ϝ�gBG0ɫ�@T�%�g����CH��?[���"�F ��e�Ԓ3�/�[:��������ۖ _�	�2�'�',tو@����
�U
��D�[���O�7���H}P=  d�������M� �6�j5��v�A>���B���e3�%�t"p�^?�">�y�;\������n@pH�M,G���߳��6��"��'��p9Urɝ5��iH�d����9�Q�0��L,�_)l[�L=�G����E�c��Rp͙�����������k��Ǫ|��5_�x���u����?h�
�>����,��N؃d��1���c��.�'k��ȼfiw �>�b
�a���9;׬|�����Pk�ݭ���kQlW1ߧ4��S�X�a�[�[8E��p�&U[�F��pm�q�����(d��    ��`pL;�%�G�����m��V	!'.�ox�"J����XIzw�u�pR��̖�c~���FN��n{�����z��o���'����k]	g7����Ӆv��3}�Yٲ̓l햨8�{���l�$6���+0�:���!�����>"�3%��ό�lW��H�QPc��֊BB��'�*x�Y������y�A�G�˽xF�:�;df�*!��	,���:׭"�8��D{��V��D��j�:�>W$�Ьz1�=�&k�0��	",(�wa�t��+��c��M`�"�����<`#z`��z{�n�x��C(`� }xY��l��H�n��㐷�SE�JX4CES����mj)Ԓǰ��ۿ�����$�@�2"�-yd?�9B|�|���ܩV�V�[�r	9�k�?���=��J���sr5��z��؄n&�x�=$��@O �AA�e�`��������O�f��TY~�}6��ůCNܰ9<�.�»e�7p���ئ��o�؞��a�����&���v�,�BW��DQ�+�D]�y}+�8ڣZ��S+h�v�e�kX
q���BL�9�\��y�y���8�.e�YfJ@B���c0S�w�'��B]�.w"d�	e�y��V,�]���%�<X�PSt��E��d��@�&̉��G�v�0�26��\u�3��v�	�ʆ�-���Z��h�q�.جro�[��ʞ��\n�|�4�|�q;Yd���4�8������3���[�G�6;�I�i����v��L��k'g �d�1��y�@�0�aB���?���}<N$����Ջ�d�:�ﲀ?!)f:̙ ��Pt19��Y��}qi�l����?~aj���)�$vzV���u=�-y� �oz�;ĳ,�G���&�:)��eEP������񻽈H��|[E�O� ��yN��yp\��S�Y���=r;�"A�k��y
�a�}�9ˮ+=�Z�[q�Ҡ`�mS���%D�1��v�t�ܰ�W�\�y��f�R���0t��=�N�:���v5hȾBq��3�3ާ߁�	fv��%���D�E\�i�f�PE�9�~�Qט������ ��Bp�($��<ar8r�����k{��o^���9+�h��ۤ�KǇ�Lp7G��ƛY$�:|���xk�KM4'J��� ��v��9�;�@`Y����9��q5�}��&��Z�����o��R�-֦Q�e�tA�u�brK��kc�mA�&�po��5�{m2;�<8�<�ر?;t��jģ�Q���&<�ќ��BW�����gv0�AH�g��@�=\�N��p��ްM��\˝T�����,Ю�<+et��Z�åf���w��l� �['���C��w��?������y=꧂���v]V+��" �ub��#�N�e��g���{�uZ'�,��i�阚��Y��P���lw�'�;"&�hoPu��0�Xd�A[��I0Tފ������������Ӂ1�l��$/�SԌ��z�6�p�hP�n�������Zv&۸�����l���� 0��q��zc/_�m D����Y�L*N�kEv��=Dy+R�^��0�����AM����_TJf5"�>���K�ʰE��`�R�8���+�(p$+	w
cb�?�A'������hvd�@��^b�p;�`�=�	�3}#[�a1�QW� #9z>���g$Xz�����>�L�/�Y�pK�6�A����?��U�����qPSQvFT�n]]�Tj�Gݼ�	Q��{=m������G��]�a�嘍������гuԎà�����4��hWԣ~�Nd�,�Pn#OHN}h�\! cvJQ�����:���8�����:ii���������^��vȚ7:�M�`Z+���G5 L�;g}�w��]+�E8w8ͤz/�l8n�I� ���� 
��1Lk����x�hW*dGP��P�ZN�L�d��kP�\��Mft`��$��;V�V7�
C�BF�[��q@��z��"�4�Z��=��QSr��r���e&V8;�� O�����Io>�K����^V��>!^����j��8�X�Ǚ׊͏���W��5�w�۳��$���.VG�<���#���&�k�=U�Տٮ�D���_p�R(��ۡ__u5Jg�#�l��M��b��^�`��Xo��{e�W�B
�bԁY@sE;׎Dnw�9����H�a"ʹ
�����@��g%�a1i:j� �a��:Ǝ�Tq���F1�18�}���5�s�_�M�A%�(북��#��09e( �h%*-�[|�=�r��ֳ�8l3�� j�-��Ŧ^��3��4��^0l���n�ܖ�sxE��[/����ǎ�G3��s��H���h�r����,S+�<�	���z��
ɷs�Il�" "@M�x�>� m��E�~<!'E\���`^�}<'��Z�[���-��-��'�T{����u���ۣ=�M��_ž"���"��1�����k�DP3+�<=� ��Sh���me�{��9��)l���u�Xi�J0�,��ݩ�����7�Iu��o������8�l�������1����o��D�Ͳ!!R��>>/�,ġ:�C��T2St�uQ�
�PM���CI����Vã� k��mL���*$k��i�p*<�����CmsDc�Y٠X0$�Y��$�Xh�"[Ŗ�
��'����L�im��`8-${��x����s���lWG{�Ϟ6���u��I�a�����
�z����t�x<�qJ�8���ţ�lu�����<�)r�2�mc��z`�^0�7�/��Q������a�4���d��e�(�|o�_Btn�˼�:�6��P���mf�������X�D�'|�(�<��uv+�l,9q�q
6�D{|����Kb`��&;T���s_��nϣ�l�Qx�ӗ�g�[�3L�S�	��Y�#Ӄd���=.��]h�D��s  mT��ٲ����7GH7��0�>��D���w�0 |'B:L��B@�	����x�h��/�b[)�����3�6^�+$�C���>��c%�ZN&��_~8�F�}�nu��T/`e>�`����d`��D���>}�wZM�[{�?a�<ps��z5���N�|��v�@Sț�TD3���1
�8n>X���L'J�=`��K>Q<�TKv�^ݬ��X@�y��v��}����C�} R���^��|����T �c��O*͢6.`A����N�I�yܛ����p��J���`�� ��]���M1Ȅ�s��3�n��������[uO����`*h�p��+J-�c���d#�	K����d޹��n��f=����-�ڜ�{R�M��g�8����H �� ���q �V��E�A�{�V���rV�/��6�)4Rȶ?����k�w����L���Q���Ɵ!a�(ϝ�},�}�|=gjHٸ�/�c|�	_�����R�g?����Cv��34�ë���C�9<���l��e�8�;&����ܦ;(rYɲ��������]�V��ƳˀX�/���!t�/Y�w�������ά�k��=+�E~+X楍�t��U۹+�H�F���O!z$.t�V)n#82�\�Ģ<�ݠ���x$0�,������Ap�%;��FX��^��U�
�I&�=���~��C?;`��u�7��E����[;._���L��=�Eyh��7<{>Ɓ��صѡ"w��}��6{7ޅ�ƀW�c�-���1V:K��|��}#�F�v,�v�o���q?'�@��0	�����-px˴,�����a݈�E�U��ر-�5�gAϑ��0�������v�j�����o�����^�a.V�rNwC��ߑĺ�'�u���!զ�q[�,�|���`t\(]2��c�9�zb11�Y���G�"�f�+t$^V���+�ћ�W�H	% {9����3��}��%#��+�����
���8�f��^|O#��7�!�j�1 �  @����FR���Й�#�` ,��h�+f���%��z��}`��c�5��־u�f>j���"H%��Y�����k��͕�Ԁ�D@��Q�g���)0�h�5<������@��*1w��ws31o"a���۬�8�ڹg�"�m���a�ƈa Wۂ�	�b��QJ��}���S��t�l����óX{Q:8;�
+��ʺ�_�_,��}���X�����I��,�J���qg�x���cL$b�48<=��XA����}�*���>������z����8,����$�-}x؋;,R%�����K�8X��W��vs�K����p��qz."�Ed�. t؎�$qt�uW��
��ܮ5�]�������f��(��X��^�'��qd��A�n�#���r���|y�G  xl��lǪ���50��BQ�[������B2`	XD�TҶn�<��l �a�H
D��ސAW��L��������1�O�_ �������H+7��uI�n�j��:�a�qAO�1Q�M{q!r����s.�]])�
ٷ�`�<V^��`Q�(9�8P��1힙�=����.������mZH����cJ��m�X!7ObW=� L������ Qv�XX��A7,bW��o���U�c������	!�	����`���A��?ĳ� 5�����E�t�c8�0�w��Xm{<�ܭ'��y8G�φ��ѰVNX��W�K�:	��<���-7}O�0<�uF����?��F����ڮx'�M/���F�a���CF�ui�걭�l<F豱��`i��D����0Aj�Ba�p����	������Dp�9,xl� ���|v0����x
��p1��W�s�B�}"8O�6�FYd�@�=�������|�������M�b:P��d4��OuJ�6����)��9_D����J��~9@�rOn+�M��eW��x�'�~��|C��Uḯ|K�8m� ��.�i��s��O�G���0���b��ǓD&L�ͱ`HG���yʥ��40m�d�PB �i i�)���~���_�D��x8V YE�S{�Si,^�s����C��{�R���3~,�{ym�4iFlӃ=Fw� ִ���Y��;��d`�sO�'��Z<~��1�� �j<�{�e�3��o����;Ty�:R�(��;�i�b'|o3����H��\�Z h���V/�0�{(��b,T�Kj6��G�����ϴ�-L�;��XT������A�y��i���f:|����m<���x���`���� �ǐ8�t�l���Jb��!���v?�f|�����h�%����+���0ۛ���<�����RՁ�O�4kA�h�����`���`1T�qG�+5O7Y�s�#=-�x�Lk�z�|�67����1��>�1���t�WD5:���aսv~�聅�8mi��9�-"�3�0��E,b�q�&4�Ўz�U�,�F*(�z=���;h5<�@7��&�~�Qx��|Fp��'�B�
���n����Ĭ���i2J��@����uܥm�v�C�����Ϟ{��p������G��N�+��G\棺�x0>��'�N��:{��N�T�ĬmG�E�j�go�1Ɵ�SE"�[��N�
�w��B�ˎ�_Oc5?U�86�� �E��%{�T�V��b�_�lmF�M�0�>:#��%��K<���NJ�g0cO+v>���;ԔP�8�1y���q�������TW	MH���t�?X%���5e�lA�b�����C/���r����s+WÎsd��#;]���ng�U�'��{��= ���⋆��m�c��V�sGo����PQ�)ӲyEK�M�Ab�&�u���q�4@,p(� �_�2l^3�
���!�<0}k)�*GF�g(��(��k�V���L+�u��͕�9[T:�&��,���|r6�m��E��WM!�gp����7�a;�ȖU��&[O�J/{N�p���u�@}��|v�p',��e2���*�5guO���x6�
d��mU�7=#[�y�Iu������
_ۢa��l5��ISK�Tsܘ༺kH��[��|�S��^D_���?�;NRM��חv�m{�Y��d	w��	OXOTJd%�ر�|s{uK�n���=¬&�Զ]��#���]����Y��rO��{���ы;bݔ��*l�v������0Y��yq�
�'�.��<���oZ�(�}���t�b�6!0��=J`�l�FE�[�5�!@zޏMO�v�]�&��.E{=��0[�B���c����I{4%������*��C�S��"��`�O8����N:ml���Q����N�a�S�,�K���V�����Q$<�${�j!�x�9ZeX�B��晙 L��pg����@̅��b��5ﾽ���4�����������uK&�9~i�K���q/��mY6�Ge�TD�U|�#A�������xf�ڈR�G��MV��D�v��'f��� ��T{��%Iz�Ή��S^lH��?���t��izt�9sևo
ݽ��
v��o��k�5�{kpS7���6���smk��_ɣ��R�@K�������-S��^M�,��8�.z�b���|	�ҥ�l6@�|˟���� �����D�j�.��#����3�-�YR�	h{����Tg�{zZs��V�=�
�4��5S=�	65���c������R� ���/]!X �=�߆E#�_�0�z�6=�������BX!��ò�\X������@D@m��::��]Y1+�1�
#!�Єx��~E����Q�"Q�c|� *YG�gI0�O���[�y[=�Cքt���gG>ͳ������O6P�
�j�{�q��#�1˅4���?8�"�C$-Dc�d�K��CqL��G1���)<���*ȱ��XǏo%�� ��V��gB ��m�����x6�����N��;v��۶�ö�`X��Q�6�Z[�=�8��Q���J���8�?�X���p	��G�c7��aLΌ�}�\�s���ڽ��r4r�@�l�pb�>�I+R�8x&O5?���X�{�8LC�sz7�����i!��w���!?��o�_����������      >   R  x�=S�r�0<�_�/�XO�GǓ�I�����N/�J�P�C��q�&�r���c��7. R��U
����o�t��~�>�=2�ံ�a������v~s	�
n0�T':���ޢ�p��	m�6*��vp��+?y�qh�4�2J���~9"ո�QA+9�pi��h��5�>=-��Ϯ�Go�Պ��Zl�m��&�-�-�A�z��Ǝ
^_�:ݡe����YF�����pG���2PB�CT��
j�SN��w7a�`�p|����8�������9���.ٻ�;�V'�Q= �dҽ���ƽ[�p�z��w��L�C|��}^���uh̋�*��֌�����u+�ݰ�WNd��<�����f��?a�+'{cME�b-�zRj)����'�-�U������-(R~0�p�	��,���Ge�JeEyRH*fG3-
�n�k)�b���d�bWgZ�)vp5)�5��p��ks4�P2^��E;������#͜�G�6���
�ݘF�	9Ue��L��f$����PRx9�ؔ[���_R��=���������媖(\`���W�ܧ�3���S�[�-�1�x������/+�"!      @   �  x�mW͎�8>3O�XC�~(�b8��̤��� �,X�m�-�I6V�ͣ�8�9�~��XT�&�I`'�OE�������;�>���3>�O���7@P  E {� �Ӄ���+��L������3�%I��$/٪�{��g���r,QE�fe��L{d�\�M?�?��l��]�m��\K界K�y�(���N�/�it�{��xQ�<�6�ٺ}{���ԧ����}D�z��g�\k.S�2SB���a;��3�Xx�~���l�צa�����!MʼTk�Go���}Vy�~v}�;��������T���*١�^�;�p#�;�Y�h��q�|�R�e"%��ԍ��Ϫ^nk���c�)v�[�~�h�\ʴ��6�{D��r+��}��̀��2A�,a�����8��	ҟp�)�wx��]���ۋRI)r�;z�%�u�{�7�f�ؽm����d�J1�>U�z^���;�_L�ϓ�G*�Q�B�&@�$����F�����q�9���o˼��`��ɘ�h��ηz�S�>��e��R�<�l�7�v�;
︞�q�R�uS�~NX��,��X�:.y|�q4ǽg�>����4�'ӵzr�� F�gm?վ�jҍ��Q�H�#��f�Ş/T�%�u����	���UCޫ=�L�W�D���/���f�)�9�Ms�
4��Ȯ��Y�����;s��Re��$�YL���;�Ϙ	��{t��,��<�K�� Ȏ.����*��hQ�>�����'��<<y��V��2�M�m�{�UH�zoۍkLK:��/�J�O�^>�1�:%���'/��}1;r,s&3����3�'����Xt��� 0j%k2z�A�q�S��
���T����h)�9S 0��I�� �z�D���>iv{�\��)�[)2��x`�;]:=�4�͊P���7�	��5K�R��V�0[�"�wF\�E�q�鱀����J�' ��,�����[�/|��I9$Mq�E���6��t<�Y���/�n��B�y�'�e��)<�J��$�?��(ڣHX�+�Lq�q?Ud�2N|N�y�+�����77�&��d��vI�-����?��1���D#S��yx�����c�=�����]?�O�Ba(��$)��T���g3��v�VG��<��A{P�~�P����ʾ�"N��$ZCU�LȰ����b�ad}�KB`Oa��f���jN��Y�����,��DQаC 9�u='�]�h7�~�f/m=��R�A�t��/PZ�G�Y�1�kL�S��z���3����?S�1�J�v���)�}��C���*(HdY*���[��ǳ�����������TIY�����eS�bG"ܣ���^�vl�[v��kO*��\�����`T�/E:_ܫ�:T�2�Rdi��+W*��JS��>�[�O���Z�4tJB4�S����U�����^��z^�a,�?�ぶ�9�E�[I��>�]�:%
��໡![��r7�Ũ�/�+ؚ���i�<��ٶ����΄<���C&����؏�uk������ސ($���K��yܙ2	�E�k�t�"+���AW��7�L�n��i��P���W��8D%�m��A7��X�����&��0����î����_��Y_mג����e�i�K�O�x+Z�����Nǽ��"_�A���F�A��Ԍ��e�N2b�F���x.hQ&r�e�/HH��]o��ӀU�v�o��e��
н5C�t;Q�b�ě��x�;^�h-V�Q\<��7�ߖo޼�]M�      B   ;   x�3��wr�uT0������2�`'/��0 ��/�����H)r��qqq �2(      D   8   x�3��4��w�r��W0��ur�W�1B9��t��!�!W� o&�      F   ,   x�3��2��())(���///׫�/-)MJ�K�������� �m
�      H      x�34�C�=... n�     