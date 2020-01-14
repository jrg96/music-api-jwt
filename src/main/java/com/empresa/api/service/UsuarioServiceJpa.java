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
		
		return new User(usuario.getUsername(), usuario.getPassword(), getAuthority(usuario));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(Usuario usuario) 
	{
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        
		usuario.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNombre()));
		});
		
		return authorities;
	}
}
