package org.indigo.airlines.repository;

import org.indigo.airlines.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("SELECT u1 FROM User u1 WHERE u1.userName = :userName AND u1.password = :password")
	User logInUser(@Param("userName") String userName, @Param("password") int password);
}
