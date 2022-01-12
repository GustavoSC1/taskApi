package com.gustavo.taskApi.dtos;

import java.time.LocalDate;

import com.gustavo.taskApi.entities.User;

public class UserDto {
	
	private Long id;
	
	private String name;
	
	private LocalDate birthDate;
	
	private String cpf;
	
	private String email;
	
	public UserDto() {
		
	}

	public UserDto(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.birthDate = user.getBirthDate();
		this.cpf = user.getCpf();
		this.email = user.getEmail();
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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
