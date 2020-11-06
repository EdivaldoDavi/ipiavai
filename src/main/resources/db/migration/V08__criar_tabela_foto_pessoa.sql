--changeset Edivaldo:1
CREATE TABLE fotoPessoa
(
  id_foto bigint  NOT NULL DEFAULT nextval(('fotoPessoa_id_seq'::text)::regclass),
  cd_id_pessoa bigint NOT NULL,
  foto_nome character varying(255),
  data_hora timestamp without time zone DEFAULT now(),
  cd_usuario bigint NOT NULL,
  CONSTRAINT id_foto_pkey PRIMARY KEY  (id_foto), 
  
	 CONSTRAINT fk_foto_pessoa FOREIGN KEY (cd_id_pessoa)
      REFERENCES pessoa (id_pessoa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      
  
	 CONSTRAINT fk_usuario_foto_pessoa FOREIGN KEY (cd_usuario)
      REFERENCES usuario  (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION      
)
WITH (
  OIDS=FALSE
);
  
  create sequence fotoPessoa_id_seq;