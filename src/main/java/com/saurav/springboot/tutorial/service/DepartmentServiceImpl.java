package com.saurav.springboot.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurav.springboot.tutorial.entity.Department;
import com.saurav.springboot.tutorial.error.DepartmentNotFoundException;
import com.saurav.springboot.tutorial.repository.DepartmentRepository;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);

    }

    @Override
    public List<Department> fetchAllDepartmentList() {
        return departmentRepository.findAll();

    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        } 

        return department.get();

    }

    @Override
    public Boolean deleteDepartmentById(Long departmentId) {
        if (departmentRepository.findById(departmentId).isPresent()) {

            departmentRepository.deleteById(departmentId);

            return true;

        } else {
            return false;
        }
    }

    @Override
    public Object updateDepartment(Long departmentId, Department department) {
        Department depFromDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depFromDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depFromDB.setDepartmentName(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentAddress())
                && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depFromDB.setDepartmentName(department.getDepartmentAddress());
        }

        return departmentRepository.save(depFromDB);

    }

    @Override
    public Department fetchDepartmentByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
