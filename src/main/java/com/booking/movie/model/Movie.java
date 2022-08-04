package com.booking.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="ticket_price")
	private int ticketPrice;
	
	@Column(name = "available_tickets")
	private int availableTickets;
	
	@Column(name = "total_tickets")
	private int totalTickets;
	
	@Column(name="revenue")
	private int revenue;

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}

	public int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}


	public Movie() {
		super();
	}

	public Movie(int movieID, String name, int ticketPrice, int availableTickets, int totalTickets, int revenue) {
		super();
		this.movieID = movieID;
		this.name = name;
		this.ticketPrice = ticketPrice;
		this.availableTickets = availableTickets;
		this.totalTickets = totalTickets;
		this.revenue = revenue;
	}

	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", name=" + name + ", ticketPrice=" + ticketPrice + ", availableTickets="
				+ availableTickets + ", totalTickets=" + totalTickets + ", revenue=" + revenue + "]";
	}
	
	
}
