package com.example.mock1.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "trips")
public class TripEntity extends BaseEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    private Integer bookedTicketsNumber;


    private String carType;

    private Date departureDate;


    private Time departureTime;


    private String destination;


    private String driver;


    private Integer maximumOnlineTicketNumber;


    @OneToMany(mappedBy = "trip")
    private Set<BookingOfficeEntity> bookingOffices;


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
}
