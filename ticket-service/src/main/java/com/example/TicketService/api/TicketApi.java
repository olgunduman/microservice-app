package com.example.TicketService.api;

import com.example.TicketService.dto.TicketDto;
import com.example.TicketService.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketApi {


    private final TicketService ticketService;

    public TicketApi(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
   public ResponseEntity<TicketDto> createTicket(@RequestBody  TicketDto ticketDto) {

      return ResponseEntity.ok(ticketService.save(ticketDto));

    }

    @PutMapping("/{id}")
    public  ResponseEntity<TicketDto> updateTicket(@PathVariable  String ticketId, @RequestBody TicketDto ticketDto) {

        return ResponseEntity.ok(ticketService.update(ticketId,ticketDto));

    }

    @GetMapping
    public ResponseEntity<Page<TicketDto>> getAll(Pageable pageable) {

      return ResponseEntity.ok(ticketService.getPagination(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable  String id) {

        return ResponseEntity.ok(ticketService.getById(id));
    }



}
