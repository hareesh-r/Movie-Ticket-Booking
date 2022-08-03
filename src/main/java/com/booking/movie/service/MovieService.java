package com.booking.movie.service;

import java.util.List;

import com.booking.movie.model.Movie;


public interface MovieService {
	
	List<Movie> getAllMovies();
	
	Movie getMovieByID(Integer id);

	void addMovie(int movieID, String name, int ticketPrice, int availableTickets, int totalTickets);

	void updateMovie(int movieID, String name, int ticketPrice, int availableTickets, int totalTickets);

	
}
