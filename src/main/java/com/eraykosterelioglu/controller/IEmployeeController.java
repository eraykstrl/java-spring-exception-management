package com.eraykosterelioglu.controller;

import com.eraykosterelioglu.dto.DtoEmployee;
import com.eraykosterelioglu.dto.DtoEmployeeIU;

public interface IEmployeeController {

    public DtoEmployeeIU saveEmployee(DtoEmployeeIU dtoEmployeeIU);

    public DtoEmployee findEmployeeById(Long id);

}
