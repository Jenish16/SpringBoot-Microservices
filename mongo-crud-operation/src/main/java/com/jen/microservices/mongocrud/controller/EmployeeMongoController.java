package com.jen.microservices.mongocrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jen.microservices.mongocrud.entity.EmployeeMongo;
import com.jen.microservices.mongocrud.repository.EmployeeRepository;

@RestController
@RequestMapping("/mongo")
public class EmployeeMongoController {

	@Autowired
	public EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public List<EmployeeMongo> findEmployeeById(){
		return employeeRepository.findAll();
				
	}	
	
	@GetMapping("/{empId}")
	public EmployeeMongo findAllEmployees(@PathVariable String empId){
		
		Optional<EmployeeMongo> emp = employeeRepository.findById(empId);
		
		if(emp.isPresent()) {
			return emp.get();
		}else {
			return new EmployeeMongo("", 0, 0.00);
		}
				
	}	
	
	@PostMapping("/")
	public EmployeeMongo createDept(@RequestBody EmployeeMongo employeeMongo) {
		employeeRepository.save(employeeMongo);
		return employeeMongo;
	}
	
	@PutMapping("/{empId}")
    public EmployeeMongo updateDept(@RequestBody EmployeeMongo employeeMongo, @PathVariable String empId) {
		employeeMongo.setEmpId(empId);
        employeeRepository.save(employeeMongo);
        return employeeMongo;
    }
	@DeleteMapping("/{empId}")
    public String deleteDept(@PathVariable String empId) {
		
		employeeRepository.deleteById(empId);
        return empId;
    }
}
