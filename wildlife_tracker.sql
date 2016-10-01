--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6rc1
-- Dumped by pg_dump version 9.6rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: Yusuf
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age character varying,
    type character varying
);


ALTER TABLE animals OWNER TO "Yusuf";

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: Yusuf
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO "Yusuf";

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Yusuf
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: Yusuf
--

CREATE TABLE sightings (
    id integer NOT NULL,
    animalid integer,
    location character varying,
    rangername character varying,
    "time" timestamp without time zone,
    species character varying,
    type character varying,
    age character varying,
    health character varying
);


ALTER TABLE sightings OWNER TO "Yusuf";

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: Yusuf
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO "Yusuf";

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Yusuf
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: animals id; Type: DEFAULT; Schema: public; Owner: Yusuf
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: sightings id; Type: DEFAULT; Schema: public; Owner: Yusuf
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: Yusuf
--

COPY animals (id, name, health, age, type) FROM stdin;
48	bald eagle	okay	newborn	endangered
49	monkey	\N	\N	non-endangered
50	bald eagle	\N	\N	non-endangered
51	monkey	\N	\N	non-endangered
52	octopus	\N	\N	non-endangered
53	monkey	\N	\N	non-endangered
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Yusuf
--

SELECT pg_catalog.setval('animals_id_seq', 53, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: Yusuf
--

COPY sightings (id, animalid, location, rangername, "time", species, type, age, health) FROM stdin;
11	49	nowhere	Yusuf	2016-09-30 16:53:49.675198	monkey	non-endangered	-	-
12	48	Somewhere	Joe Schmow	2016-09-30 16:54:05.210726	bald eagle	endangered	newborn	okay
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Yusuf
--

SELECT pg_catalog.setval('sightings_id_seq', 12, true);


--
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: Yusuf
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: sightings sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: Yusuf
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

