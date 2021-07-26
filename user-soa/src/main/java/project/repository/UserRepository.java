package project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{ 
	@Query("select u from User u where u.email = :email")
	List<User> findUserByEmail(@Param("email")String email);
}
