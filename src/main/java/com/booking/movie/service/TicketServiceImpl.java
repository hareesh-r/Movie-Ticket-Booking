package com.booking.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.movie.model.Ticket;
import com.booking.movie.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public List<Ticket> getAllTickets(){
		return ticketRepository.getAllTickets();
	}

	@Override
	public void bookTickets(int movieID, int userID,int ticketID, int noOfTickets) {
		ticketRepository.bookTickets(movieID, userID, ticketID, noOfTickets);
	}
}
