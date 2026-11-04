package com.eraykosterelioglu.service;

import com.eraykosterelioglu.dto.DtoDepartment;
import com.eraykosterelioglu.dto.DtoDepartmentIU;

public interface IDepartmentService {

    public DtoDepartment saveDepartment(DtoDepartmentIU departmentIU);
}
