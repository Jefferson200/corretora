package com.banco.models;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private int tipo;
	private String senha;
	
	//Construtor
	public Usuario() {
		
	}
	public Usuario(int id, String nome, String email, String cpf, String telefone, int tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.tipo = tipo;
	}
	
	//Getters
	public String getSenha() {
		return senha;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public int getTipo() {
		return tipo;
	}
	
	//Setters
	public void setSenha(String senha) {
		this.senha=senha;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	

}
