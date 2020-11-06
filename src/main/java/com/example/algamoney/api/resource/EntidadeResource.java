package com.example.algamoney.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.model.Entidade;
import com.example.algamoney.api.repository.EntidadeRepository;
import com.example.algamoney.api.service.GerarException;

@RestController
@RequestMapping("/Entidades")
public class EntidadeResource {
	
	@Autowired
	EntidadeRepository entidadeRepository;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public List<Entidade> listar(){
		return entidadeRepository.findAll();
	}

	@GetMapping("/{idEntidade}")
	public  Entidade buscarEntidadePeloId(@PathVariable Long idEntidade){
		Optional<Entidade> entidade = entidadeRepository.findById(idEntidade);
		if(!entidade.isPresent()){
			throw new GerarException("Entidade não cadastrada!"); 
		}
		return entidade.get();
	}	

}
