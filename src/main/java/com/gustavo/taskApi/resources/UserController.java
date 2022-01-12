package com.gustavo.taskApi.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.taskApi.dtos.UserNewDto;
import com.gustavo.taskApi.dtos.UserDto;
import com.gustavo.taskApi.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<UserDto> find(@PathVariable Long id) {
		UserDto obj = userService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody @Valid UserNewDto userDto) {
		UserDto obj = userService.insert(userDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<UserDto> update(@Valid @RequestBody UserNewDto userDto, @PathVariable Long id) {
		UserDto obj = userService.update(id, userDto);
		
		return ResponseEntity.ok().body(obj);
	}

}
