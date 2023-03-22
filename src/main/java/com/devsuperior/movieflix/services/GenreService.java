package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDto;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	GenreRepository repository;
	
	@Transactional(readOnly = true)
	public List<GenreDto> findAll(){
		List<Genre> list = repository.findAll();
		return list.stream().map(x -> new GenreDto(x)).toList();
	}

}
