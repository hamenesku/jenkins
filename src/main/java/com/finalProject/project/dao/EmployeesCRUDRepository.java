package com.finalProject.project.dao;

import org.springframework.data.repository.CrudRepository;

import com.finalProject.project.entity.Employee;

public interface EmployeesCRUDRepository extends CrudRepository<Employee, Integer> {
	
	
}