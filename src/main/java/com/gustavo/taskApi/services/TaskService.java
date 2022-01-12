package com.gustavo.taskApi.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.taskApi.dtos.TaskDto;
import com.gustavo.taskApi.dtos.TaskNewDto;
import com.gustavo.taskApi.entities.Task;
import com.gustavo.taskApi.entities.User;
import com.gustavo.taskApi.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserService userService;
	
	public TaskDto insert(TaskNewDto dto) {
		User user = userService.findById(dto.getUserId());
		Task task = new Task(null, dto.getTitle(), dto.getDescription(), LocalDate.now(), null, user);
		
		task = taskRepository.save(task);
		return new TaskDto(task);
	}

}
