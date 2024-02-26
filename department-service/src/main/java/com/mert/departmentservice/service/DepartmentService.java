package com.mert.departmentservice.service;

import com.mert.departmentservice.dto.DepartmentDto;
import com.mert.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto getDepartmentByCode(String code);
}
