package com.aula.model;

public class Concessionaria extends Cliente {
	
	private int id;
	private String nome;
	private String endereco;
	private String tel;
	private String email;
	private String nome_veiculo;
	private double preco_veiculo;
	
	public Concessionaria() {
		// TODO Auto-generated constructor stub
	}
	
	public Concessionaria(int id, String nome, String endereco, String tel, String email, String nome_veiculo, double preco_veiculo) {
			this.id = id;
			this.nome = nome;
			this.endereco = endereco;
			this.tel = tel;
			this.email = email;
			this.nome_veiculo = nome_veiculo;
			this.preco_veiculo = preco_veiculo;
			}
	

	


	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome_veiculo() {
		return nome_veiculo;
	}

	public void setNome_veiculo(String nome_veiculo) {
		this.nome_veiculo = nome_veiculo;
	}

	public double getPreco_veiculo() {
		return preco_veiculo;
	}

	public void setPreco_veiculo(double preco_veiculo) {
		this.preco_veiculo = preco_veiculo;
	}

	
	
}