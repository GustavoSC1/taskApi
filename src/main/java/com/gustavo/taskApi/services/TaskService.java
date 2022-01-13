package com.gustavo.taskApi.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.taskApi.dtos.TaskDto;
import com.gustavo.taskApi.dtos.TaskNewDto;
import com.gustavo.taskApi.entities.Task;
import com.gustavo.taskApi.entities.User;
import com.gustavo.taskApi.repositories.TaskRepository;
import com.gustavo.taskApi.services.exceptions.ObjectNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserService userService;
	
	public TaskDto find(Long id) {
		return new TaskDto(findById(id));
	}
	
	public TaskDto insert(TaskNewDto dto) {
		User user = userService.findById(dto.getUserId());
		Task task = new Task(null, dto.getTitle(), dto.getDescription(), LocalDate.now(), null, user);
		
		task = taskRepository.save(task);
		return new TaskDto(task);
	}
	
	public Task findById(Long id) {
		Optional<Task> taskOptional = taskRepository.findById(id);
		Task task = taskOptional.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " + Task.class.getName()));
	
		return task;
	}

}