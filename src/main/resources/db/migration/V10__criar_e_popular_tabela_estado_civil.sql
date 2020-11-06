--changeset Edivaldo:1
CREATE TABLE estadocivil
(
  codigo bigint  NOT NULL DEFAULT nextval(('estado_civil_id_seq'::text)::regclass),
  descricao character varying(255),
  CONSTRAINT codigo_estadocivil_pkey PRIMARY KEY  (codigo) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence estado_civil_id_seq;


INSERT INTO estadocivil (descricao) values ('Solteiro');
INSERT INTO estadocivil (descricao) values ('Casado');
INSERT INTO estadocivil (descricao) values ('Separado');
INSERT INTO estadocivil (descricao) values ('Divorciado');
INSERT INTO estadocivil (descricao) values ('Viúvo');

  