package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(nativeQuery = true, value  = "SELECT * FROM tb_movie "
			+ " WHERE (:genreId = 0 OR genre_id = :genreId) ")
	Page<Movie> searchByGenre(Long genreId, Pageable pageable);

}
