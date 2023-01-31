package com.example.enesbaskale.business.services.impl;

import com.example.enesbaskale.business.dto.EmployeeDto;
import com.example.enesbaskale.business.services.EmployeeServices;
import com.example.enesbaskale.data.entity.EmployeeEntity;
import com.example.enesbaskale.data.repository.EmployeeRepository;
import com.example.enesbaskale.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    //List
    //http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> entityList = employeeRepository.findAll();
        for (EmployeeEntity entity:entityList){
            EmployeeDto employeeDto = EntityToDto(entity);
            listDto.add(employeeDto);
        }
        return listDto;
    }


    //Save
    //http:/localhost:8080/api/v1/employees/
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity= DtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }


    //FIND
    //http:/localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id " + id));
        EmployeeDto employeeDto = EntityToDto(employee); //model
        return ResponseEntity.ok(employeeDto);
    }


    //UPDATE
    //http:/localhost:8080/api/v1/employees
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long id,@RequestBody EmployeeDto employeeDetails) throws Throwable {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails); //Model Mapper
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id " + id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setEmailId(employeeEntity.getEmailId());
        employee.setLastName(employeeEntity.getLastName());

        EmployeeEntity updatedEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //DELETE
    //http:/localhost:8080/api/v1/employees/1
    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id " + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //Model Mapper
    //Entity ==> Dto
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    //DTO ==> Entity
    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
}
