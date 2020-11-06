--changeset Edivaldo:1
CREATE TABLE origemreligiosa
(
  codigo bigint  NOT NULL DEFAULT nextval(('origem_religiosa_id_seq'::text)::regclass),
  descricao character varying(20),
  CONSTRAINT origem_religiosa_pkey PRIMARY KEY  (codigo) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence origem_religiosa_id_seq;

	
INSERT INTO origemreligiosa (descricao) values ('Evangélico');
INSERT INTO origemreligiosa (descricao) values ('Catolicismo');
INSERT INTO origemreligiosa (descricao) values ('Espiritismo');
INSERT INTO origemreligiosa (descricao) values ('Islamismo');
INSERT INTO origemreligiosa (descricao) values ('Judaísmo');
INSERT INTO origemreligiosa (descricao) values ('Budismo');
INSERT INTO origemreligiosa (descricao) values ('Afro Brasileira');
INSERT INTO origemreligiosa (descricao) values ('Ateu');



  