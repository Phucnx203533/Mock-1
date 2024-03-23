package com.example.mock1.dto;

import com.example.mock1.entity.CarEntity;
import com.example.mock1.entity.TicketEntity;
import com.example.mock1.entity.TripEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.UUID;

public class TicketDto {

    private UUID id;


    @NotNull
    private Date bookingTime;

    @NotNull
    private String customer;

    @NotNull
    private CarDto car;

    @NotNull
    private TripDto trip;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public TripDto getTrip() {
        return trip;
    }

    public void setTrip(TripDto trip) {
        this.trip = trip;
    }

    public static TicketEntity toTicketEntity(TicketDto ticketDto){
        TicketEntity ticketEntity = new TicketEntity();
        BeanUtils.copyProperties(ticketDto,ticketEntity);
        ticketEntity.setCar(CarDto.toCarEntity(ticketDto.getCar()));
        ticketEntity.setTrip(TripDto.toTripEntity(ticketDto.getTrip()));
        return ticketEntity;
    }

    public static TicketDto fromTicketEntity(TicketEntity ticketEntity){
        TicketDto ticketDto = new TicketDto();
        BeanUtils.copyProperties(ticketEntity,ticketDto);
        ticketDto.setCar(CarDto.fromCarEntity(ticketEntity.getCar()));
        ticketDto.setTrip(TripDto.fromTripEntity(ticketEntity.getTrip()));
        return ticketDto;
    }
}
