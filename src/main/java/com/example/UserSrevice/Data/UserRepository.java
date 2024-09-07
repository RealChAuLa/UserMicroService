package com.example.UserSrevice.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserName(String c_username);

    Optional<User> findByUserName(String userName);

    @Query("SELECT p FROM User p WHERE p.userName = ?1")
    List<User> finduserdetilsbyname(String userName);
}