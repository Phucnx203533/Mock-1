package com.example.mock1.dto;

import com.example.mock1.entity.RoleEntity;
import com.example.mock1.utils.ERole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.BeanUtils;

public class RoleDto {

    private Integer id;

    private ERole name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public static RoleEntity toRoleEntity(RoleDto roleDto){
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDto, roleEntity);
        return roleEntity;
    }

    public static RoleDto fromRoleEntity(RoleEntity roleEntity){
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(roleEntity, roleDto);
        return roleDto;
    }
}
