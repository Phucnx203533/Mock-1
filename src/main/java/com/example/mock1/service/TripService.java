package com.example.mock1.service;

import com.example.mock1.dto.TripDto;
import com.example.mock1.entity.TripEntity;

import java.util.List;
import java.util.UUID;

public interface TripService {

    TripDto createTrip(TripDto tripDto);

    List<TripDto> list();

    TripDto updateTrip(TripDto tripDto);


    TripDto deleteTrip(UUID tripId);

    TripDto updateTripAfterCreateOrDeleteTicket(TripEntity tripEntity);
}
