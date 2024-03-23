package com.example.mock1.dto;

import com.example.mock1.entity.BookingOfficeEntity;
import com.example.mock1.entity.RetailEntity;
import com.example.mock1.entity.TripEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BookingOfficeDto {


    private Integer id;


    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Long price;

    @NotNull
    private Date startContractDeadline;
    @NotNull
    private Date endContractDeadline;
    @NotNull
    private TripDto trip;
    @NotNull
    private RetailDto retail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getStartContractDeadline() {
        return startContractDeadline;
    }

    public void setStartContractDeadline(Date startContractDeadline) {
        this.startContractDeadline = startContractDeadline;
    }

    public Date getEndContractDeadline() {
        return endContractDeadline;
    }

    public void setEndContractDeadline(Date endContractDeadline) {
        this.endContractDeadline = endContractDeadline;
    }

    public TripDto getTrip() {
        return trip;
    }

    public void setTrip(TripDto trip) {
        this.trip = trip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RetailDto getRetail() {
        return retail;
    }

    public void setRetail(RetailDto retail) {
        this.retail = retail;
    }

    public static BookingOfficeEntity toBookingOfficeEntity(BookingOfficeDto bookingOfficeDto){
        BookingOfficeEntity bookingOfficeEntity = new BookingOfficeEntity();
        BeanUtils.copyProperties(bookingOfficeDto,bookingOfficeEntity);
        bookingOfficeEntity.setTrip(TripDto.toTripEntity(bookingOfficeDto.getTrip()));
        bookingOfficeEntity.setRetail(RetailDto.toRetailEntity(bookingOfficeDto.getRetail()));
        return bookingOfficeEntity;
    }

    public static BookingOfficeDto fromBookingOfficeEntity(BookingOfficeEntity bookingOfficeEntity){
        BookingOfficeDto bookingOfficeDto = new BookingOfficeDto();
        BeanUtils.copyProperties(bookingOfficeEntity,bookingOfficeDto);
        bookingOfficeDto.setTrip(TripDto.fromTripEntity(bookingOfficeEntity.getTrip()));
        bookingOfficeDto.setRetail(RetailDto.fromRetailEntity(bookingOfficeEntity.getRetail()));
        return bookingOfficeDto;
    }
}
