package com.example.mock1.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity{


    @Id
    private String licenseplate;

    private String color;

    private String type;


    @ManyToOne
    @JoinColumn(name = "company")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name="park_id", nullable=false)
    private ParkingLotEntity parkingLot;


    @OneToMany(mappedBy = "car")
    private Set<TicketEntity> tickets = new HashSet<>();


    public CarEntity() {
    }

    public CarEntity(String licenseplate, String color, String type) {
        this.licenseplate = licenseplate;
        this.color = color;
        this.type = type;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public ParkingLotEntity getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotEntity parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Set<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketEntity> tickets) {
        this.tickets = tickets;
    }


}
