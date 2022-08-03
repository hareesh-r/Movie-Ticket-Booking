package com.booking.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.movie.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM Users WHERE userID = :id", nativeQuery = true)
	User getUserByID(@Param("id") Integer id);

	@Modifying
	@Transactional
	@Query(value = "insert into Users (username, password, role, userID) values (:username, :password, :role, :userID)", nativeQuery = true)
	void addUser(@Param("username") String username, @Param("password") String password, @Param("role") String role,
			@Param("userID") int userID);

	@Modifying
	@Transactional
	@Query(value = "update Users set username=:username,password=:password,role=:role where userID=:userID", nativeQuery = true)
	void updateUser(@Param("username") String username, @Param("password") String password, @Param("role") String role,
			@Param("userID") int userID);
	
	
	@Query(value = "select * from users where username=:username and password=:password", nativeQuery = true)
	User getUserByCredentials(@Param("username") String username, @Param("password") String password);

}
