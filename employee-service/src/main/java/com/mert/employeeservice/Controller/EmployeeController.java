package com.mert.employeeservice.Controller;

import com.mert.employeeservice.Dto.APIResponseDto;
import com.mert.employeeservice.Dto.EmployeeDto;
import com.mert.employeeservice.Repository.EmployeeRepository;
import com.mert.employeeservice.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;



    @PostMapping("/save")
    ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.save(employeeDto);

        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<EmployeeDto>> getAll() {
        List<EmployeeDto> getEmployeeList = employeeService.getAll();

        return new ResponseEntity<>(getEmployeeList,HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<APIResponseDto> getById(@PathVariable("id") Long id) {
    APIResponseDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

}
