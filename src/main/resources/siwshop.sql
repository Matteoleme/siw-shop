
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



INSERT INTO public.utente (id, cognome, email, nome) VALUES (2, 'Grandi', 'manu@live.com', 'Emanuele');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (1, 'Mastranza', 'matteo@email.com', 'Matteo');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (3, 'Pera', 'fede@email.com', 'Federica');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (4, 'Verdi', 'gigios@email.com', 'Luigi');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (5, 'Lala', 'sam@email.it', 'sam');


INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (2, 2, '$2a$10$yOVfECZv3KvJKSL1A557ROc/y/IVORsPtY68q3xJOvxIA.8cAXpJG', 'DEFAULT', 'emanuelson11');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (3, 3, '$2a$10$LyXQr5Z3u9VKMHrJkbyR7uhcEAf1hMBjwuIx8r7PxOyClyQUbnO/e', 'DEFAULT', 'feds');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (4, 4, '$2a$10$0UUL5MazsboVNIM6g3uyvOitEnC4.sFwmfJeYx4yXgHd7NkzOuEtS', 'DEFAULT', 'gigi');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (5, 5, '$2a$10$CIaltHO7N8wp/yx2DwAHcujF80K67Qo1lPOfdXrGddKi44/cHGnSu', 'DEFAULT', 'sam');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (1, 1, '$2a$10$MKrYDhmQS1YEjqgkJnOvWeDPiqGOH.KZ0BvtN5xWeHGx6RBLO2oiK', 'ADMIN', 'matteo');


INSERT INTO public.tipologia (id, nome) VALUES (0, 'Smartphone');
INSERT INTO public.tipologia (id, nome) VALUES (1, 'Portatili');
INSERT INTO public.tipologia (id, nome) VALUES (2, 'Tablet');
INSERT INTO public.tipologia (id, nome) VALUES (3, 'Accessori');


INSERT INTO public.produttore (id, indirizzo_sede, nazione, nome) VALUES (0, 'Via Roma 10', 'Italia', 'StarCompany');
INSERT INTO public.produttore (id, indirizzo_sede, nazione, nome) VALUES (1, 'Viale Mazzini 2', 'Italia', 'Aziendustria');


INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (499.99, 1, 0, 0, 'Smartphone con fotocamera ad alta risoluzione', 'Lo smartphone X è dotato di una fotocamera ad alta risoluzione che cattura immagini nitide e dettagliate. Con un potente processore e un display vivido, è perfetto per chi ama scattare foto e guardare contenuti multimediali.', 'Smartphone X');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (899.99, 2, 1, 1, 'Portatile leggero e potente', 'Il portatile Y è un compagno affidabile per il lavoro e intrattenimento. Con un design leggero e una potente CPU, offre prestazioni elevate in un formato portatile. Dotato di una batteria a lunga durata, è perfetto per chi è sempre in movimento.', 'Portatile Y');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (349.99, 3, 0, 2, 'Tablet con schermo ad alta definizione', 'Il tablet Z offre una esperienza visiva straordinaria con il suo schermo ad alta definizione. Con una vasta gamma di app disponibili, è ideale per un uso quotidiano, intrattenimento e produttività. Leggero e compatto, è perfetto per chi viaggia.', 'Tablet Z');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (19.99, 4, 1, 3, 'Cover protettiva per smartphone', 'La cover protettiva A offre una protezione affidabile per il tuo smartphone. Realizzata con materiali di alta qualità, protegge il dispositivo da urti, graffi e polvere. Il design sottile e leggero non aggiunge ingombro.', 'Cover Protettiva A');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (149.99, 5, 0, 3, 'Cuffie wireless con cancellazione attiva del rumore', 'Le cuffie B offrono una esperienza audio immersiva con la cancellazione attiva del rumore. Connettiti senza fili al tuo dispositivo e goditi la libertà di movimento. Le cuffie sono dotate di comandi touch intuitivi e una lunga durata della batteria.', 'Cuffie B');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (699.99, 6, 1, 0, 'Smartphone con funzionalità avanzate di fotografia', 'Lo smartphone A è dotato di funzionalità avanzate di fotografia che consentono di catturare momenti indimenticabili con precisione e chiarezza. Con un design elegante e prestazioni potenti, è ideale per coloro che amano scattare foto e video.', 'Smartphone A');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (249.99, 8, 1, 2, 'Tablet versatile per uso quotidiano', 'Il tablet C è un dispositivo versatile che si adatta alle tue esigenze quotidiane. Con un design elegante e una ampia gamma di app disponibili, è perfetto per intrattenimento, produttività e molto altro ancora.', 'Tablet C');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (79.99, 9, 0, 3, 'Auricolari wireless con custodia di ricarica', 'Gli auricolari D offrono una esperienza audio senza fili di alta qualità con la comodità di una custodia di ricarica compatta. Goditi la libertà di ascoltare la tua musica preferita ovunque tu vada con un suono nitido e bilanciato.', 'Auricolari D');
INSERT INTO public.prodotto (prezzo, id, produttore_id, tipologia_id, descrizione, dettagli, nome) VALUES (29.99, 10, 1, 3, 'Cover protettiva resistente agli urti per smartphone', 'La cover protettiva E è progettata per resistere agli urti e proteggere il tuo smartphone dagli impatti accidentali. Realizzata con materiali di alta qualità, offre una protezione affidabile senza compromettere lo stile.', 'Cover Protettiva E');



INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 1, 2, 4, 3, 'Non serve a nulla! Dopo una caduta si è rotto il mio telefono!');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 3, 3, 1, 3, 'Reparto fotocamere TOP! Peccato per il SO un po'' scarno');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 2, 4, 1, 2, 'Niente di che, mi aspettavo di più per il prezzo');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 5, 5, 2, 2, 'Molto buono. Lo uso per lavorare ed è molto affidabile!');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 4, 6, 8, 2, 'Lo uso per vedere serie TV. Mi piace molto');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 4, 7, 5, 2, 'Isolamento del rumore non è molto buono. Per il resto ottimo prodotto');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 2, 8, 9, 2, 'Purtroppo hanno un''autonomia scadente');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 4, 9, 2, 5, 'Prodotto molto interessante. Non ci si può giocare senza qualche compromesso però');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 5, 10, 6, 5, 'Oramai mi affido sempre ad Aziendustria per i telefoni e non rimango mai deluso!');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 4, 11, 10, 5, 'Perfetto per il mio telefono. Lo rende forse un po'' troppo pesante');
INSERT INTO public.recensione (data, valutazione, id, prodotto_id, utente_id, descrizione) VALUES ('2024-02-08', 5, 12, 8, 3, 'Mi piace molto la qualità dello schermo');



SELECT pg_catalog.setval('public.credenziali_seq', 6, true);


--
-- TOC entry 4894 (class 0 OID 0)
-- Dependencies: 216
-- Name: prodotto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prodotto_seq', 11, false);


--
-- TOC entry 4895 (class 0 OID 0)
-- Dependencies: 217
-- Name: produttore_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produttore_seq', 2, false);


--
-- TOC entry 4896 (class 0 OID 0)
-- Dependencies: 218
-- Name: recensione_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recensione_seq', 51, true);


--
-- TOC entry 4897 (class 0 OID 0)
-- Dependencies: 219
-- Name: tipologia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipologia_seq', 2, false);


--
-- TOC entry 4898 (class 0 OID 0)
-- Dependencies: 220
-- Name: utente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utente_seq', 6, true);


-- Completed on 2024-02-08 18:19:15

--
-- PostgreSQL database dump complete
--

