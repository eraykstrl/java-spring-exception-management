package com.eraykosterelioglu.service.impl;

import com.eraykosterelioglu.dto.DtoDepartment;
import com.eraykosterelioglu.dto.DtoDepartmentIU;
import com.eraykosterelioglu.model.Department;
import com.eraykosterelioglu.repository.DepartmentRepository;
import com.eraykosterelioglu.service.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DtoDepartment saveDepartment(DtoDepartmentIU dtoDepartmentIU) {

        Department department = new Department();
        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(dtoDepartmentIU,department);
        Department dbDepartment = departmentRepository.save(department);
        BeanUtils.copyProperties(dbDepartment,dtoDepartment);
        return dtoDepartment;
    }
}
