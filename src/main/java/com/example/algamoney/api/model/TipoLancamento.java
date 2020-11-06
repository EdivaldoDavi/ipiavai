package com.example.algamoney.api.model;

public enum TipoLancamento {
	RECEITA("Entradas"),
	DESPESA("Saídas");
	
	private final String descricao;
	
	TipoLancamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
