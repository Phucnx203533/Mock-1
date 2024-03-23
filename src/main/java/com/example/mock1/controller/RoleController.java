package com.example.mock1.controller;

import com.example.mock1.dto.RoleDto;
import com.example.mock1.service.RoleService;
import com.example.mock1.utils.ERole;
import com.example.mock1.utils.respone.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping("/create")
    public CommonResult createRole(@RequestBody  RoleDto roleDto) {
        RoleDto result = roleService.createRole(roleDto);
        return CommonResult.success(result);
    }

    @DeleteMapping("/{name}")
    public CommonResult deleteRole(@PathVariable("name")ERole name){
        RoleDto result = roleService.removeRole(name);
        return CommonResult.success(result);
    }
}
