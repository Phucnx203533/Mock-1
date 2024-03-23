package com.example.mock1.service.Impl;

import com.example.mock1.dto.EmployeeDto;
import com.example.mock1.entity.EmployeeEntity;
import com.example.mock1.repository.EmployeeRepository;
import com.example.mock1.repository.paging.EmployeePagingAndSortingRepository;
import com.example.mock1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = EmployeeDto.toEmployeeEntity(employeeDto);
        employeeEntity.setPassword(bCryptPasswordEncoder.encode(employeeDto.getPassword()));
        EmployeeEntity result = employeeRepository.save(employeeEntity);
        result.setPassword("");
        return EmployeeDto.fromEmployeeEntity(result);
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream().map(employeeEntity -> EmployeeDto.fromEmployeeEntity(employeeEntity)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> findAll(Integer pageNo,Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<EmployeeEntity> page = employeePagingAndSortingRepository.findAll(pageable);
        return page.getContent().stream().map(employeeEntity -> EmployeeDto.fromEmployeeEntity(employeeEntity)).collect(Collectors.toList()) ;
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Optional<EmployeeEntity>  employeeEntity = employeeRepository.findById(id);
        if(employeeEntity.isPresent()){
            EmployeeDto employeeDto = EmployeeDto.fromEmployeeEntity(employeeEntity.get());
            employeeDto.setPassword("");

            return employeeDto;
        }
        return null;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(employeeDto.getId());
        if(optionalEmployeeEntity.isPresent()){
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            employeeEntity.setAddress(employeeDto.getAddress());
            employeeEntity.setFullName(employeeDto.getFullName());
            employeeEntity.setDepartment(employeeDto.getDepartment());
            employeeEntity.setSex(employeeDto.getSex());
            employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
            employeeRepository.save(employeeEntity);
            employeeEntity.setPassword("");
            return EmployeeDto.fromEmployeeEntity(employeeEntity);
        }
        return null;
    }

    @Override
    public EmployeeDto deleteEmployeeById(Integer id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if(optionalEmployeeEntity.isPresent()){
            employeeRepository.deleteById(id);
            return EmployeeDto.fromEmployeeEntity(optionalEmployeeEntity.get());
        }
        return null;
    }
}
