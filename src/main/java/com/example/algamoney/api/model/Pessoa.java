package com.example.algamoney.api.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.algamoney.api.model.Escolaridade;
import com.example.algamoney.api.model.EstadoCivil;
import com.example.algamoney.api.model.OrigemReligiosa;
import com.example.algamoney.api.model.Sexo;
import com.example.algamoney.api.repository.listener.PessoaFotoListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@EntityListeners(PessoaFotoListener.class)
@Entity
@Table(name = "pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idPessoa;
	
	@NotNull
	@Size(min = 3 , max = 80)
	private String nome;
	
	@Size(min = 3 , max = 80)
	private String pai;
	
	@Size(min = 3 , max = 80)
	private String mae;
	
	
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "sexo")
	private Sexo sexo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "estado_civil")
	private EstadoCivil estadoCivil;

	@NotNull(message="Data de nascimento não pode ser vazio")
	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc")
	private Date dataNasc;

	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "escolaridade")
	protected Escolaridade escolaridade;
	
	
	@NotNull
	@Size(min = 3 , max = 80)
	private String profissao;

	
	@Size(min = 3 , max = 40)
	private String email;
	
	@NotNull
	@Size(min = 3 , max = 40)
	private String nacionalidade;

	@NotNull
	@Size(min = 3 , max = 80)
	private String naturalidade;
	
	@Size(min = 3 , max = 14)
	private String telefone;

	@Size(min = 3 , max = 14)
	private String celular;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinColumn(name = "origem_religiosa")
	protected OrigemReligiosa  origemReligiosa;
	
	@Size(min = 3 , max = 80)
	@Column(name="igreja_origem")
	private String igrejaOrigem;

	
	@ManyToOne
	@JoinColumn(name = "cd_entidade")
	private Entidade entidade;

	@Embedded
	private Endereco endereco;
	
	
	@NotNull
	private Boolean ativo;

	@JsonIgnore
	@Transient
	public boolean isInativo(){
		return !this.ativo;
	}
	
	@JsonIgnoreProperties("pessoa")
	@Valid
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Contato> contatos;
	private String anexo;
	
	
	@Transient
	private String urlAnexo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		return true;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public OrigemReligiosa getOrigemReligiosa() {
		return origemReligiosa;
	}

	public void setOrigemReligiosa(OrigemReligiosa origemReligiosa) {
		this.origemReligiosa = origemReligiosa;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	public String getIgrejaOrigem() {
		return igrejaOrigem;
	}

	public void setIgrejaOrigem(String igrejaOrigem) {
		this.igrejaOrigem = igrejaOrigem;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
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
		if (ativo == null) {
			this.ativo = true;
		}else {
			this.ativo = ativo;
		}
	}


	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getUrlAnexo() {
		return urlAnexo;
	}

	public void setUrlAnexo(String urlAnexo) {
		this.urlAnexo = urlAnexo;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	
	
	

}
