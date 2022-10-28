package com.example.TicketService.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Açık"),
    IN_PROGRESS("Devam Ediyor"),
    RESOLVED("Çözüldü"),
    CLOSED("Kapandı");

    private String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
