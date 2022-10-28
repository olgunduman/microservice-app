package com.example.TicketService.entity.es;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@Document(indexName = "ticket")
@NoArgsConstructor
@AllArgsConstructor
public class TicketModel implements Serializable {

    @Id
    private String id;

    private String description;


    private String notes;


    private String assignee;

    private Date ticketDate;

    private String priorityType;

    private String ticketStatus;
}
