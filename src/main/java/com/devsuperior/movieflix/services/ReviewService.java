package com.devsuperior.movieflix.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository repository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	AuthService authService;
	
	public @Valid ReviewDTO insert(@Valid ReviewDTO dto) {
		Review review = new Review();
		review.setId(dto.getId());
		review.setText(dto.getText());
		
		Movie movie = movieRepository.getOne(dto.getMovieId());
		review.setMovie(movie);
		
		User user = authService.authenticated();
		review.setUser(user);
		
		review = repository.save(review);
		
		return new ReviewDTO(review);
		
	}

}
