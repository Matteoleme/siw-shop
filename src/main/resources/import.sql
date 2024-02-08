--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2024-02-08 16:48:15

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4884 (class 0 OID 34535)
-- Dependencies: 221
-- Data for Name: utente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.utente (id, cognome, email, nome, credenziali_id) VALUES (2, 'Grandi', 'manu@live.com', 'Emanuele', NULL);
INSERT INTO public.utente (id, cognome, email, nome, credenziali_id) VALUES (1, 'Mastranza', 'matteo@email.com', 'Matteo', NULL);
INSERT INTO public.utente (id, cognome, email, nome, credenziali_id) VALUES (3, 'Pera', 'fede@email.com', 'Federica', NULL);
INSERT INTO public.utente (id, cognome, email, nome, credenziali_id) VALUES (4, 'Verdi', 'gigios@email.com', 'Luigi', NULL);
INSERT INTO public.utente (id, cognome, email, nome, credenziali_id) VALUES (5, 'Lala', 'sam@email.it', 'sam', NULL);


--
-- TOC entry 4886 (class 0 OID 34543)
-- Dependencies: 223
-- Data for Name: credenziali; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.credenziali (id, password, ruolo, username, utente_id) VALUES (2, '$2a$10$yOVfECZv3KvJKSL1A557ROc/y/IVORsPtY68q3xJOvxIA.8cAXpJG', 'DEFAULT', 'emanuelson11', 2);
INSERT INTO public.credenziali (id, password, ruolo, username, utente_id) VALUES (3, '$2a$10$LyXQr5Z3u9VKMHrJkbyR7uhcEAf1hMBjwuIx8r7PxOyClyQUbnO/e', 'DEFAULT', 'feds', 3);
INSERT INTO public.credenziali (id, password, ruolo, username, utente_id) VALUES (4, '$2a$10$0UUL5MazsboVNIM6g3uyvOitEnC4.sFwmfJeYx4yXgHd7NkzOuEtS', 'DEFAULT', 'gigi', 4);
INSERT INTO public.credenziali (id, password, ruolo, username, utente_id) VALUES (5, '$2a$10$CIaltHO7N8wp/yx2DwAHcujF80K67Qo1lPOfdXrGddKi44/cHGnSu', 'DEFAULT', 'sam', 5);
INSERT INTO public.credenziali (id, password, ruolo, username, utente_id) VALUES (1, '$2a$10$MKrYDhmQS1YEjqgkJnOvWeDPiqGOH.KZ0BvtN5xWeHGx6RBLO2oiK', 'ADMIN', 'matteo', 1);


--
-- TOC entry 4879 (class 0 OID 26351)
-- Dependencies: 216
-- Data for Name: produttore; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.produttore (id, indirizzo_sede, nazione, nome) VALUES (0, 'Via Roma 10', 'Italia', 'StarCompany');
INSERT INTO public.produttore (id, indirizzo_sede, nazione, nome) VALUES (1, 'Viale Mazzini 2', 'Italia', 'Aziendustria');


--
-- TOC entry 4880 (class 0 OID 26358)
-- Dependencies: 217
-- Data for Name: tipologia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tipologia (id, nome) VALUES (0, 'Smartphone');
INSERT INTO public.tipologia (id, nome) VALUES (1, 'Portatili');
INSERT INTO public.tipologia (id, nome) VALUES (2, 'Tablet');
INSERT INTO public.tipologia (id, nome) VALUES (3, 'Accessori');


--
-- TOC entry 4878 (class 0 OID 26344)
-- Dependencies: 215
-- Data for Name: prodotto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (1, 'Smartphone con fotocamera ad alta risoluzione', 'Smartphone X', 499.99, 0, 0, 'Lo smartphone X è dotato di una fotocamera ad alta risoluzione che cattura immagini nitide e dettagliate. Con un potente processore e un display vivido, è perfetto per chi ama scattare foto e guardare contenuti multimediali.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (2, 'Portatile leggero e potente', 'Portatile Y', 899.99, 1, 1, 'Il portatile Y è un compagno affidabile per il lavoro e intrattenimento. Con un design leggero e una potente CPU, offre prestazioni elevate in un formato portatile. Dotato di una batteria a lunga durata, è perfetto per chi è sempre in movimento.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (3, 'Tablet con schermo ad alta definizione', 'Tablet Z', 349.99, 0, 2, 'Il tablet Z offre una esperienza visiva straordinaria con il suo schermo ad alta definizione. Con una vasta gamma di app disponibili, è ideale per un uso quotidiano, intrattenimento e produttività. Leggero e compatto, è perfetto per chi viaggia.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (4, 'Cover protettiva per smartphone', 'Cover Protettiva A', 19.99, 1, 3, 'La cover protettiva A offre una protezione affidabile per il tuo smartphone. Realizzata con materiali di alta qualità, protegge il dispositivo da urti, graffi e polvere. Il design sottile e leggero non aggiunge ingombro.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (5, 'Cuffie wireless con cancellazione attiva del rumore', 'Cuffie B', 149.99, 0, 3, 'Le cuffie B offrono una esperienza audio immersiva con la cancellazione attiva del rumore. Connettiti senza fili al tuo dispositivo e goditi la libertà di movimento. Le cuffie sono dotate di comandi touch intuitivi e una lunga durata della batteria.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (6, 'Smartphone con funzionalità avanzate di fotografia', 'Smartphone A', 699.99, 1, 0, 'Lo smartphone A è dotato di funzionalità avanzate di fotografia che consentono di catturare momenti indimenticabili con precisione e chiarezza. Con un design elegante e prestazioni potenti, è ideale per coloro che amano scattare foto e video.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (8, 'Tablet versatile per uso quotidiano', 'Tablet C', 249.99, 1, 2, 'Il tablet C è un dispositivo versatile che si adatta alle tue esigenze quotidiane. Con un design elegante e una ampia gamma di app disponibili, è perfetto per intrattenimento, produttività e molto altro ancora.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (9, 'Auricolari wireless con custodia di ricarica', 'Auricolari D', 79.99, 0, 3, 'Gli auricolari D offrono una esperienza audio senza fili di alta qualità con la comodità di una custodia di ricarica compatta. Goditi la libertà di ascoltare la tua musica preferita ovunque tu vada con un suono nitido e bilanciato.');
INSERT INTO public.prodotto (id, descrizione, nome, prezzo, produttore_id, tipologia_id, dettagli) VALUES (10, 'Cover protettiva resistente agli urti per smartphone', 'Cover Protettiva E', 29.99, 1, 3, 'La cover protettiva E è progettata per resistere agli urti e proteggere il tuo smartphone dagli impatti accidentali. Realizzata con materiali di alta qualità, offre una protezione affidabile senza compromettere lo stile.');


--
-- TOC entry 4888 (class 0 OID 42734)
-- Dependencies: 225
-- Data for Name: recensione; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4895 (class 0 OID 0)
-- Dependencies: 224
-- Name: credenziali_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.credenziali_seq', 451, true);


--
-- TOC entry 4896 (class 0 OID 0)
-- Dependencies: 218
-- Name: prodotto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prodotto_seq', 1, false);


--
-- TOC entry 4897 (class 0 OID 0)
-- Dependencies: 219
-- Name: produttore_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produttore_seq', 1, false);


--
-- TOC entry 4898 (class 0 OID 0)
-- Dependencies: 226
-- Name: recensione_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recensione_seq', 351, true);


--
-- TOC entry 4899 (class 0 OID 0)
-- Dependencies: 220
-- Name: tipologia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipologia_seq', 1, false);


--
-- TOC entry 4900 (class 0 OID 0)
-- Dependencies: 222
-- Name: utente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utente_seq', 451, true);


-- Completed on 2024-02-08 16:48:15

--
-- PostgreSQL database dump complete
--

