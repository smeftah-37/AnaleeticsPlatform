package com.example.demo.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT s FROM User s WHERE s.email= ?1")
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);
     @EntityGraph(attributePaths = "team") // Specify the attribute path to the related entity
    List<User> findAll(); 
    
}
