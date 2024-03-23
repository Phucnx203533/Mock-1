package com.example.mock1.repository;

import com.example.mock1.entity.BookingOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingOfficeRepository extends JpaRepository<BookingOfficeEntity, Integer> {
}
