package com.booking.movie.service;

import java.util.List;

import com.booking.movie.model.Movie;


public interface MovieService {
	
	List<Movie> getAllMovies();
	
	Movie getMovieByID(Integer id);

	
}
