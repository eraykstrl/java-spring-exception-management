package com.eraykosterelioglu.repository;

import com.eraykosterelioglu.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
