package com.example.TicketService.dto;

import com.example.TicketService.entity.PriorityType;
import com.example.TicketService.entity.TicketStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class TicketDto {

    private String id;

    private String description;


    private String assignee;
    private String notes;


    private Date ticketDate;


    private String priorityType;


    private String ticketStatus;
}
