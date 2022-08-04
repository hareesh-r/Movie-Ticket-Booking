package com.booking.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.booking.movie.model.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query(value = "SELECT * FROM Movies WHERE movieID = :id", nativeQuery = true)
	Movie getMovieByID(@Param("id") Integer id);
	
	
	@Modifying
	@Transactional
	@Query(value = "insert into movies (movieID, name, ticket_price, available_tickets,total_tickets) values (:movieID, :name, :ticket_price, :available_tickets , :total_tickets)", nativeQuery = true)
	void addMovie(@Param("movieID") int movieID, @Param("name") String name, @Param("ticket_price") int ticketPrice,@Param("available_tickets") int availableTickets,@Param("total_tickets") int totalTickets);


	@Modifying
	@Transactional
	@Query(value = "update movies set name=:name,ticket_price=:ticketPrice,available_tickets=:availableTickets,total_tickets=:totalTickets where movieID=:movieID", nativeQuery = true)
	void updateMovie(@Param("movieID") int movieID, @Param("name") String name, @Param("ticketPrice") int ticketPrice,@Param("availableTickets") int availableTickets,@Param("totalTickets") int totalTickets);
}
