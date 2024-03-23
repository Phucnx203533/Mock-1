package com.example.mock1.service.Impl;

import com.example.mock1.dto.TicketDto;
import com.example.mock1.entity.TicketEntity;
import com.example.mock1.entity.TripEntity;
import com.example.mock1.repository.TicketRepository;
import com.example.mock1.service.TicketService;
import com.example.mock1.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TripService tripService;

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        TicketEntity ticketEntity = ticketRepository.save(TicketDto.toTicketEntity(ticketDto));
        TripEntity trip = ticketEntity.getTrip();
        trip.setBookedTicketsNumber(trip.getBookedTicketsNumber()+1);
        tripService.updateTripAfterCreateOrDeleteTicket(trip);
        ticketEntity.setTrip(trip);
        return TicketDto.fromTicketEntity(ticketEntity);
    }

    @Override
    public List<TicketDto> list() {
        List<TicketEntity> ticketEntities = ticketRepository.findAll();
        return ticketEntities.stream().map(TicketDto::fromTicketEntity).collect(Collectors.toList());
    }

    @Override
    public TicketDto deleteTicket(UUID id) {
        Optional<TicketEntity> optionalTicketEntity = ticketRepository.findById(id);
        if (optionalTicketEntity.isPresent()) {
            TicketEntity ticketEntity = optionalTicketEntity.get();
            ticketRepository.delete(ticketEntity);
            TripEntity trip = ticketEntity.getTrip();
            trip.setBookedTicketsNumber(trip.getBookedTicketsNumber()-1);
            tripService.updateTripAfterCreateOrDeleteTicket(trip);
            ticketEntity.setTrip(trip);
            return TicketDto.fromTicketEntity(ticketEntity);
        }
        return null;
    }
}
