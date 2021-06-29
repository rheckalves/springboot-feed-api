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
    user_id bigint
);


ALTER TABLE post OWNER TO postgres;


CREATE SEQUENCE post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE post_id_seq OWNER TO postgres;


ALTER SEQUENCE post_id_seq OWNED BY post.id;



CREATE TABLE post_upvotes_user_ids (
    post_id bigint NOT NULL,
    upvotes_user_ids bigint
);


ALTER TABLE post_upvotes_user_ids OWNER TO postgres;


CREATE TABLE "user" (
    id bigint NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE "user" OWNER TO postgres;


CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO postgres;


ALTER SEQUENCE user_id_seq OWNED BY "user".id;



ALTER TABLE ONLY post ALTER COLUMN id SET DEFAULT nextval('post_id_seq'::regclass);



ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);



ALTER TABLE ONLY post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);



ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);



ALTER TABLE ONLY post
    ADD CONSTRAINT fk455dwbntke4dylt74tdbc90s1 FOREIGN KEY (user_id) REFERENCES "user"(id);



ALTER TABLE ONLY post_upvotes_user_ids
    ADD CONSTRAINT fkmbxiflpmkd3vwupmr9m7hvvfl FOREIGN KEY (post_id) REFERENCES post(id);



