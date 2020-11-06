--changeset Edivaldo:1
CREATE TABLE entidade
(
  id_entidade bigint  NOT NULL DEFAULT nextval(('entidade_id_seq'::text)::regclass),
  razao_social character varying(80) NOT NULL,
  logradouro character varying(80),
  numero character varying(10),
  complemento character varying(40),
  bairro character varying(40),
  cep character varying(15),
  cidade character varying(30),
  estado character varying(2),
  ativo boolean ,
  CONSTRAINT idEntidade_pkey PRIMARY KEY  (id_entidade) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence entidade_id_seq;


INSERT INTO entidade (razao_social ,logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo)
values ('3 Igreja Presbiteriana de Bauru','Alameda das Margaridas','735','','Pq. Vista Alegre','17020-530','Bauru','SP', true);


  