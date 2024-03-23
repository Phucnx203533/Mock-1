package com.example.mock1.utils;

public enum EStatusParkingLot {

    BLANK("Blank"),
    FULL("Full");

    private String name;

    EStatusParkingLot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
