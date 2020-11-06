package com.example.algamoney.api.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.FotoPessoa;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.FotoPessoaRepository;
import com.example.algamoney.api.service.FotoPessoaService;

@RestController
@RequestMapping("/fotos")
public class FotoPessoaResource {
	
	@Autowired 
	private FotoPessoaRepository fotoPessoaRepository;
	
	@Autowired
	private FotoPessoaService fotoPessoaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	 
	@Autowired 
	private MessageSource messageSource;
	
	@PostMapping("/fotoPessoa")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")	
	public ResponseEntity<FotoPessoa> criar(@Valid @RequestBody FotoPessoa fotoPessoa, HttpServletResponse response){
		FotoPessoa fotoPessoaSalva = fotoPessoaService.salvar(fotoPessoa);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, fotoPessoa.getIdFoto()));
		return ResponseEntity.status(HttpStatus.CREATED).body(fotoPessoaSalva);
		
	}
	
	
	@GetMapping("/{codigo}")
	public FotoPessoa buscarFotoPessoaPelocodigo(@PathVariable Long codigo){
		Optional<FotoPessoa> fotoPessoa = fotoPessoaRepository.findById(codigo);
		if(!fotoPessoa.isPresent()){
			throw new GerarException("Foto Pessoa não cadastrado!"); 
		}
		return fotoPessoa.get();
	}
}
