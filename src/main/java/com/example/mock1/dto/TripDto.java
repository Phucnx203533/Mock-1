package com.example.mock1.dto;

import com.example.mock1.entity.TripEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

public class TripDto {

    private UUID id;

    private Integer bookedTicketsNumber;

    @NotNull
    private String carType;


    @NotNull
    private Date departureDate;

    @NotNull
    private Time departureTime;

    @NotNull
    private String destination;

    @NotNull
    private String driver;

    @Min(value = 0)
    private Integer maximumOnlineTicketNumber;


    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getMaximumOnlineTicketNumber() {
        return maximumOnlineTicketNumber;
    }

    public void setMaximumOnlineTicketNumber(Integer maximumOnlineTicketNumber) {
        this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getBookedTicketsNumber() {
        return bookedTicketsNumber;
    }

    public void setBookedTicketsNumber(Integer bookedTicketsNumber) {
        this.bookedTicketsNumber = bookedTicketsNumber;
    }

    public static TripEntity toTripEntity(TripDto tripDto){
        TripEntity tripEntity = new TripEntity();
        BeanUtils.copyProperties(tripDto, tripEntity);
        return tripEntity;
    }

    public static TripDto fromTripEntity(TripEntity tripEntity){
        TripDto tripDto = new TripDto();
        BeanUtils.copyProperties(tripEntity, tripDto);
        return tripDto;
    }
}
