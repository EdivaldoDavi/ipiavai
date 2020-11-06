--changeset Edivaldo:1
CREATE TABLE escolaridade
(
  codigo bigint  NOT NULL DEFAULT nextval(('escolaridade_id_seq'::text)::regclass),
  descricao character varying(20),
  CONSTRAINT codigo_escolaridade_pkey PRIMARY KEY  (codigo) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence escolaridade_id_seq;


INSERT INTO escolaridade (descricao) values ('Fundamental');
INSERT INTO escolaridade (descricao) values ('Médio');
INSERT INTO escolaridade (descricao) values ('Superior');


  