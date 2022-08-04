package com.booking.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.movie.model.Movie;
import com.booking.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	@Override
	public Movie getMovieByID(Integer id) {
		return movieRepository.getMovieByID(id);
	}

	@Override
	public void addMovie(int movieID, String name, int ticketPrice, int availableTickets, int totalTickets) {
		movieRepository.addMovie(movieID,name,ticketPrice,availableTickets,totalTickets);
		
	}

	@Override
	public void updateMovie(int movieID, String name, int ticketPrice, int availableTickets, int totalTickets) {
		movieRepository.updateMovie(movieID,name,ticketPrice,availableTickets,totalTickets);
	}


}
