package com.gustavo.taskApi.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "{id}")
	public ResponseEntity<TaskDto> find(@PathVariable Long id) {
		TaskDto obj = taskService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody @Valid TaskNewDto taskDto) {
		TaskDto obj = taskService.insert(taskDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<TaskDto> update(@Valid @RequestBody TaskNewDto taskDto, @PathVariable Long id) {
		TaskDto obj = taskService.update(id, taskDto);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value= "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		taskService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping(value= "{id}")
	public ResponseEntity<Void> finishTask(@PathVariable Long id) {
		taskService.finishTask(id);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value="/page")
	public ResponseEntity<Page <TaskDto>> findPage(
			@RequestParam(value="filter", defaultValue="") String filter, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="description") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		
		Page<TaskDto> list = taskService.findPage(filter, page, linesPerPage, orderBy, direction);
		
		return ResponseEntity.ok().body(list);
	}
	
}
