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

import com.jen.microservices.mongocrud.dao.EmployeeDao;
import com.jen.microservices.mongocrud.entity.EmployeeJpa;

@RestController
@RequestMapping("/jpa")
public class EmployeeJPAController {

	@Autowired
	public EmployeeDao employeeDao;
	
	@GetMapping("/")
	public List<EmployeeJpa> findEmployeeById(){
		return employeeDao.findAll();
				
	}	
	
	@GetMapping("/{empId}")
	public EmployeeJpa findAllEmployees(@PathVariable int empId){
		
		Optional<EmployeeJpa> emp = employeeDao.findById(empId);
		
		if(emp.isPresent()) {
			return emp.get();
		}else {
			return new EmployeeJpa("", 0, 0.00);
		}
				
	}	
	
	@PostMapping("/")
	public EmployeeJpa createDept(@RequestBody EmployeeJpa employeeJpa) {
		
		employeeDao.save(employeeJpa);
		return employeeJpa;
	}
	
	@PutMapping("/{empId}")
    public EmployeeJpa updateDept(@RequestBody EmployeeJpa employeeJpa, @PathVariable int empId) {
		
		employeeJpa.setEmpId(empId);
		employeeDao.save(employeeJpa);
		
        return employeeJpa;
    }
	@DeleteMapping("/{empId}")
    public int deleteDept(@PathVariable int empId) {
		
		employeeDao.deleteById(empId);
        return empId;
    }
}
