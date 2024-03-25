package com.example.mock1.dto;

import com.example.mock1.entity.EmployeeEntity;
import com.example.mock1.entity.RoleEntity;
import com.example.mock1.utils.EDepartment;
import com.example.mock1.utils.ESex;
import com.example.mock1.validation.password.PasswordValid;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDto {


    private Integer id;
    @NotNull
    private String fullName;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String account;
    @PasswordValid
    private String password;

    private String address;

    @NotNull
    private EDepartment department;
    @NotNull
    private ESex sex;

    private Set<RoleDto> roles = new HashSet<>();

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EDepartment department) {
        this.department = department;
    }

    public ESex getSex() {
        return sex;
    }

    public void setSex(ESex sex) {
        this.sex = sex;
    }

    public EmployeeDto() {
    }

    public EmployeeDto( String fullName, Date dateOfBirth,  String phoneNumber, String email,  String account, String password, String address,  EDepartment department, ESex sex,Set<RoleDto> roleDtos) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
        this.password = password;
        this.address = address;
        this.department = department;
        this.sex = sex;
        this.roles = roleDtos;
    }

    public static EmployeeEntity toEmployeeEntity(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDto,employeeEntity);
        return employeeEntity;
    }

    public static EmployeeDto fromEmployeeEntity(EmployeeEntity employeeEntity){
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeEntity,employeeDto);
        employeeDto.setPassword("");
        return employeeDto;
    }
}
