package com.booking.movie.service;

import java.util.List;

import com.booking.movie.model.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();

	int bookTickets(int movieID, int userID, int ticketID, int noOfTickets);

	int isAvailable(int movieID);

	int updateMovies(int movieID, int noOfTickets);
}
