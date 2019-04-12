package com.banco.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Conta {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String cpf;
	@NotNull
	private double saldo;
	@NotNull
	private Date dataDeAbertura;
	@NotNull
	private double salarioBruto;
	@NotNull
	private double salarioLiquido;
	
	public Conta() {}
	
	//Construtor
	public Conta(String cpf, double saldo, Date dataDeAbertura, double salarioBruto, 
			     double salarioLiquido) {

	
	this.cpf = cpf;
	this.saldo = saldo;
	this.dataDeAbertura = dataDeAbertura;
	this.salarioBruto = salarioBruto;
	this.salarioLiquido = salarioLiquido;

	}
	
	//Gatters
	public int getId() {
		return id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}
	
	public double getSalarioBruto() {
		return salarioBruto;
	}
	
	public double getSalarioLiquido() {
		return salarioLiquido;
	}
	
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void setDataDeAbertura(Date dataDeAbertura) {
    	this.dataDeAbertura = dataDeAbertura;
    }
    
    public void setSalarioBruto(double salarioBruto) {
    	this.salarioBruto = salarioBruto;
    }
    
    public void setSalarioLiquido(double salarioLiquido) {
    	this.salarioLiquido = salarioLiquido;
    }
	
	
	
	
	

}
