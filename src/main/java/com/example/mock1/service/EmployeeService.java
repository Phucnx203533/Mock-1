package com.example.mock1.service;

import com.example.mock1.dto.EmployeeDto;
import com.example.mock1.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {


    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> findAll();


    List<EmployeeDto> findAll(Integer pageNo,Integer pageSize);

    EmployeeDto getEmployeeById(Integer id);


    EmployeeDto updateEmployee(EmployeeDto employeeDto);


    EmployeeDto deleteEmployeeById(Integer id);


}
