package com.example.mock1.dto;

import com.example.mock1.entity.CompanyEntity;
import org.springframework.beans.BeanUtils;

public class CompanyDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CompanyEntity toCompanyEntity(CompanyDto companyDto){
        CompanyEntity companyEntity = new CompanyEntity();
        BeanUtils.copyProperties(companyDto, companyEntity);
        return companyEntity;
    }

    public  static CompanyDto fromCompanyEntity(CompanyEntity companyEntity){
        CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(companyEntity, companyDto);
        return companyDto;
    }
}
