package com.example.mock1.utils;

import java.util.Arrays;
import java.util.List;

public enum ESex {

    MALE("Male"),
    FEMALE("Female");


    ESex(String value) {
        this.name = value;
    }

    private String name;

    public String getName() {
        return name;
    }


    public List<ESex> getAll(){
        return Arrays.asList(ESex.values());
    }


}
