package com.eraykosterelioglu.controller;

import com.eraykosterelioglu.dto.DtoEmployee;
import com.eraykosterelioglu.dto.DtoEmployeeIU;
import com.eraykosterelioglu.model.RootEntity;

public interface IEmployeeController {

    public RootEntity<DtoEmployee> saveEmployee(DtoEmployeeIU dtoEmployeeIU);

    public RootEntity<DtoEmployee> findEmployeeById(Long id);

}
