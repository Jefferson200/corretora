package com.banco.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private String email;
	
	private String cpf;
	
	private String telefone;
	
	private int tipo;
	
	private String senha;
	
	private Date data;
	
	//Construtor
	public Usuario() {
		
	}
	public Usuario(String nome, String email, String cpf, String telefone, int tipo, String senha, Date data) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.tipo = tipo;
		this.senha = senha;
		this.data = data;
	}
	
	//Getters
	public String getSenha() {
		return senha;
	}
	
	public Date getData() {
		return data;
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
	public void setData(Date  data) {
		this.data =data;
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
