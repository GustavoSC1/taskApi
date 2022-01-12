package com.gustavo.taskApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.taskApi.dtos.UsuarioDto;
import com.gustavo.taskApi.dtos.UsuarioNewDto;
import com.gustavo.taskApi.entities.Usuario;
import com.gustavo.taskApi.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioDto insert(UsuarioNewDto dto) {
		Usuario usuario = new Usuario(null, dto.getNome(), dto.getDataNascimento(), dto.getCpf(), dto.getEmail(), dto.getSenha());
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDto(usuario);
	}

}
