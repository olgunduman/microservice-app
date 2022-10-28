package com.example.TicketService.service.impl;

import com.example.TicketService.dto.TicketDto;
import com.example.TicketService.entity.PriorityType;
import com.example.TicketService.entity.TicketEntity;
import com.example.TicketService.entity.TicketStatus;
import com.example.TicketService.entity.es.TicketModel;
import com.example.TicketService.repository.TicketRepository;
import com.example.TicketService.repository.es.TicketElasticRepository;
import com.example.TicketService.service.TicketService;
import com.example.client.AccountServiceClient;
import com.example.client.contract.AccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import javax.transaction.Transactional;

@Service
@Slf4j
public class TicketServiceİmpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final TicketElasticRepository ticketElasticRepository;


    private final  AccountServiceClient accountServiceClient;

    public TicketServiceİmpl(TicketRepository ticketRepository, TicketElasticRepository ticketElasticRepository, AccountServiceClient accountServiceClient) {
        this.ticketRepository = ticketRepository;
        this.ticketElasticRepository = ticketElasticRepository;
        this.accountServiceClient = accountServiceClient;
    }

    @Deprecated
    private TicketServiceİmpl() {
        // You could leave x = null or create a default value for that field
        // if you have one (eg. x = new DefaultSpellChecker();)
    }



    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        //ticket entity ticket dto donusum yap
        TicketEntity ticket = new TicketEntity();

        log.info("TicketServiceİmpl.save ticketDto: {}", ticketDto.toString());
        log.info("TicketServiceİmpl.save ticket: {}", ticketDto.getAssignee());

        ResponseEntity<AccountDto> accountDtoResponseEntity;
        accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());
        if(ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description cannot be empty");

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

        // mysql kaydet
        ticket = ticketRepository.save(ticket);
        //ticket model nesnesi yarat
        TicketModel model = TicketModel.builder()
                .id(ticket.getId())
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .ticketDate(ticket.getTicketDate())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .build();
        // elastic kaydet
        model = ticketElasticRepository.save(model);
        //olusan nesneyi dondur
        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String id ,TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
