package com.example.mock1.service.Impl;

import com.example.mock1.dto.BookingOfficeDto;
import com.example.mock1.entity.BookingOfficeEntity;
import com.example.mock1.repository.BookingOfficeRepository;
import com.example.mock1.service.BookingOfficeService;
import org.apache.tomcat.websocket.BackgroundProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookingOfficeServiceImpl implements BookingOfficeService {

    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;


    @Override
    public BookingOfficeDto createBookingOffice(BookingOfficeDto bookingOffice) {
        BookingOfficeEntity bookingOfficeEntity  = bookingOfficeRepository.save(BookingOfficeDto.toBookingOfficeEntity(bookingOffice));
        return BookingOfficeDto.fromBookingOfficeEntity(bookingOfficeEntity);
    }

    @Override
    public List<BookingOfficeDto> list() {
        return bookingOfficeRepository.findAll().stream().map(BookingOfficeDto::fromBookingOfficeEntity).collect(Collectors.toList());
    }
}
