package com.example.mock1.config.security.service;

import com.example.mock1.entity.EmployeeEntity;
import com.example.mock1.entity.RoleEntity;
import com.example.mock1.repository.EmployeeRepository;
import com.example.mock1.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository repository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Find employee by account : {}",username);
        EmployeeEntity employeeEntity = employeeRepository.findByAccount(username);
        if(employeeEntity == null){
            log.debug("{} account not found",username);
            throw  new UsernameNotFoundException("Not exist");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(RoleEntity roleEntity : employeeEntity.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getName().toString()));
        }

        return new UserDetailsImpl(employeeEntity,grantedAuthorities);
    }
}
