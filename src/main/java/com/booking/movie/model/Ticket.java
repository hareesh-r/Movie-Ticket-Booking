package com.booking.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketID;
	
	@Column(name="movieID")
	private int movieID;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="no_of_tickets")
	private int noOfTickets;
	
	@Column(name="timestamp")
	private String timestamp;

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Ticket() {
		super();
	}

	public Ticket(int ticketID, int movieID, int userID, int noOfTickets, String timestamp) {
		super();
		this.ticketID = ticketID;
		this.movieID = movieID;
		this.userID = userID;
		this.noOfTickets = noOfTickets;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Ticket [ticketID=" + ticketID + ", movieID=" + movieID + ", userID=" + userID + ", noOfTickets="
				+ noOfTickets + ", timestamp=" + timestamp + "]";
	}
	
}
