package com.gustavo.taskApi.dtos;

public class TaskNewDto {
	
	private Long userId;
	
	private String title;
	
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
