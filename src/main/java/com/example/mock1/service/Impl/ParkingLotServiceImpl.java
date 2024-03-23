package com.example.mock1.service.Impl;

import com.example.mock1.dto.ParkingLotDto;
import com.example.mock1.entity.ParkingLotEntity;
import com.example.mock1.repository.ParkingLotRepository;
import com.example.mock1.service.ParkingLotService;
import com.example.mock1.utils.EStatusParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {


    @Autowired
    private ParkingLotRepository parkingLotRepository;


    @Override
    public ParkingLotDto createParkingLot( ParkingLotDto parkingLotDto) {
        parkingLotDto.setStatusParkingLot(EStatusParkingLot.BLANK);
        ParkingLotEntity parkingLotEntity = parkingLotRepository.save( ParkingLotDto.toParkingLotEntity(parkingLotDto));
        return ParkingLotDto.fromParkingLotEntity(parkingLotEntity);
    }

    @Override
    public List<ParkingLotDto> list(){
        List<ParkingLotDto> list = parkingLotRepository.findAll().stream().map(
                parkingLotEntity -> ParkingLotDto.fromParkingLotEntity(parkingLotEntity)
        ).collect(Collectors.toList());
        return list;
    }

    @Override
    public ParkingLotDto deleteParkingLot(Integer id) {
        Optional<ParkingLotEntity>optionalParkingLotEntity = parkingLotRepository.findById(id);
        if (optionalParkingLotEntity.isPresent()) {
            parkingLotRepository.delete(optionalParkingLotEntity.get());
            return ParkingLotDto.fromParkingLotEntity(optionalParkingLotEntity.get());
        }
        return  null;
    }


}
