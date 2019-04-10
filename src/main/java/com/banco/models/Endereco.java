package com.banco.models;

public class Endereco {
	private int id;
	private String logradouro;
	private String cep;
	private int numero;
	private String complemento;
	private String cidade;
	
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
