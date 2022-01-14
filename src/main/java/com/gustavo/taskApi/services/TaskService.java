package com.gustavo.taskApi.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public TaskDto update(Long id, TaskNewDto dto) {
		Task task = findById(id);
		task.setRegistrationDate(LocalDate.now());
		task.setDescription(dto.getDescription());
		task.setTitle(dto.getTitle());
		
		task = taskRepository.save(task);
		
		return new TaskDto(task);
	}
	
	public void delete(Long id) {
		Task task = findById(id);
		taskRepository.delete(task);
	}
	
	public void finishTask(Long id) {
		Task task = findById(id);
		task.setDateConclusion(LocalDate.now());
		taskRepository.save(task);
	}
	
	public Task findById(Long id) {
		Optional<Task> taskOptional = taskRepository.findById(id);
		Task task = taskOptional.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " + Task.class.getName()));
	
		return task;
	}

	public Page<TaskDto> findPage(String filter, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return taskRepository.findByDescription(filter, pageRequest).map(obj -> new TaskDto(obj));
	}

}
