package com.example.mock1.service;

import com.example.mock1.dto.RoleDto;
import com.example.mock1.entity.RoleEntity;
import com.example.mock1.utils.ERole;

public interface RoleService {

    RoleDto createRole(RoleDto roleDto);

    RoleDto removeRole(ERole name);


    RoleDto findRoleByName(ERole name);
}
