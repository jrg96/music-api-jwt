package com.empresa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.api.entity.Album;
import com.empresa.api.service.IAlbumService;

@RestController
@RequestMapping("/api/album")
public class AlbumController 
{
	@Autowired
	private IAlbumService albumService;
	
	@PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
	@GetMapping("/list")
	public List<Album> obtenerAlbum()
	{
		return this.albumService.buscarTodas();
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/save")
	public Album insertarAlbum(@RequestBody Album album)
	{
		this.albumService.guardar(album);
		return album;
	}
}
