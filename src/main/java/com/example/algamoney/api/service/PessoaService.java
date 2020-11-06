package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.algamoney.api.model.Entidade;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;
import com.example.algamoney.api.storage.S3;


@Service
public class PessoaService {
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private S3 s3;
	
	public Pessoa salvar(Pessoa pessoa) {
		pessoa.setEntidade(new Entidade(1L));
		if (StringUtils.hasText(pessoa.getAnexo())) {
			s3.salvar(pessoa.getAnexo());
		}
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa atualizar(Long idPessoa, Pessoa pessoa){
		pessoa.setEntidade(new Entidade(1L));
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(idPessoa);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "idPessoa");

/*		
		if (StringUtils.hasText(pessoa.getAnexo())) {
			s3.salvar(pessoa.getAnexo());
		}
		*/
		if (StringUtils.hasText(pessoa.getAnexo())) {
			s3.salvar(pessoa.getAnexo());
		}

		return pessoaRepository.save(pessoaSalva);
		
	}


	public void atualizarPropriedadeAtivo(Long idPessoa, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(idPessoa);	
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPessoaPeloCodigo(Long idPessoa) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(idPessoa);
		if(!pessoaSalva.isPresent()){
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva.get();
	}

}
