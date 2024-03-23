package com.example.mock1.entity;

import com.example.mock1.utils.EPlaceParkingLot;
import com.example.mock1.utils.EStatusParkingLot;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parking_lots")
public class ParkingLotEntity extends BaseEntity {

    @Id
    private Integer id;

    private Double area;

    private String name;

    private EPlaceParkingLot place;

    private Long price;
    private EStatusParkingLot statusParkingLot;
    @OneToMany(mappedBy = "parkingLot")
    private Set<CarEntity> cars = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EPlaceParkingLot getPlace() {
        return place;
    }

    public void setPlace(EPlaceParkingLot place) {
        this.place = place;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public EStatusParkingLot getStatusParkingLot() {
        return statusParkingLot;
    }

    public void setStatusParkingLot(EStatusParkingLot statusParkingLot) {
        this.statusParkingLot = statusParkingLot;
    }

//    public Set<CarEntity> getCars() {
//        return cars;
//    }
//
//    public void setCars(Set<CarEntity> cars) {
//        this.cars = cars;
//    }
}
