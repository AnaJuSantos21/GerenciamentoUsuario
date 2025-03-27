package com.geruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geruser.entity.Usuario;

public interface UsuarioRepository extends  JpaRepository<Usuario, Long> {

}
