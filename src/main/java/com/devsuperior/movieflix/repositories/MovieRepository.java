package com.devsuperior.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.dto.MovieDetailsDto;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(nativeQuery = true, value  = "SELECT * FROM tb_movie "
			+ " WHERE (:genreId = 0 OR genre_id = :genreId) "
			+ " ORDER BY title")
	Page<Movie> searchByGenre(Long genreId, Pageable pageable);
	
	@Query(value = "SELECT new com.devsuperior.movieflix.dto.MovieDetailsDto(obj.id, obj.title, obj.subTitle, obj.year, obj.imgUrl, obj.synopsis, obj.genre.id, obj.genre.name) "
			+ "FROM Movie obj "
			+ "WHERE obj.id = :id")
	Optional<MovieDetailsDto> searchById(Long id);

}
