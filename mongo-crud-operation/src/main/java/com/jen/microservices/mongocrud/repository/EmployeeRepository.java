package com.jen.microservices.mongocrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jen.microservices.mongocrud.entity.EmployeeMongo;


public interface EmployeeRepository extends MongoRepository<EmployeeMongo, String>{

}
