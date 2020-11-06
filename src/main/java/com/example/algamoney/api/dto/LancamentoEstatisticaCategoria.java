package com.example.algamoney.api.dto;
import java.math.BigDecimal;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.model.TipoLancamento;

public class LancamentoEstatisticaCategoria {
	
	private Categoria categoria;
	private TipoLancamento tipo;
	private BigDecimal total;
	

	public LancamentoEstatisticaCategoria(Categoria categoria, TipoLancamento tipo,  BigDecimal total) {
		this.categoria = categoria;
		this.tipo = tipo;
		this.total = total;
		
	}

	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	
	
	
}