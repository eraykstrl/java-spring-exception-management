package com.eraykosterelioglu.controller.impl;

import com.eraykosterelioglu.controller.IEmployeeController;
import com.eraykosterelioglu.dto.DtoEmployee;
import com.eraykosterelioglu.dto.DtoEmployeeIU;
import com.eraykosterelioglu.model.RootEntity;
import com.eraykosterelioglu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController extends BaseController implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoEmployee> saveEmployee(@RequestBody DtoEmployeeIU dtoEmployeeIU) {
        return ok(employeeService.saveEmployee(dtoEmployeeIU));
    }

    @GetMapping("/find/{id}")
    @Override
    public RootEntity<DtoEmployee> findEmployeeById(@PathVariable("id") Long id) {
        return ok(employeeService.findEmployeeById(id));
    }
}
