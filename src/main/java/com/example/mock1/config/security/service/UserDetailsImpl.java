package com.example.mock1.config.security.service;

import com.example.mock1.entity.EmployeeEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private EmployeeEntity employeeEntity;


    private final List<GrantedAuthority> authorities;

    public UserDetailsImpl(EmployeeEntity employeeEntity, List<GrantedAuthority> authorities) {
        this.employeeEntity = employeeEntity;
        this.authorities = authorities;
    }


    public UserDetailsImpl(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return employeeEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return employeeEntity.getAccount();
    }

    public String getEmail(){
        return employeeEntity.getEmail();
    }

    public Date getLastLogin(){
        return employeeEntity.getLastLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
