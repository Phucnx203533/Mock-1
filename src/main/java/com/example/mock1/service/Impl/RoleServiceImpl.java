package com.example.mock1.service.Impl;

import com.example.mock1.dto.RoleDto;
import com.example.mock1.entity.RoleEntity;
import com.example.mock1.repository.RoleRepository;
import com.example.mock1.service.RoleService;
import com.example.mock1.utils.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
public class RoleServiceImpl implements RoleService {


        @Autowired
        private RoleRepository roleRepository;

        @Override
        public RoleDto createRole(RoleDto roleDto) {
            RoleEntity roleEntity = roleRepository.save(RoleDto.toRoleEntity(roleDto));
            return RoleDto.fromRoleEntity(roleEntity);
        }

    @Override
    public RoleDto removeRole(ERole name) {
            RoleEntity roleEntity = roleRepository.findByName(name);
            if (roleEntity == null) {
                return null;
            }
            roleRepository.delete(roleEntity);

        return RoleDto.fromRoleEntity(roleEntity);
    }

    @Override
    public RoleDto findRoleByName(ERole name) {
        RoleEntity roleEntity = roleRepository.findByName(name);
        if (roleEntity == null) {
            return null;
        }
        return RoleDto.fromRoleEntity(roleEntity) ;
    }
}
