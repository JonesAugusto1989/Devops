--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4 (Debian 17.4-1.pgdg120+2)
-- Dumped by pg_dump version 17.4 (Debian 17.4-1.pgdg120+2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cpf_cnpj character varying(18) NOT NULL,
    nome character varying(255) NOT NULL,
    email character varying(255),
    telefone character varying(20)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (cpf_cnpj, nome, email, telefone) FROM stdin;
851.264.580-60	Marcos Rodrigues	marcosrodrigues@gmail.com	215234-5544
86.524.650/0001-51	Loja de doces Cacau	cacaudoceshop@cacau.com	119514-1951
60.056.701/0001-74	Joveroni Muller	mullerjove@hotmail.com	212258-1195
471.755.230-09	Ana Santos	santosana@gmail.com	219957-2123
\.


--
-- Name: cliente cliente_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_email_key UNIQUE (email);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cpf_cnpj);


--
-- PostgreSQL database dump complete
--

