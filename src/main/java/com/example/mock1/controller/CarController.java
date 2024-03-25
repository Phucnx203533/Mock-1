package com.example.mock1.controller;

import com.example.mock1.dto.CarDto;
import com.example.mock1.service.CarService;
import com.example.mock1.utils.respone.CommonResult;
import com.example.mock1.utils.respone.ResCode;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@Slf4j
@PreAuthorize("hasRole('ROLE_CPOAS')")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public CommonResult createCar(@RequestBody @Valid CarDto carDto) {
        CarDto result = carService.createCar(carDto);
        log.info("Car created with id  {} ",result.getLicenseplate());
        return CommonResult.success(result);
    }

    @GetMapping("/list")
    public CommonResult listCar() {
        List<CarDto> result = carService.list();
        log.info("Car list success ");
        return CommonResult.success(result);
    }

    @DeleteMapping("/{licenseplate}")
    public CommonResult deleteCar(@PathVariable("licenseplate")String licenseplate) {
        CarDto result = carService.delteteCar(licenseplate);
        if(result == null){
            log.info("Car with id  {} not exist ",licenseplate);
            return new CommonResult(ResCode.CAR_NOT_EXISTS);
        }
        log.info("Car deleted with id  {} ",licenseplate);
        return CommonResult.success(result);
    }

    @PutMapping("/update")
    public CommonResult updateCar(@RequestBody @Valid CarDto carDto){
        CarDto result = carService.updateCar(carDto);
        if (result == null){
            log.info("Car with id : {} not exist",carDto.getLicenseplate());
            return new CommonResult(ResCode.CAR_NOT_EXISTS);
        }else{
            log.info("Update car with id : {} successful",carDto.getLicenseplate());
            return CommonResult.success(result);
        }
    }
}
