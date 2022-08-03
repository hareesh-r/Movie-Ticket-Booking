package com.booking.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booking.movie.model.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query(value = "SELECT * FROM Movies WHERE movieID = :id", nativeQuery = true)
	Movie getMovieByID(@Param("id") Integer id);
		
		
}
