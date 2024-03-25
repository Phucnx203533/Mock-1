package com.example.mock1.controller;

import com.example.mock1.dto.BookingOfficeDto;
import com.example.mock1.service.BookingOfficeService;
import com.example.mock1.utils.respone.CommonResult;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking-office")
@Slf4j

@PreAuthorize("hasRole('ROLE_CPOAS')")
public class BookingOfficeController {



    @Autowired
    private BookingOfficeService bookingOfficeService;


    @PostMapping("/create")
    public CommonResult createBookingOffice(@RequestBody @Valid BookingOfficeDto bookingOfficeDto){
        BookingOfficeDto result = bookingOfficeService.createBookingOffice(bookingOfficeDto);
        log.info("Booking office created with id :{}",result.getId());
        return CommonResult.success(result);
    }

    @GetMapping("/list")
    public CommonResult listBookingOffice(){
        List<BookingOfficeDto> result = bookingOfficeService.list();
        log.info("Get list booking office successfully");
        return CommonResult.success(result);
    }
}
