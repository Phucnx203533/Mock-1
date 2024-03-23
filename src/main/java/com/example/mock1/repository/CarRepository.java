package com.example.mock1.repository;

import com.example.mock1.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,String> {

    CarEntity findByLicenseplate(String licenseplate);
}
