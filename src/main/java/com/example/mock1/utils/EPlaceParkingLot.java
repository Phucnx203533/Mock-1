package com.example.mock1.utils;

import java.util.Arrays;
import java.util.List;

public enum EPlaceParkingLot {


    PLACE_1("Place 1"),
    PLACE_2("Place 2"),
    PLACE_3("Place 3"),
    PLACE_4("Place 4"),
    PLACE_5("Place 5");

    EPlaceParkingLot(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public List<EDepartment> getAll() {
        return Arrays.asList(EDepartment.values());
    }
}
