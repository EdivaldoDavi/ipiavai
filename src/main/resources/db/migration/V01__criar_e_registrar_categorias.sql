--changeset Edivaldo:1
CREATE TABLE categoria
(
  codigo bigint  NOT NULL DEFAULT nextval(('categoria_id_seq'::text)::regclass),
  nome character varying(255),
  CONSTRAINT codigo_pkey PRIMARY KEY  (codigo) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence categoria_id_seq;


INSERT INTO categoria (nome) values ('Lazer');
INSERT INTO categoria (nome) values ('Alimentação');
INSERT INTO categoria (nome) values ('Supermercado');
INSERT INTO categoria (nome) values ('Farmácia');
INSERT INTO categoria (nome) values ('Outros');

  