SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', 'catalog,public', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE post (
    id bigint NOT NULL,
    content text NOT NULL,
    upvotes integer NOT NULL,
    user_id bigint
);


CREATE SEQUENCE post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE post_id_seq OWNED BY post.id;


CREATE TABLE upvote (
    id bigint NOT NULL,
    post_id bigint,
    user_id bigint
);



CREATE SEQUENCE upvote_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE upvote_id_seq OWNED BY upvote.id;


CREATE TABLE "user" (
    id bigint NOT NULL,
    username character varying(255) NOT NULL
);


CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE user_id_seq OWNED BY "user".id;


ALTER TABLE ONLY post ALTER COLUMN id SET DEFAULT nextval('post_id_seq'::regclass);


ALTER TABLE ONLY upvote ALTER COLUMN id SET DEFAULT nextval('upvote_id_seq'::regclass);


ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


ALTER TABLE ONLY post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);


ALTER TABLE ONLY upvote
    ADD CONSTRAINT upvote_pkey PRIMARY KEY (id);


ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


ALTER TABLE ONLY post
    ADD CONSTRAINT fk455dwbntke4dylt74tdbc90s1 FOREIGN KEY (user_id) REFERENCES "user"(id);


ALTER TABLE ONLY upvote
    ADD CONSTRAINT fk6s65a4vfqlbtaw1vkjtf75exw FOREIGN KEY (user_id) REFERENCES "user"(id);


ALTER TABLE ONLY upvote
    ADD CONSTRAINT fkp6ndkah6ux8wq0n6t1f549tq2 FOREIGN KEY (post_id) REFERENCES post(id);



