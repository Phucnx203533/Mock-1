package com.example.mock1.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "booking_offices")
public class BookingOfficeEntity extends BaseEntity {

    @Id
    public Integer id;

    private String name;


    private String phoneNumber;


    private Long price;

    private Date startContractDeadline;

    private Date endContractDeadline;
    @ManyToOne
    @JoinColumn(name = "trip")
    private TripEntity trip;

    @OneToOne
    @JoinColumn(name = "retail")
    private RetailEntity retail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public TripEntity getTrip() {
        return trip;
    }

    public void setTrip(TripEntity trip) {
        this.trip = trip;
    }

    public RetailEntity getRetail() {
        return retail;
    }

    public void setRetail(RetailEntity retail) {
        this.retail = retail;
    }
}
