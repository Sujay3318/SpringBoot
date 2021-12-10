package com.project.project.service;

import java.util.List;

import com.project.project.entities.Employee;

public interface EmployeeServiceImp {

	public String saveData(Employee emp);
	public Employee saveEmployee(Employee emp);
	List<Employee> saveListEmployee(List<Employee> emp);
}
