--changeset Edivaldo:1
CREATE TABLE pessoa 
(  
	id_pessoa bigint  NOT NULL DEFAULT nextval(('pessoa_id_seq'::text)::regclass),
  cd_entidade bigint NOT NULL,
  nome character varying(80) NOT NULL,
  pai character varying(80),
  mae character varying(80) NOT NULL,
  sexo bigint  NOT NULL,
  estado_civil bigint NOT NULL,
  data_nasc Date NOT NULL,
  escolaridade bigint NOT NULL,
  profissao character varying(80),
  email character varying(80),
  nacionalidade character varying(40),
  naturalidade character varying(80),
  telefone character varying(14),
  celular character varying(14),
  origem_religiosa bigint,
  igreja_origem character varying(80),
  logradouro character varying(80),
  numero character varying(10),
  complemento character varying(40),
  bairro character varying(40),
  cep character varying(15),
  cidade character varying(30),
  estado character varying(2),
  ativo boolean ,
  CONSTRAINT idPessoa_pkey PRIMARY KEY  (id_pessoa) 
)
WITH (
  OIDS=FALSE
);
  
  create sequence pessoa_id_seq;


INSERT INTO pessoa (cd_entidade,nome , pai, mae, sexo, estado_civil, data_nasc, escolaridade, profissao,email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo)
values (1, 'Edivaldo Davi Severiano',  'João David Severiano', 'Maria Leonor Venerando','1', 1, '1970-03-12',1, 'Agente Seg. Penit.', '','Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim', 'Rua Crhistiano Pagani','1049','Apto. 63F','Jd. Auri Verde','17047144','Bauru','SP', true
);

INSERT INTO pessoa (cd_entidade,nome , pai, mae,sexo, estado_civil, data_nasc, escolaridade, profissao, email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Eliana Aparecida Araújo', 'João David Severiano', 'Maria Leonor Venerando', '1',1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','Rua Crhistiano Pagani','1049','Apto. 63F','Jd. Auri Verde','17047144','Bauru','SP', true);

INSERT INTO pessoa (cd_entidade,nome , pai, mae,sexo, estado_civil, data_nasc, escolaridade, profissao, email,nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Maria Leonor Venerando Severiano', 'João David Severiano', 'Maria Leonor Venerando', '1',1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim', 'Rua Cincinato Braga','263','','Palmital','17509005','Marília','SP',true);

INSERT INTO pessoa (cd_entidade,nome , pai, mae,sexo, estado_civil, data_nasc, escolaridade, profissao, email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Ednei Douglas Severiano', 'João David Severiano', 'Maria Leonor Venerando','1', 1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','','','','jd. Bandeirantes','17500000','Marília','SP',true);

INSERT INTO pessoa (cd_entidade,nome , pai, mae,sexo, estado_civil, data_nasc, escolaridade, profissao, email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'João David Severiano', 'João David Severiano', 'Maria Leonor Venerando','1', 1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','logradouro', '','','Jd. Planalto','','Marília','SP', true);

INSERT INTO pessoa (cd_entidade,nome, pai, mae, sexo, estado_civil, data_nasc, escolaridade, profissao, email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Edson David Severiano', 'João David Severiano', 'Maria Leonor Venerando', '1',1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','','','','Jd. Marajó','17500000','Marília','SP',true);

INSERT INTO pessoa (cd_entidade,nome, pai, mae, sexo, estado_civil, data_nasc, escolaridade, profissao,email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Eder Carlos Severiano', 'João David Severiano', 'Maria Leonor Venerando','1',1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','','','','Jd. Bandeirantes','175000005','Marília','SP', true);


INSERT INTO pessoa (cd_entidade,nome , pai, mae, sexo, estado_civil, data_nasc, escolaridade, profissao, email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Rodrigo bicas', 'João David Severiano', 'Maria Leonor Venerando', '1',1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','Rua Crhistiano Pagani','1055','','Jd. bela vista','17147144','Bauru','SP',false);

INSERT INTO pessoa (cd_entidade,nome , pai, mae, sexo, estado_civil, data_nasc, escolaridade, profissao, email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Eduardo Moino', 'João David Severiano', 'Maria Leonor Venerando', '1',1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','Rua 13 de maio','149','','Centro','170310000','Piurajuí','SP', true);

INSERT INTO pessoa (cd_entidade,nome , pai, mae, sexo, estado_civil, data_nasc, escolaridade, profissao, email, nacionalidade,
	naturalidade, telefone, celular, origem_religiosa, igreja_origem,  logradouro ,numero,complemento, bairro,cep, cidade,estado ,ativo) 
values (1,'Danilo Yoshida', 'João David Severiano', 'Maria Leonor Venerando', '1',1, '1970-03-12',1, 'Agente Seg. Penit.','', 'Brasileira', 'Marília-SP','14-999655-2177',
		'14-3010-2905',1,'Assembléia de Deus Min. Deus cuida de Mim','Rua Paulista','109','Apto. 63F','Centro','18047144','Duartina','SP',false);

  