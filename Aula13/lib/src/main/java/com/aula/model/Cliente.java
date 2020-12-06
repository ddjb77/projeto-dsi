package com.aula.model;

public class Cliente {
	
	private int id;
	private String nome;
	private String endereco;
	private String tel;
	private String email;
	
	public Cliente() {
		
		
	}
	
	public Cliente(int id, String nome, String endereco, String tel, String email) {
			this.id = id;
			this.nome = nome;
			this.endereco = endereco;
			this.tel = tel;
			this.email = email;}
	

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}