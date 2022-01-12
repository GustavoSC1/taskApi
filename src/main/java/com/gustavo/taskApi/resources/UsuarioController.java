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

import com.gustavo.taskApi.dtos.UsuarioNewDto;
import com.gustavo.taskApi.dtos.UsuarioDto;
import com.gustavo.taskApi.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping()
	public ResponseEntity<UsuarioDto> insert(@RequestBody @Valid UsuarioNewDto usuarioDto) {
		UsuarioDto obj = usuarioService.insert(usuarioDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
