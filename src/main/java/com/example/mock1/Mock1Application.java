package com.example.mock1;

import com.example.mock1.dto.EmployeeDto;
import com.example.mock1.dto.RoleDto;
import com.example.mock1.entity.EmployeeEntity;
import com.example.mock1.entity.RoleEntity;
import com.example.mock1.service.EmployeeService;
import com.example.mock1.service.RoleService;
import com.example.mock1.utils.EDepartment;
import com.example.mock1.utils.ERole;
import com.example.mock1.utils.ESex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.Set;

@SpringBootApplication
public class Mock1Application {




    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Mock1Application.class, args);
        RoleService roleService = applicationContext.getBean(RoleService.class);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        roleService.createRole(
                RoleDto.fromRoleEntity(
                        new RoleEntity(ERole.ROLE_ADMIN)
                )
        );
        roleService.createRole(
                RoleDto.fromRoleEntity(
                        new RoleEntity(ERole.ROLE_CPOAS)
                )
        );
        roleService.createRole(
                RoleDto.fromRoleEntity(
                        new RoleEntity(ERole.ROLE_HRM)
                )
        );

        // Create an employee
        employeeService.createEmployee(
                        new EmployeeDto(
                                "a", new Date(),
                                "012312","xuanphuc@gmail.com",
                                "admin","admin",
                                "Hn", EDepartment.EMPLOYEE,
                                ESex.MALE,
                                Set.of(
                                        roleService.findRoleByName(ERole.ROLE_HRM),
                                        roleService.findRoleByName(ERole.ROLE_ADMIN),
                                        roleService.findRoleByName(ERole.ROLE_CPOAS)

                                    )
                        ));

    }
}
