package com.gustavo.taskApi.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TaskNewDto {
	
	@NotNull(message = "O Id do Usuário não pode ser vazia")
	private Long userId;
	
	@NotEmpty(message = "O título da tarefa não pode ser vazio")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String title;
	
	@NotEmpty(message = "A descrição da tarefa não pode ser vazia")
	private String description;
	
	public TaskNewDto() {
		
	}

	public TaskNewDto(Long userId, String title, String description) {
		super();
		this.userId = userId;
		this.title = title;
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
