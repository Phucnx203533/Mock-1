package com.example.mock1.repository;

import com.example.mock1.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLotEntity,Integer> {

    ParkingLotEntity findByName(String name);



}
