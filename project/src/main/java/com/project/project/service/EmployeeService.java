package com.project.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project.dao.EmployeeDao;
import com.project.project.entities.Employee;

@Service
public class EmployeeService implements EmployeeServiceImp {

	@Autowired
	EmployeeDao empdao;

	@Override
	public String saveData(Employee emp) {

		Employee empsave = empdao.save(emp);
		if (empsave == null) {
			System.out.println("Employee details not saved");
			return "Employee details not saved";
		} else {
			System.out.println("Employee datails saved");
			return "Employee datails saved";
		}

	}

	public Employee saveEmployee(Employee emp) {
		// List<Employee> empsave=empdao.saveAll(emp);
		Employee empsave = empdao.save(emp);
		return empsave;
	}

	public List<Employee> saveListEmployee(List<Employee> emp) {
		List<Employee> empsave = empdao.saveAll(emp);
		// Employee empsave=empdao.save(emp);
		return empsave;
	}

	//here we will get only one data
	public Optional<Employee> getdatabyid(Integer id) {
	 return empdao.findById(id);

	}

	//here we will get all data so return type is like this
	public List<Employee> getalldata() {
		return 	empdao.findAll();
	}

}
