package com.example.TicketService.repository.es;

import com.example.TicketService.entity.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {
}

