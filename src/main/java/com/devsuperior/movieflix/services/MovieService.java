package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDetailsDto;
import com.devsuperior.movieflix.dto.MovieMinDto;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository repository;

	@Transactional(readOnly = true)
	public Page<MovieMinDto> findAll(Pageable pageable){
		Page<Movie> page = repository.findAll(pageable);
		return page.map(x -> new MovieMinDto(x));
	}
	
	@Transactional(readOnly = true)
	public Page<MovieMinDto> findByGenre(Long genreId, Pageable pageable){
		Page<Movie> page = repository.searchByGenre(genreId, pageable);
		return page.map(x -> new MovieMinDto(x));
	}
	
	@Transactional(readOnly = true)
	public MovieDetailsDto findById (Long id) {
		Optional<MovieDetailsDto> obj = repository.searchById(id);
		MovieDetailsDto movieDetailsDto = obj.orElseThrow(() -> new com.devsuperior.movieflix.services.exceptions.EntityNotFoundException("Entity Not Found"));
		return movieDetailsDto;
	}
}
