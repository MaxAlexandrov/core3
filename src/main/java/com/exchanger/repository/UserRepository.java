package com.exchanger.repository;

import com.exchanger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findBylogin(String login);
}
