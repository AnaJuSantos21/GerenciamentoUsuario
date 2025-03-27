package com.geruser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geruser.entity.Usuario;
import com.geruser.repository.UsuarioRepository;

//Na camada Service que está presente as funcionalidades get, get id, post, put, delete, sendo 5 funcionalidades

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	public List<Usuario> buscaTodosUsuarios() { //get
		return usuarioRepository.findAll();
	}
	public Usuario buscaUsuarioId(Long id) { //get by id
		Optional <Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}
	public Usuario salvaUsuario(Usuario Usuario) { //post
		return usuarioRepository.save(Usuario);
	}
	public Usuario alterarUsuario(Long id, Usuario alterarU) {  //put
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()) {
			alterarU.setId(id);
			return usuarioRepository.save(alterarU);
		}
		return null;
	}
	public boolean apagarUsuario(Long id) { //delete
		Optional <Usuario> existeUsuario = usuarioRepository.findById(id);
		if (existeUsuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
	

}
