package com.jen.microservices.mongocrud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeJpa {

	
	@Id
	@GeneratedValue
	private int empId;
	
    private String name;
    
    private int age;
    
    private double salary;

    public EmployeeJpa() {}
    
	public EmployeeJpa(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeJpa [empId=" + empId + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
    
    
}
