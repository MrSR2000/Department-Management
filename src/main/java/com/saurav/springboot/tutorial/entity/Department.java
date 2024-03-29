package com.saurav.springboot.tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name")
    @NotNull(message = "Department name cannot be null")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    // we can use lombok to reducce boiler code

    // public Department() {
    // }

    // public Department(Long departmentId, String departmentName, String
    // departmentAddress, String departmentCode) {
    // this.departmentId = departmentId;
    // this.departmentName = departmentName;
    // this.departmentAddress = departmentAddress;
    // this.departmentCode = departmentCode;
    // }

    // public Long getDepartmentId() {
    // return departmentId;
    // }

    // public void setDepartmentId(Long departmentId) {
    // this.departmentId = departmentId;
    // }

    // public String getDepartmentName() {
    // return departmentName;
    // }

    // public void setDepartmentName(String departmentName) {
    // this.departmentName = departmentName;
    // }

    // public String getDepartmentAddress() {
    // return departmentAddress;
    // }

    // public void setDepartmentAddress(String departmentAddress) {
    // this.departmentAddress = departmentAddress;
    // }

    // public String getDepartmentCode() {
    // return departmentCode;
    // }

    // public void setDepartmentCode(String departmentCode) {
    // this.departmentCode = departmentCode;
    // }

    // @Override
    // public String toString() {
    // return "Department [departmentId=" + departmentId + ", departmentName=" +
    // departmentName
    // + ", departmentAddress=" + departmentAddress + ", departmentCode=" +
    // departmentCode + "]";
    // }
}
