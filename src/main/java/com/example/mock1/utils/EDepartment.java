package com.example.mock1.utils;

import java.util.Arrays;
import java.util.List;

public enum EDepartment {
    EMPLOYEE("Employee"),
    SERVICE("Service"),
    PARKING("Parking");


    EDepartment(String value){
        this.name = value;
    }
    private String name;

    public String getName() {
        return name;
    }

    public List<EDepartment> getAll() {
        return Arrays.asList(EDepartment.values());
    }
}
