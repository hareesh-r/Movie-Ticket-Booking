package com.booking.movie.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booking.movie.service.TicketService;
import com.google.gson.Gson;

@Controller
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	
	@RequestMapping(value="/tickets",produces="application/json",method=RequestMethod.GET)
	@ResponseBody
	public String getAllTickets() {
		Gson gson = new Gson();
		return gson.toJson(ticketService.getAllTickets());
	}
	
//	@RequestMapping(value="/ticketsInfo",produces="application/json",method=RequestMethod.GET)
//	@ResponseBody
//	public String getInfo() {
//		Gson gson = new Gson();
//		return gson.toJson(ticketService.getInfo());
//	}
	
	@RequestMapping(value = "/bookTickets", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String bookTickets(@RequestParam Map<String, String> requestParams) throws Exception {
		try {
			int movieID = Integer.parseInt(requestParams.get("movieID"));
			int userID = Integer.parseInt(requestParams.get("userID"));
			int noOfTickets = Integer.parseInt(requestParams.get("no_of_tickets"));
			int ticketID = Integer.parseInt(requestParams.get("ticketID"));
			ticketService.bookTickets(movieID, userID,ticketID, noOfTickets);
			return "Ticket Booked Successfully";
		} catch (Exception e) {
			return e.getMessage();
			//return "Ticket Booking Failed please check for errors";
		}
	}
	
	
}
