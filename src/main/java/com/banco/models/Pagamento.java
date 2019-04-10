package com.banco.models;

public class Pagamento {

	private String cpf;
	private int qtdParcelas;
	private int qtdParcelasPagas;

	public Pagamento() {}

	//Construtor
	public Pagamento(String cpf, int qtdParcelas, int qtdParcelasPagas) {

		this.cpf = cpf;
		this.qtdParcelas = qtdParcelas;
		this.qtdParcelasPagas = qtdParcelasPagas;
	}

	//Getters
    public String getCpf() {
    	return cpf;
    }
    
    public int getQtdParcelas() {
    	return qtdParcelas;
    }
    
    public int getQtdParcelasPagas() {
    	return qtdParcelasPagas;
    }
    
    //Setters
    public void setCpf(String cpf) {
    	this.cpf = cpf;    	
    }
    
    public void setQtdParcelas(int qtdParcelas) {
    	this.qtdParcelas = qtdParcelas;
    }
    
    public void setQtdParcelasPagas(int qtdParcelasPagas) {
    	this.qtdParcelasPagas = qtdParcelasPagas;
    }





}
