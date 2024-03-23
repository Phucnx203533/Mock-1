package com.example.mock1.dto;

import com.example.mock1.entity.RetailEntity;
import org.springframework.beans.BeanUtils;

public class RetailDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static RetailEntity toRetailEntity(RetailDto retail){
        RetailEntity retailEntity = new RetailEntity();
        BeanUtils.copyProperties(retail,retailEntity);
        return retailEntity;
    }

    public static RetailDto fromRetailEntity(RetailEntity retailEntity){
        RetailDto retailDto = new RetailDto();
        BeanUtils.copyProperties(retailEntity,retailDto);
        return retailDto;
    }
}
