package com.empresa.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlbumController 
{
	@GetMapping("/albums")
	public String obtenerAlbum()
	{
		return "Hola mundo";
	}
}
