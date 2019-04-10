package com.banco.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String nome;
	@NotNull
	private String email;
	@NotNull
	private String cpf;
	@NotNull
	private String telefone;
	@NotNull
	private int tipo;
	@NotNull
	private String senha;
	@NotNull
	private Date dataNasc;
	
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
	
	public Date getDataNasc() {
		return dataNasc;
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
	public void setDataNasc(Date dataNasc) {
		this.dataNasc=dataNasc;
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
