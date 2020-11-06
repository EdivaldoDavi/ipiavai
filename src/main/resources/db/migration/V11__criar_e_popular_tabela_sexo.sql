--changeset Edivaldo:1
CREATE TABLE sexo
(
  codigo bigint  NOT NULL DEFAULT nextval(('sexo_id_seq'::text)::regclass),
  tipo character varying(20),
  CONSTRAINT codigo_sexo_pkey PRIMARY KEY  (codigo) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence sexo_id_seq;


INSERT INTO sexo (tipo) values ('Masculino');
INSERT INTO sexo (tipo) values ('Feminino');

  