package com.exercise.javainactionexercise.user.respository;

import com.exercise.javainactionexercise.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
