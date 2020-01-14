package com.empresa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> 
{
	Usuario findByUsername(String username);
}
