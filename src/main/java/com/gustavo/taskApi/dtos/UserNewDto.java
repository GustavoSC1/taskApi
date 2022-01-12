package com.gustavo.taskApi.dtos;

import java.time.LocalDate;

public class UserNewDto {
	
	private String name;
	
	private LocalDate birthDate;
	
	private String cpf;
	
	private String email;
	
	private String password;
	
	public UserNewDto() {
		
	}

	public UserNewDto(String name, LocalDate birthDate, String cpf, String email, String password) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
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

	public void setPassword(String password) {
		this.password = password;
	}
	
}
