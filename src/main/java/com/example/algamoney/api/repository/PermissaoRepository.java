package com.example.algamoney.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	public Page<Permissao> findByDescricaoIgnoreCaseContaining(String descricao, Pageable pageable);
}
