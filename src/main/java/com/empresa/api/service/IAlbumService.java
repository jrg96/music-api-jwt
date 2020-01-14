package com.empresa.api.service;

import java.util.List;

import com.empresa.api.entity.Album;

public interface IAlbumService 
{
	void guardar(Album album);
	List<Album> buscarTodas();
	Album buscarPorId(int id);
	void eliminarPorId(int id);
}
