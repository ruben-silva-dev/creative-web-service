--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

-- Started on 2016-08-29 05:30:43 BRT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2207 (class 0 OID 16646)
-- Dependencies: 191
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO pessoa VALUES (1, 'lucas@example.com', 'Lucas', '1234');
INSERT INTO pessoa VALUES (2, 'roberta@example.com', 'Roberta', '1234');
INSERT INTO pessoa VALUES (3, 'antonio@example.com', 'Antonio', '1234');
INSERT INTO pessoa VALUES (4, 'carla@example.com', 'Carla', '1234');
INSERT INTO pessoa VALUES (5, 'vitor@example.com', 'Vitor', '1234');
INSERT INTO pessoa VALUES (6, 'andreia@example.com', 'Andreia', '1234');
INSERT INTO pessoa VALUES (7, 'rafael@example.com', 'Rafael', '1234');
INSERT INTO pessoa VALUES (8, 'viviane@example.com', 'Viviane', '1234');
INSERT INTO pessoa VALUES (9, 'joao@example.com', 'João', '1234');
INSERT INTO pessoa VALUES (10, 'rute@example.com', 'Rute', '1234');
INSERT INTO pessoa VALUES (11, 'caioh@example.com', 'Caioh', '1234');


--
-- TOC entry 2202 (class 0 OID 16621)
-- Dependencies: 186
-- Data for Name: discussao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO discussao VALUES (1, 'Descrição da discussão 1', 'NOVA', 'Gatilho da discussão 1', 'Discussão 1', 1);
INSERT INTO discussao VALUES (2, 'Descrição da discussão 2', 'NOVA', 'Gatilho da discussão 2', 'Discussão 2', 1);
INSERT INTO discussao VALUES (3, 'Descrição da discussão 3', 'NOVA', 'Gatilho da discussão 3', 'Discussão 3', 2);
INSERT INTO discussao VALUES (6, 'Descrição da discussão 4', 'NOVA', 'Gatilho da discussão 4', 'Discussão 4', 3);
INSERT INTO discussao VALUES (7, 'Descrição da discussão 5', 'RECEBENDO_IDEIAS', 'Gatilho da discussão 5', 'Discussão 5', 1);


--
-- TOC entry 2204 (class 0 OID 16632)
-- Dependencies: 188
-- Data for Name: ideia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ideia VALUES (1, '2016-09-28 15:00:00', 'Texto da ideia 1', 1);
INSERT INTO ideia VALUES (2, '2016-09-28 15:00:00', 'Texto da ideia 2', 1);
INSERT INTO ideia VALUES (3, '2016-09-28 15:00:00', 'Texto da ideia 3', 2);
INSERT INTO ideia VALUES (4, '2016-09-28 15:00:00.633', 'Texto da ideia 1', 1);


--
-- TOC entry 2197 (class 0 OID 16600)
-- Dependencies: 181
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO autor VALUES (1, 2);
INSERT INTO autor VALUES (2, 4);
INSERT INTO autor VALUES (3, 4);


--
-- TOC entry 2198 (class 0 OID 16603)
-- Dependencies: 182
-- Data for Name: avaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO avaliacao VALUES (5, 1, 3);
INSERT INTO avaliacao VALUES (5, 1, 4);
INSERT INTO avaliacao VALUES (4, 2, 3);


--
-- TOC entry 2200 (class 0 OID 16610)
-- Dependencies: 184
-- Data for Name: comentario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO comentario VALUES (1, NULL, 'Texto do comentário 1', 3, 1);
INSERT INTO comentario VALUES (2, NULL, 'Texto do comentário 2', 3, 2);
INSERT INTO comentario VALUES (3, NULL, 'Texto do comentário 3', 4, 1);


--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 183
-- Name: comentario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('comentario_id_seq', 1, false);


--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 185
-- Name: discussao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('discussao_id_seq', 7, true);


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 187
-- Name: ideia_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ideia_id_seq', 4, true);


--
-- TOC entry 2205 (class 0 OID 16641)
-- Dependencies: 189
-- Data for Name: participacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO participacao VALUES (1, 3);
INSERT INTO participacao VALUES (1, 2);
INSERT INTO participacao VALUES (1, 4);
INSERT INTO participacao VALUES (2, 4);


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 190
-- Name: pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pessoa_id_seq', 11, true);


-- Completed on 2016-08-29 05:30:43 BRT

--
-- PostgreSQL database dump complete
--

