package com.penelakut.soswedding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penelakut.soswedding.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByFirstName(String firstName);
    Optional<User> findUserByUuid(String uuid);
}
