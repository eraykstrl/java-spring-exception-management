package com.eraykosterelioglu.controller.impl;

import com.eraykosterelioglu.controller.IEmployeeController;
import com.eraykosterelioglu.dto.DtoEmployee;
import com.eraykosterelioglu.dto.DtoEmployeeIU;
import com.eraykosterelioglu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("")
    public DtoEmployeeIU saveEmployee(@RequestBody DtoEmployeeIU dtoEmployeeIU) {
        return employeeService.saveEmployee(dtoEmployeeIU);
    }

    @GetMapping
    public DtoEmployee findEmployeeById(@RequestParam("id") Long id) {
        return employeeService.findEmployeeById(id);
    }
}
