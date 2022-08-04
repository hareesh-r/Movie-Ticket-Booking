package com.booking.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.booking.movie.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	
	@Query(value="select * from tickets",nativeQuery = true)
	List<Ticket> getAllTickets();
	
	@Modifying
	@Transactional
	@Query(value = "insert into tickets (movieID, userID, ticketID, no_of_tickets,timestamp) values (:movieID, :userID, :ticketID, :no_of_tickets , CURRENT_TIMESTAMP())", nativeQuery = true)
	void bookTickets(@Param("movieID") int movieID, @Param("userID") int userID, @Param("ticketID") int ticketID,@Param("no_of_tickets") int noOfTickets);
	
	
	@Query(value="select * from users join tickets on users.userID=tickets.userID LEFT JOIN movies on movies.movieID=tickets.movieID;",nativeQuery = true)
	List<Ticket> getInfo();

	
}
