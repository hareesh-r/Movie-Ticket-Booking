package com.booking.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booking.movie.service.MovieService;
import com.google.gson.Gson;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movies", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public String getMovie() {
		Gson gson = new Gson();
		return gson.toJson(movieService.getAllMovies());
	}
	
	@RequestMapping(value = "/movies/id", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public String getMovieByID(@RequestParam String id) {
		try {
			System.out.println(id);
			Gson gson = new Gson();
			return gson.toJson(movieService.getMovieByID(Integer.parseInt(id)));
		}catch(Exception e){
			return "Movie not Found with the given id"+id+e.getMessage();
		}
	}
	
}
