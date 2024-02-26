package com.mert.departmentservice.service.Imp;

import com.mert.departmentservice.dto.DepartmentDto;
import com.mert.departmentservice.entity.Department;
import com.mert.departmentservice.repository.DepartmentRepository;
import com.mert.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImp implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;

    public DepartmentServiceImp(DepartmentRepository departmentRepository,ModelMapper modelMapper) {
        this.departmentRepository= departmentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = modelMapper.map(departmentDto,Department.class);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment,DepartmentDto.class);

        return  savedDepartmentDto;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.findAll();

        return allDepartments.stream().map(department -> modelMapper.map(department,DepartmentDto.class)).collect(Collectors.toList());
    }
    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Optional<Department> getDepartment = departmentRepository.findById(id);

        if(!getDepartment.isEmpty()) {
            DepartmentDto getDepartmentDto = modelMapper.map(getDepartment.get(),DepartmentDto.class);

            return getDepartmentDto;

        } else  {
            return null;
        }
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {

        Department getDepartment = departmentRepository.findDepartmentByDepartmentCode(code);


        DepartmentDto getDepartmentDto = modelMapper.map(getDepartment,DepartmentDto.class);

        return getDepartmentDto;



         }
}
