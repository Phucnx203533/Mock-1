package com.example.mock1.service;

import com.example.mock1.dto.BookingOfficeDto;

import java.util.List;

public interface BookingOfficeService {

    BookingOfficeDto createBookingOffice(BookingOfficeDto bookingOffice);

    List<BookingOfficeDto> list();
}
