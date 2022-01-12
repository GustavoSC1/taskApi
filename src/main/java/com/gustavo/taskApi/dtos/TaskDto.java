package com.gustavo.taskApi.dtos;

import java.time.LocalDate;

import com.gustavo.taskApi.entities.Task;

public class TaskDto {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private LocalDate registrationDate;
	
	private LocalDate dateConclusion;
	
	public TaskDto() {
		
	}

	public TaskDto(Task task) {
		super();
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.registrationDate = task.getRegistrationDate();
		this.dateConclusion = task.getDateConclusion();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public LocalDate getDateConclusion() {
		return dateConclusion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setDateConclusion(LocalDate dateConclusion) {
		this.dateConclusion = dateConclusion;
	}

}
