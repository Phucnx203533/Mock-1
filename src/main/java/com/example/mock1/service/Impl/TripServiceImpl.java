package com.example.mock1.service.Impl;

import com.example.mock1.dto.TripDto;
import com.example.mock1.entity.TripEntity;
import com.example.mock1.repository.TripRepository;
import com.example.mock1.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {


    @Autowired
    private TripRepository tripRepository;


    @Override
    public TripDto createTrip(TripDto tripDto) {
        tripDto.setBookedTicketsNumber(0);
        TripEntity tripEntity = tripRepository.save(TripDto.toTripEntity(tripDto));
        return TripDto.fromTripEntity(tripEntity);
    }

    @Override
    public List<TripDto> list() {
        return tripRepository.findAll().stream().map(TripDto::fromTripEntity).collect(Collectors.toList());
    }

    @Override
    public TripDto deleteTrip(UUID tripId) {
        Optional<TripEntity> optionalTripEntity = tripRepository.findById(tripId);
        if(optionalTripEntity.isPresent()){
            tripRepository.delete(optionalTripEntity.get());
            return TripDto.fromTripEntity(optionalTripEntity.get());
        }
        return null;
    }

    @Override
    public TripDto updateTrip(TripDto tripDto) {
        Optional<TripEntity> optionalTripEntity = tripRepository.findById(tripDto.getId());
        if(optionalTripEntity.isPresent()){
            TripEntity tripEntity = optionalTripEntity.get();
            tripEntity.setBookedTicketsNumber(tripDto.getBookedTicketsNumber());
            tripEntity.setCarType(tripDto.getCarType());
            tripEntity.setDepartureDate(tripDto.getDepartureDate());
            tripEntity.setDepartureTime(tripDto.getDepartureTime());
            tripEntity.setDestination(tripDto.getDestination());
            tripEntity.setDriver(tripDto.getDriver());
            tripEntity.setMaximumOnlineTicketNumber(tripDto.getMaximumOnlineTicketNumber());
            TripEntity updatedTripEntity = tripRepository.save(tripEntity);
            return TripDto.fromTripEntity(updatedTripEntity);
        }
        return null;
    }

    @Override
    public TripDto updateTripAfterCreateOrDeleteTicket(TripEntity tripEntity) {
        return updateTrip(TripDto.fromTripEntity(tripEntity));
    }
}
