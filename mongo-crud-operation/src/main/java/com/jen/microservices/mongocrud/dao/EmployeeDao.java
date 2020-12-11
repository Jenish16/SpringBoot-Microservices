package com.jen.microservices.mongocrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jen.microservices.mongocrud.entity.EmployeeJpa;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeJpa, Integer>{

}
