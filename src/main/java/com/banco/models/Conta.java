package com.banco.models;

import java.sql.Date;

public class Conta {

	private int id;
	private String cpf;
	private double saldo;
	private Date dataDeAbertura;
	private double salarioBruto;
	private double salarioLiquido;

	//Construtor
	public Conta(int id, String cpf, double saldo, Date dataDeAbertura, double SalarioBruto, 
			     double salarioLiquido) {

	this.id = id;
	this.cpf = cpf;
	this.saldo = saldo;
	this.dataDeAbertura = dataDeAbertura;
	this.salarioBruto = SalarioBruto;
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
	
	public Date getDatadeAbertura() {
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
    
    public void setData(Date dataDeAbertura) {
    	this.dataDeAbertura = dataDeAbertura;
    }
    
    public void setSalarioBruto(double salarioBruto) {
    	this.salarioBruto = salarioBruto;
    }
    
    public void setSalarioLiquido(double salarioLiquido) {
    	this.salarioLiquido = salarioLiquido;
    }
	
	
	
	
	

}
