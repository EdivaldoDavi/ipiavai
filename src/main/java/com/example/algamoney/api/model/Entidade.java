package com.example.algamoney.api.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name = "entidade")
	public class Entidade {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private Long idEntidade;
		@NotNull
		@Size(min = 3 , max = 40)
		private String razaoSocial;
		

		@Embedded
		private Endereco endereco;
		
		@NotNull
		private Boolean ativo;

		public Entidade(long id) {
			this.idEntidade = id;
		}
		
		public Entidade() {
		}

		@JsonIgnore
		@Transient
		public boolean isInativo(){
			return !this.ativo;
		}

		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public Boolean getAtivo() {
			return ativo;
		}

		public void setAtivo(Boolean ativo) {
			this.ativo = ativo;
		}

		public Long getIdEntidade() {
			return idEntidade;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idEntidade == null) ? 0 : idEntidade.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entidade other = (Entidade) obj;
			if (idEntidade == null) {
				if (other.idEntidade != null)
					return false;
			} else if (!idEntidade.equals(other.idEntidade))
				return false;
			return true;
		}
		


}
