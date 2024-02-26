package com.mert.departmentservice.controller;


import com.mert.departmentservice.dto.DepartmentDto;
import com.mert.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DepartmentDto> getById(@PathVariable("id") Long id) {
        DepartmentDto getDepartmentDto = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(getDepartmentDto, HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<DepartmentDto>> saveDepartment() {
        List<DepartmentDto> getAllDepartments = departmentService.getAllDepartments();
        return new ResponseEntity<>(getAllDepartments, HttpStatus.ACCEPTED);
    }

     @GetMapping("/getDepartmentByCode/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code) {
         DepartmentDto getDepartmentsByCode = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(getDepartmentsByCode, HttpStatus.ACCEPTED);
        }
}
