--
-- PostgreSQL database dump
--

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

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
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, email, name, password, role) VALUES (1, 'hagagyousef927@gmail.com', 'yousef', '$2a$10$J4hs9/SB4YD5Co4z5YaDtu2EPachJOjdpIKQ5Cka3WIdjtHNR0Mji', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (2, 'anasahmed927@gmail.com', 'anas', '$2a$10$xLCn84bluO9/T2n.b28SW.H0ePnTtQ.KBM2P2ETq0CMq8pA2H9UyC', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (3, 'abdallahibrahim927@gmail.com', 'abdallah', '$2a$10$DuMrtcjbSOjWofcaRqPCvuyndwZ.dR1XF1dCIrw4VEMrOTM0KpfpC', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (4, 'officer927@gmail.com', 'officer', '$2a$12$HKzWsuhol25js1u5GSWNK.FGxVjPzd0hjqZnXzjRADwNj0ozo2gHe', 'LOAN_OFFICER');
INSERT INTO public.users (id, email, name, password, role) VALUES (5, 'alisamy927@gmail.com', 'ali', '$2a$10$CZVxlu59vNLxw2hqVxE6U.uz508AUHBAMgDkNbnUYf5BEEYyh2FTi', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (6, 'kareemtamer927@gmail.com', 'kareem', '$2a$10$JwTMR8EHKTD5peSW2cLJ6u0YDHViZ8GM9htEkpbJca6mgHAilTaxu', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (8, 'marwan927@gmail.com', 'marwan', '$2a$10$hZkTGDiQbILewzzfd/70ZeCPQBdZt8oyKXP0SHpGQn.s678c6D5XK', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (9, 'sadam927@gmail.com', 'sadam', '$2a$10$Jol3ukACOVNvdLoX6uQbSeGBgaNz0GIuq1yjTx3m/Dc84UCoLPdCO', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (10, 'katkoot927@gmail.com', 'katkoot', '$2a$10$MmB1XRwOiu90V6LfDqjlmOmGbPrbvAafKbaWglHJr7pEOUS5YKoDy', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (11, 'boshkash927@gmail.com', 'boshkash', '$2a$10$CEEjupoT/BBAs2ednpOQFOAk0tpZ3rZaL.Nv9BaqCeaVbNsQJR/1m', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (12, 'qadafi927@gmail.com', 'qadafi', '$2a$10$rF6OnmO/PYxncAtmiNXTiuD17cvm0x4RHPrhcjkvKuA8TVPXlVfCq', 'USER');
INSERT INTO public.users (id, email, name, password, role) VALUES (13, 'sisi927@gmail.com', 'sisi', '$2a$10$db3q7Z.hIccTKL6NQCatP.FkcXAxQNN5RsIsb8U2XEeUVqZlGbKGG', 'USER');


--
-- Data for Name: loan; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (1, 2000000, '2026-04-13 18:12:13.143802', 24, 'APPROVED', 1);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (3, 1200000, '2026-04-15 22:50:18.140266', 16, 'PENDING', 6);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (6, 2400000, '2026-04-15 22:51:19.301786', 48, 'PENDING', 5);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (5, 3600000, '2026-04-15 22:51:07.703717', 36, 'APPROVED', 5);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (4, 1800000, '2026-04-15 22:50:29.233843', 18, 'REJECTED', 6);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (8, 1500000, '2026-04-21 23:36:18.751799', 16, 'PENDING', 2);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (7, 800000, '2026-04-21 23:35:56.692913', 12, 'APPROVED', 2);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (9, 3600000, '2026-04-27 00:26:49.157642', 18, 'PENDING', 9);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (12, 2000000, '2026-04-27 00:28:06.991266', 16, 'PENDING', 8);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (10, 2700000, '2026-04-27 00:27:13.4026', 24, 'APPROVED', 9);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (11, 1800000, '2026-04-27 00:27:49.772329', 12, 'APPROVED', 8);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (2, 1500000, '2026-04-13 18:15:28.526696', 36, 'REJECTED', 3);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (13, 3500000, '2026-04-27 00:41:09.003922', 24, 'PENDING', 10);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (14, 2000000, '2026-04-27 00:41:22.858614', 18, 'PENDING', 10);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (15, 4000000, '2026-04-27 00:42:02.242615', 36, 'PENDING', 11);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (16, 3000000, '2026-04-27 00:42:19.024543', 28, 'PENDING', 11);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (17, 3200000, '2026-04-27 00:54:22.207205', 16, 'PENDING', 12);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (20, 3000000, '2026-04-27 00:55:24.675987', 24, 'PENDING', 13);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (18, 2400000, '2026-04-27 00:54:37.760961', 12, 'APPROVED', 12);
INSERT INTO public.loan (id, amount, created_at, duration_months, status, user_id) VALUES (19, 2700000, '2026-04-27 00:55:09.096692', 20, 'REJECTED', 13);


--
-- Data for Name: loan_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.loan_history (id, acted_at, acted_by, action, loan_id) VALUES (1, '2026-04-27 00:54:22.234398', 'qadafi927@gmail.com', 'APPLIED', 17);
INSERT INTO public.loan_history (id, acted_at, acted_by, action, loan_id) VALUES (2, '2026-04-27 00:54:37.763964', 'qadafi927@gmail.com', 'APPLIED', 18);
INSERT INTO public.loan_history (id, acted_at, acted_by, action, loan_id) VALUES (3, '2026-04-27 00:55:09.101746', 'sisi927@gmail.com', 'APPLIED', 19);
INSERT INTO public.loan_history (id, acted_at, acted_by, action, loan_id) VALUES (4, '2026-04-27 00:55:24.678494', 'sisi927@gmail.com', 'APPLIED', 20);
INSERT INTO public.loan_history (id, acted_at, acted_by, action, loan_id) VALUES (5, '2026-04-27 00:56:29.887682', 'officer927@gmail.com', 'APPROVE', 18);
INSERT INTO public.loan_history (id, acted_at, acted_by, action, loan_id) VALUES (6, '2026-04-27 00:56:47.68042', 'officer927@gmail.com', 'REJECT', 19);


--
-- Name: loan_history_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.loan_history_id_seq', 6, true);


--
-- Name: loan_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.loan_id_seq', 20, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 13, true);


--
-- PostgreSQL database dump complete
--



