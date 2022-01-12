package com.gustavo.taskApi.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.taskApi.dtos.TaskDto;
import com.gustavo.taskApi.dtos.TaskNewDto;
import com.gustavo.taskApi.services.TaskService;

@RestController
@RequestMapping(value="/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody @Valid TaskNewDto taskDto) {
		TaskDto obj = taskService.insert(taskDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	

}
