package com.mango.customer.repository;

import com.mango.customer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM USERS.USER u WHERE u.email = :email", nativeQuery = true)
	public User findByEmail(@Param("email") String email);
}
