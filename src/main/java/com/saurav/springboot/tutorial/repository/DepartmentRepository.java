package com.saurav.springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.springboot.tutorial.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);

}