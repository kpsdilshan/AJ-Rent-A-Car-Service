package com.practical.project.oauth2_server.repository;

import com.practical.project.oauth2_server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String name);
}
