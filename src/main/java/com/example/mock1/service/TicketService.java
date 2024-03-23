package com.example.mock1.service;

import com.example.mock1.dto.TicketDto;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    TicketDto createTicket(TicketDto ticketDto);

    List<TicketDto> list();

    TicketDto deleteTicket(UUID id);


}
