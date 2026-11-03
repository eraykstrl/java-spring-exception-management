package com.eraykosterelioglu.service.impl;

import com.eraykosterelioglu.dto.DtoDepartment;
import com.eraykosterelioglu.dto.DtoEmployee;
import com.eraykosterelioglu.dto.DtoEmployeeIU;
import com.eraykosterelioglu.model.Department;
import com.eraykosterelioglu.model.Employee;
import com.eraykosterelioglu.repository.DepartmentRepository;
import com.eraykosterelioglu.repository.EmployeeRepository;
import com.eraykosterelioglu.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DtoEmployeeIU saveEmployee(DtoEmployeeIU dtoEmployeeIU) {

        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployeeIU,employee);

        Department department = new Department();
        BeanUtils.copyProperties(dtoEmployeeIU.getDtoDepartmentIU(),department);

        Optional<Department> optional = departmentRepository.findById(department.getId());

        if(optional.isEmpty()) {
            return null;
        }

        employee.setDepartment(optional.get());

        Employee dbEmployee = employeeRepository.save(employee);
        BeanUtils.copyProperties(dbEmployee,dtoEmployeeIU);
        return dtoEmployeeIU;
    }

    @Override
    public DtoEmployee findEmployeeById(Long id) {

        Optional<Employee> optional = employeeRepository.findById(id);

        if(optional.isEmpty()) {
            return null;
        }
        Employee employee = optional.get();
        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(optional.get().getDepartment(),dtoDepartment);

        DtoEmployee dtoEmployee = new DtoEmployee();
        BeanUtils.copyProperties(employee,dtoEmployee);
        dtoEmployee.setDtoDepartment(dtoDepartment);

        return dtoEmployee;
    }
}
