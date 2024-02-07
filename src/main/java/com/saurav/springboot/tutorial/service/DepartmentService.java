package com.saurav.springboot.tutorial.service;

import com.saurav.springboot.tutorial.entity.Department;
import com.saurav.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.*;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public Boolean deleteDepartmentById(Long departmentId);

    public Object updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByDepartmentName(String departmentName);

}
