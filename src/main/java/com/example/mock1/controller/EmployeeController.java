package com.example.mock1.controller;


import com.example.mock1.dto.EmployeeDto;
import com.example.mock1.entity.EmployeeEntity;
import com.example.mock1.service.EmployeeService;
import com.example.mock1.utils.respone.CommonResult;
import com.example.mock1.utils.respone.ResCode;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/create")
    public CommonResult createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto result = employeeService.createEmployee(employeeDto);
        log.info("Employee created with id  {} ",result.getId());
        return CommonResult.success(result);
    }

    @GetMapping("/getAll")
    public CommonResult getAllEmployees(){
        List<EmployeeDto> result = employeeService.findAll();
        log.info("Get all student success");
        return CommonResult.success(result);
    }


    @GetMapping("/get")
    public CommonResult getEmployee(@RequestParam("pageNo") Integer pageNo,
                                    @RequestParam("pageSize") Integer pageSize){
        List<EmployeeDto> result = employeeService.findAll(pageNo,pageSize);
        log.info("Get employee page success  with page {},{} ",pageNo,pageSize);
        return CommonResult.success(result);
    }
    @GetMapping("/{id}")
    public CommonResult getEmployeeById(@PathVariable("id") Integer id){
        EmployeeDto result = employeeService.getEmployeeById(id);
        if (result == null){
            log.info("Employee with id : {} not exist",id);
            return new CommonResult(ResCode.EMPLOYEE_NOT_EXISTS);
        }else {
            log.info("Get employee with id : {} success",id);
            return CommonResult.success(result);
        }

    }

    @PutMapping("/update")
    public CommonResult updateEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto result = employeeService.updateEmployee(employeeDto);
        if (result == null){
            log.info("Employee with id : {} not exist",employeeDto.getId());
            return new CommonResult(ResCode.EMPLOYEE_NOT_EXISTS);
        }else{
            log.info("Update employee with id : {} success",employeeDto.getId());
            return CommonResult.success(result);
        }

    }

    @DeleteMapping("/delete/{id}")
    public CommonResult deleteEmployee(@PathVariable("id") Integer id){
        EmployeeDto result = employeeService.deleteEmployeeById(id);
        if (result == null){
            log.info("Employee with id : {} not exist",id);
            return new CommonResult(ResCode.EMPLOYEE_NOT_EXISTS);
        }else{
            log.info("Delete employee with id : {} success",id);
            return CommonResult.success();
        }

    }

}
