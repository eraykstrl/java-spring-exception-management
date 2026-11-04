package com.eraykosterelioglu.service.impl;

import com.eraykosterelioglu.dto.DtoDepartment;
import com.eraykosterelioglu.dto.DtoEmployee;
import com.eraykosterelioglu.dto.DtoEmployeeIU;
import com.eraykosterelioglu.exception.BaseException;
import com.eraykosterelioglu.exception.ErrorMessage;
import com.eraykosterelioglu.exception.MessageType;
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
    public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU) {

        Employee employee = new Employee();
        employee.setName(dtoEmployeeIU.getName());

        Optional<Department> optional = departmentRepository.findById(dtoEmployeeIU.getDepartmentId());

        if(optional.isEmpty()) {
            System.out.println("Boş geldi optional");
            return null;
        }

        Department department = optional.get();
        employee.setDepartment(department);
        Employee dbEmployee = employeeRepository.save(employee);

        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(department,dtoDepartment);
        DtoEmployee dtoEmployee = new DtoEmployee();
        BeanUtils.copyProperties(dbEmployee,dtoEmployee);
        dtoEmployee.setDtoDepartment(dtoDepartment);

        return dtoEmployee;
    }

    @Override
    public DtoEmployee findEmployeeById(Long id) {

        Optional<Employee> optional = employeeRepository.findById(id);

        if(optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
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
