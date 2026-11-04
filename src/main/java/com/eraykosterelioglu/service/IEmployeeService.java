package com.eraykosterelioglu.service;

import com.eraykosterelioglu.dto.DtoEmployee;
import com.eraykosterelioglu.dto.DtoEmployeeIU;

public interface IEmployeeService {

    public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU);

    public DtoEmployee findEmployeeById(Long id);
}
