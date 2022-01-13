package com.gustavo.taskApi.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class UserNewDto {
	
	@NotEmpty(message = "O nome não pode ser vazio")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
	
	@NotNull(message = "A data de nascimento não pode ser vazia")
	private LocalDate birthDate;
	
	@NotEmpty(message = "O cpf não pode ser vazio")
	@CPF(message="Cpf inválido")
	private String cpf;
	
	@NotEmpty(message = "O email não pode ser vazio")
	@Email(message="Email inválido")
	private String email;
	
	public UserNewDto() {
		
	}

	public UserNewDto(String name, LocalDate birthDate, String cpf, String email) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
