package com.example.mock1.controller;

import com.example.mock1.dto.TripDto;
import com.example.mock1.service.TripService;
import com.example.mock1.utils.respone.CommonResult;
import com.example.mock1.utils.respone.ResCode;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trip")
@Slf4j
public class TripController {


        @Autowired
        private TripService tripService;

        @PostMapping("/create")
        public CommonResult createTrip(@RequestBody @Valid TripDto tripDto){
            TripDto result = tripService.createTrip(tripDto);
            log.info("Create trip successfully with id : {}", result.getId());
            return CommonResult.success(result);
        }

        @GetMapping("/list")
        public CommonResult listTrips(){
            List<TripDto> tripDtos = tripService.list();
            log.info("Get list trip successfully");
            return CommonResult.success(tripDtos);
        }


        @PutMapping("/update")
        public CommonResult updateTrip( @RequestBody @Valid TripDto tripDto){
            TripDto result = tripService.updateTrip(tripDto);
            if (result == null) {
                log.info("Trip with id: {} not exits",tripDto.getId());
                return new CommonResult(ResCode.TRIP_NOT_EXISTS);
            }
            log.info("Update trip with id: {} success",tripDto.getId());
            return CommonResult.success(result);
        }

        @DeleteMapping("/{id}")
        public CommonResult deleteTrip(@PathVariable("id") UUID id){
            TripDto result = tripService.deleteTrip(id);
            if (result == null) {
                log.info("Trip with id: {} not exits",id);
                return new CommonResult(ResCode.TRIP_NOT_EXISTS);
            }
            log.info("Delete trip with id: {} success",id);
            return CommonResult.success(result);
        }

}
