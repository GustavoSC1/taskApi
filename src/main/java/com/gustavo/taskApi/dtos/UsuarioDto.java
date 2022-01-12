package com.gustavo.taskApi.dtos;

import java.time.LocalDate;

import com.gustavo.taskApi.entities.Usuario;

public class UsuarioDto {
	
	private Long id;
	
	private String nome;
	
	private LocalDate dataNascimento;
	
	private String cpf;
	
	private String email;

	public UsuarioDto(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.dataNascimento = usuario.getDataNascimento();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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

}
