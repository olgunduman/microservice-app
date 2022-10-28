package com.example.TicketService.repository;

import com.example.TicketService.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface TicketRepository extends JpaRepository<TicketEntity, String> {
}

