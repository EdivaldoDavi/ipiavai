package com.example.algamoney.api.repository.listener;

import javax.persistence.PostLoad;

import org.springframework.util.StringUtils;

import com.example.algamoney.api.AlgamoneyApiApplication;
import com.example.algamoney.api.model.FotoPessoa;
import com.example.algamoney.api.storage.S3;
import com.example.algamoney.api.model.Pessoa;
public class PessoaFotoListener {
	
	@PostLoad
	public void postLoad(Pessoa pessoa) {
		if (StringUtils.hasText(pessoa.getAnexo())) {
			S3 s3 = AlgamoneyApiApplication.getBean(S3.class);
			pessoa.setUrlAnexo(s3.configurarUrl(pessoa.getAnexo()));
		}
	}

}
