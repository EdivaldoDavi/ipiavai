package com.example.algamoney.api.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.algamoney.api.repository.listener.PessoaFotoListener;

@EntityListeners(PessoaFotoListener.class)
@Entity
@Table(name = "fotopessoa" )
public class FotoPessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idFoto;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cd_id_pessoa")
	private Pessoa pessoa;
 
	
	@NotNull
	private String fotoNome;
	
	@Transient
	private String urlAnexo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cd_usuario")
	private Usuario usuario;

	public String getFotoNome() {
		return fotoNome;
	}

	public void setFotoNome(String fotoNome) {
		this.fotoNome = fotoNome;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public Pessoa getPessoa() {
		return pessoa;
	}

	
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getUrlAnexo() {
		return urlAnexo;
	}

	public void setUrlAnexo(String urlAnexo) {
		this.urlAnexo = urlAnexo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFoto == null) ? 0 : idFoto.hashCode());
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
		FotoPessoa other = (FotoPessoa) obj;
		if (idFoto == null) {
			if (other.idFoto != null)
				return false;
		} else if (!idFoto.equals(other.idFoto))
			return false;
		return true;
	}

	
	
	
	

}
