package com.example.mock1.controller;

import com.example.mock1.dto.ParkingLotDto;
import com.example.mock1.service.ParkingLotService;
import com.example.mock1.utils.respone.CommonResult;
import com.example.mock1.utils.respone.ResCode;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lot")
@Slf4j
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/create")
    public CommonResult createParkingLot(@RequestBody @Valid ParkingLotDto parkingLotDto) {
        ParkingLotDto result = parkingLotService.createParkingLot(parkingLotDto);
        log.info("Create parking lot successfully with id : {}", result.getId());
        return CommonResult.success(result);
    }


    @GetMapping("/list")
    public CommonResult listParkingLot() {
        List<ParkingLotDto> result = parkingLotService.list();
        log.info("Get list parking lot successfully");
        return CommonResult.success(result);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult deleteParkingLot(@PathVariable("id") Integer id) {
        ParkingLotDto result = parkingLotService.deleteParkingLot(id);
        if (result ==null){
            log.info("Parking lot with id : {} not exist",id);
            return new CommonResult(ResCode.PARKING_LOT_NOT_EXISTS);
        }
        log.info("Delete Parking lot success with id : {} ",id);
        return CommonResult.success(result);
    }
}
