package com.example.mock1.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity
{

    @Id
    private String name;

    @OneToMany(mappedBy = "company")
    private Set<CarEntity> cars = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
