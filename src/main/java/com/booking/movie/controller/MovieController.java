package com.booking.movie.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.movie.service.MovieService;
import com.google.gson.Gson;

@CrossOrigin("http://127.0.0.1:5500/")
@RestController
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
		} catch (Exception e) {
			return "Movie not Found with the given id" + id + e.getMessage();
		}
	}

	@RequestMapping(value = "/movies", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String addMovie(@RequestParam Map<String, String> requestParams) throws Exception {
		try {
			String name = requestParams.get("name");
			int movieID = Integer.parseInt(requestParams.get("movieID"));
			int ticketPrice = Integer.parseInt(requestParams.get("ticket_price"));
			int availableTickets = Integer.parseInt(requestParams.get("available_tickets"));
			int totalTickets = Integer.parseInt(requestParams.get("total_tickets"));
			movieService.addMovie(movieID, name, ticketPrice, availableTickets, totalTickets);
			System.out.println(name+" "+movieID+" "+ticketPrice+" "+availableTickets+" "+totalTickets);
			return "Movie Added Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Movie addition Failed please check for errors";
		}
	}

	@RequestMapping(value = "/movies", produces = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public String updateMovie(@RequestParam Map<String, String> requestParams) throws Exception {
		try {
			String name = requestParams.get("name");
			int movieID = Integer.parseInt(requestParams.get("movieID"));
			int ticketPrice = Integer.parseInt(requestParams.get("ticket_price"));
			int availableTickets = Integer.parseInt(requestParams.get("available_tickets"));
			int totalTickets = Integer.parseInt(requestParams.get("total_tickets"));
			movieService.updateMovie(movieID, name, ticketPrice, availableTickets, totalTickets);
			return "Movie Updated Successfully";
		} catch (Exception e) {
			return "Movie Updation Failed please check for errors";
		}
	}

}
