package com.empresa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.api.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> 
{

}
