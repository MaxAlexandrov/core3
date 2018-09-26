package com.exchanger.repository;

import com.exchanger.model.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageStatusRepository extends JpaRepository<MessageStatus,Long> {
    MessageStatus findByStatus(String status);
    MessageStatus findById(Integer id);
}
