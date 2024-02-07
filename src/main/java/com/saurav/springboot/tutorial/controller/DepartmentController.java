package com.saurav.springboot.tutorial.controller;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurav.springboot.tutorial.entity.Department;
import com.saurav.springboot.tutorial.error.DepartmentNotFoundException;
import com.saurav.springboot.tutorial.service.DepartmentService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("inside post department ");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartmentList() {
        LOGGER.info("inside get department ");
        return departmentService.fetchAllDepartmentList();
    }

    @GetMapping("/departments/{departmentId}")
    public Department fetchDepartmentById(@PathVariable("departmentId") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId) {
        Boolean successful = departmentService.deleteDepartmentById(departmentId);

        if (successful) {

            return "Department deleted successfully";

        }
        return "No department found by id = " + departmentId;
    }

    @PutMapping("/departments/{departmentId}")
    public ResponseEntity updateDepartment(@PathVariable("departmentId") Long departmentId,
            @RequestBody Department department) {

        return ResponseEntity.ok(departmentService.updateDepartment(departmentId, department));

    }

    @GetMapping("/departments/departmentName/{departmentName}")
    public Department fetchDepartmentByName(@PathVariable("departmentName") String departmentName) {
        return departmentService.fetchDepartmentByDepartmentName(departmentName);
    }

}
