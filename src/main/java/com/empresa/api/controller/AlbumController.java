package com.empresa.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/album")
public class AlbumController 
{
	@PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
	@GetMapping("/list")
	public String obtenerAlbum()
	{
		return "Solo un usuario y admin pueden verme";
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/save")
	public String insertarAlbum()
	{
		return "Solo un admin puede verme";
	}
}
