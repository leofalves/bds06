package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDetailsDto;
import com.devsuperior.movieflix.dto.MovieMinDto;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MovieMinDto>> findByGenre(@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable){
		
		Page<MovieMinDto> result = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDetailsDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

}
