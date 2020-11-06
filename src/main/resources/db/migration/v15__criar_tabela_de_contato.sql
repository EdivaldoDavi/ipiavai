CREATE TABLE contato (
 codigo bigint  NOT NULL  DEFAULT nextval(('contato_id_seq'::text)::regclass),
 codigo_pessoa bigint NOT NULL,
	nome character varying(50),
	email character varying(100), NOT NULL,
	telefone character varying(20), NOT NULL,
	CONSTRAINT codigo_contato_pkey PRIMARY KEY  (codigo),
	
	 CONSTRAINT fkcontato FOREIGN KEY (codigo_pessoa)
      REFERENCES contato (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
  
) 

insert into contato (codigo, codigo_pessoa, nome, email, telefone) values (1, 1, 'Marcos Henrique', 'marcos@algamoney.com', '00 0000-0000');