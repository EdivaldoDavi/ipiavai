package com.example.algamoney.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.model.Permissao;
import com.example.algamoney.api.model.Usuario;
import com.example.algamoney.api.repository.PermissaoRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource {
	@Autowired
	private PermissaoRepository  permissaoRepository;
 
	@GetMapping("/todas")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO') ")
	public List<Permissao> listar(){
		return permissaoRepository.findAll();
	}
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_USUARIO')")
	public Page<Permissao> pesquisar(@RequestParam(required = false, defaultValue = "%") String descricao, Pageable pageable) {
		return permissaoRepository.findByDescricaoIgnoreCaseContaining(descricao, pageable);
	}
}
