package com.empresa.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empresa.api.entity.Usuario;
import com.empresa.api.repository.UsuarioRepository;


/*
 * Clase de servicio ocupada para implementar nuestra propia logica de autenticacion
 * (debido a que nuestras tablas de la DB y manera de representar las "Authorities"
 * no es la default que ocupa Spring Security)
 * */
@Service
public class UsuarioServiceJpa implements UserDetailsService 
{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null)
		{
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		// Enviamos a Spring Secuirty, la informacion que le interesa para representar a un usuario
		return new User(usuario.getUsername(), usuario.getPassword(), getAuthority(usuario));
	}
	
	
	/*
	 * Logica de negocio propia para obtener las Authorities de un usuario en base a nuestra
	 * estructura dentro de la DB
	 * */
	private Set<SimpleGrantedAuthority> getAuthority(Usuario usuario) 
	{
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        
		usuario.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNombre()));
		});
		
		return authorities;
	}
}
