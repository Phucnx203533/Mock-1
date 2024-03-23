package com.example.mock1.dto;

import com.example.mock1.entity.ParkingLotEntity;
import com.example.mock1.utils.EPlaceParkingLot;
import com.example.mock1.utils.EStatusParkingLot;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class ParkingLotDto {
    @NotNull
    private Integer id;


    @NotNull
    private Double area;

    @NotNull
    private String name;

    @NotNull
    private EPlaceParkingLot place;

    private Long price;
    private EStatusParkingLot statusParkingLot;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatusParkingLot(EStatusParkingLot statusParkingLot) {
        this.statusParkingLot = statusParkingLot;
    }
    public static ParkingLotEntity toParkingLotEntity(ParkingLotDto parkingLotDto){
        ParkingLotEntity parkingLotEntity = new ParkingLotEntity();
        BeanUtils.copyProperties(parkingLotDto,parkingLotEntity);
        return parkingLotEntity;
    }

    public static ParkingLotDto fromParkingLotEntity(ParkingLotEntity parkingLotEntity){
        ParkingLotDto parkingLotDto = new ParkingLotDto();
        BeanUtils.copyProperties(parkingLotEntity,parkingLotDto);
        return parkingLotDto;
    }
}
