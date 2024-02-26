package com.mert.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DepartmentDto {
    private Long id;
    private String departmentCode;
    private String department_description;
    private String department_name;
}
