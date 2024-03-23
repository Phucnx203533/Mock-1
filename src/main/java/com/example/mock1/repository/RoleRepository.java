package com.example.mock1.repository;

import com.example.mock1.entity.RoleEntity;
import com.example.mock1.utils.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {


    RoleEntity findByName(ERole name);
}
