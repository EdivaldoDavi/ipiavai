package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.example.algamoney.api.model.FotoPessoa;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.model.Usuario;
import com.example.algamoney.api.repository.FotoPessoaRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.repository.UsuarioRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;
import com.example.algamoney.api.service.exception.UsuarioInexistenteOuInativoException;
import com.example.algamoney.api.storage.S3;


 

@Service
public class FotoPessoaService {

	@Autowired
	private FotoPessoaRepository fotoPessoaRepository;
	
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private S3 s3;
	
 
	public FotoPessoa salvar(FotoPessoa fotoPessoa) {
	Optional<Pessoa> pessoa = pessoaRepository.findById(fotoPessoa.getPessoa().getIdPessoa());
	
	if (StringUtils.hasText(fotoPessoa.getFotoNome())) {
		s3.salvar(fotoPessoa.getFotoNome());
	}
	if(!pessoa.isPresent() || !pessoa.get().getAtivo()){
		throw new PessoaInexistenteOuInativaException();
	}
	
	Optional<Usuario> usuario = usuarioRepository.findById(fotoPessoa.getUsuario().getCodigo());
	if(!usuario.isPresent() || !usuario.get().isAtivo()) {
		throw new UsuarioInexistenteOuInativoException();
	}
	
	return fotoPessoaRepository.save(fotoPessoa);
}
	
	
	
}
