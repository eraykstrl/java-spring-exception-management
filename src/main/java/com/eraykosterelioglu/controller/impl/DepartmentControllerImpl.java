package com.eraykosterelioglu.controller.impl;

import com.eraykosterelioglu.controller.IDepartmentController;
import com.eraykosterelioglu.dto.DtoDepartmentIU;
import com.eraykosterelioglu.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/department")
public class DepartmentControllerImpl implements IDepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @PostMapping("")
    public DtoDepartmentIU saveDepartment(@RequestBody DtoDepartmentIU dtoDepartmentIU) {
        return departmentService.saveDepartment(dtoDepartmentIU);
    }
}
