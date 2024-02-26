package com.mert.employeeservice.Service;

import com.mert.employeeservice.Dto.APIResponseDto;
import com.mert.employeeservice.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);
    List<EmployeeDto> getAll();

    APIResponseDto getEmployeeById(Long id);

}
