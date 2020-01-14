package com.empresa.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.api.entity.Album;
import com.empresa.api.repository.AlbumRepository;

@Service
public class AlbumServiceJpa implements IAlbumService
{
	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public void guardar(Album album) 
	{
		this.albumRepository.save(album);
	}

	@Override
	public List<Album> buscarTodas() 
	{
		return this.albumRepository.findAll();
	}

	@Override
	public Album buscarPorId(int id) 
	{
		Optional<Album> album = this.albumRepository.findById(id);
		if(album.isPresent())
		{
			return album.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) 
	{
		if (this.albumRepository.existsById(id))
		{
			this.albumRepository.deleteById(id);
		}
	}
	
}
