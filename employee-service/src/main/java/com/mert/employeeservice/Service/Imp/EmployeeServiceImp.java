package com.mert.employeeservice.Service.Imp;

import com.mert.employeeservice.Dto.APIResponseDto;
import com.mert.employeeservice.Dto.DepartmentDto;
import com.mert.employeeservice.Dto.EmployeeDto;
import com.mert.employeeservice.Entity.Employee;
import com.mert.employeeservice.Repository.EmployeeRepository;
import com.mert.employeeservice.Service.EmployeeService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;

    public EmployeeServiceImp(EmployeeRepository employeeRepository,ModelMapper modelMapper,RestTemplate restTemplate) {
        this.employeeRepository=employeeRepository;
        this.restTemplate =restTemplate;
        this.modelMapper=modelMapper;
    }


    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);

        return savedEmployeeDto;
    }

    @Override
    public List<EmployeeDto> getAll() {

        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream().map(employee -> modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());

    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).get();

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/getDepartmentByCode/" + employee.getDepartmentCode(),
                DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }
}
