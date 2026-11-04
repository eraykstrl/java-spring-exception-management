package com.eraykosterelioglu.controller;

import com.eraykosterelioglu.dto.DtoDepartment;
import com.eraykosterelioglu.dto.DtoDepartmentIU;

public interface IDepartmentController {

    public DtoDepartment saveDepartment(DtoDepartmentIU dtoDepartmentIU);

}
