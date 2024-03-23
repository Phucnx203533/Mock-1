package com.example.mock1.service;

import com.example.mock1.dto.CarDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CarService {

    CarDto createCar(CarDto carDto);

    List<CarDto> list();

    CarDto delteteCar(String licenseplate);


    CarDto updateCar(CarDto carDto);
}
