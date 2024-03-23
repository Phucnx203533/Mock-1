package com.example.mock1.dto;

import com.example.mock1.entity.CarEntity;
import com.example.mock1.entity.CompanyEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class CarDto {


    @NotNull
    private String licenseplate;

    private String color;

    private String type;

    @NotNull
    private CompanyDto company;
    @NotNull
    private ParkingLotDto parkingLot;

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

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public ParkingLotDto getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotDto parkingLot) {
        this.parkingLot = parkingLot;
    }


    public static CarEntity toCarEntity(CarDto carDto){
        CarEntity carEntity = new CarEntity();
        BeanUtils.copyProperties(carDto,carEntity);
        carEntity.setParkingLot(ParkingLotDto.toParkingLotEntity(carDto.getParkingLot()));
        carEntity.setCompany(CompanyDto.toCompanyEntity(carDto.getCompany()));
        return carEntity;
    }
    public static CarDto fromCarEntity(CarEntity carEntity){
        CarDto carDto = new CarDto();
        BeanUtils.copyProperties(carEntity,carDto);
        carDto.setParkingLot(ParkingLotDto.fromParkingLotEntity(carEntity.getParkingLot()));
        carDto.setCompany(CompanyDto.fromCompanyEntity(carEntity.getCompany()));
        return carDto;
    }
}
