package com.mert.departmentservice.repository;

import com.mert.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

Department findDepartmentByDepartmentCode(String code);



}
