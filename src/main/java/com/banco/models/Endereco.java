package com.banco.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String logradouro;
	@NotNull
	private String cep;
	@NotNull
	private int numero;
	@NotNull
	private String complemento;
	@NotNull
	private String cidade;
	
	@OneToOne
	Usuario usuario;
	
	//Construtores
	public Endereco() {
		
	}
	
	public Endereco(int id, String logradouro, String cep, int numero, String complemento, String cidade) {
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
	}
	
	//Getters
	
	public int getId() {
		return id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getCep() {
		return cep;
	}
	public int getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getCidade() {
		return cidade;
	}
	
	//Setters
	
	public void setId(int id) {
		this.id = id;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	
	
}
