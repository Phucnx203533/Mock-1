package com.example.mock1.service;

import com.example.mock1.dto.ParkingLotDto;

import java.util.List;

public interface ParkingLotService {

    ParkingLotDto createParkingLot(ParkingLotDto parkingLotDto);

    List<ParkingLotDto> list();

    ParkingLotDto deleteParkingLot(Integer id);


}
