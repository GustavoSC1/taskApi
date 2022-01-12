package com.gustavo.taskApi.dtos;

import java.time.LocalDate;

public class UsuarioNewDto {
	
private String nome;
	
	private LocalDate dataNascimento;
	
	private String cpf;
	
	private String email;
	
	private String senha;
	
	public UsuarioNewDto() {
		
	}

	public UsuarioNewDto(String nome, LocalDate dataNascimento, String cpf, String email, String senha) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
