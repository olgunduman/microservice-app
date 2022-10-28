package com.example.TicketService.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "ticket")
@Table(name = "ticket")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity extends BaseEntityModel {

    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String notes;

    @Getter
    @Setter
    private String assignee;

    @Getter
    @Setter
    private Date ticketDate;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priorty_type")
    private PriorityType priorityType;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}

