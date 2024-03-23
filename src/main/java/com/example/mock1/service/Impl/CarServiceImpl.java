package com.example.mock1.service.Impl;

import com.example.mock1.dto.CarDto;
import com.example.mock1.dto.CompanyDto;
import com.example.mock1.dto.ParkingLotDto;
import com.example.mock1.dto.TicketDto;
import com.example.mock1.entity.CarEntity;
import com.example.mock1.repository.CarRepository;
import com.example.mock1.service.CarService;
import com.example.mock1.service.ParkingLotService;
import jakarta.validation.constraints.AssertFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {


    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ParkingLotService parkingLotService;

    @Override
    public CarDto createCar(CarDto carDto) {
        CarEntity carEntity = carRepository.save(CarDto.toCarEntity(carDto));
        return CarDto.fromCarEntity(carEntity);
    }

    @Override
    public List<CarDto> list() {
        return carRepository.findAll().stream().map(CarDto::fromCarEntity).collect(Collectors.toList());
    }

    @Override
    public CarDto delteteCar(String licenseplate) {
        CarEntity carEntity = carRepository.findByLicenseplate(licenseplate);
        if(carEntity != null){
            carRepository.delete(carEntity);
            return CarDto.fromCarEntity(carEntity);
        }
        return null;
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        CarEntity carEntity = carRepository.findByLicenseplate(carDto.getLicenseplate());
        if(carEntity == null){
            return null;
        }
        carEntity.setColor(carDto.getColor());
        carEntity.setType(carDto.getType());
        carEntity.setCompany(CompanyDto.toCompanyEntity(carDto.getCompany()));
        carEntity.setParkingLot(ParkingLotDto.toParkingLotEntity(carDto.getParkingLot()));
        return CarDto.fromCarEntity(carRepository.save(carEntity));
    }
}
