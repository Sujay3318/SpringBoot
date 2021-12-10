package com.project.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.Dto.EmployeeDto;
import com.project.project.entities.Employee;
import com.project.project.service.EmployeeService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		String str = employeeService.saveData(emp);
		System.out.println(str);
		if (str != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("data added");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no data");
		}
	}

	@PostMapping("/saveemp")
	public ResponseEntity<Employee> saveEmployeeData(@RequestBody Employee emp) {
		Employee responseEmp = employeeService.saveEmployee(emp);
		if (responseEmp != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(responseEmp);

		} else {
			System.out.println("no data saved");
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
		}
	}

	@PostMapping("/saveempdto")
	public ResponseEntity<EmployeeDto> saveEmployeeDto(@RequestBody Employee emp) {
		Employee responseEmp = employeeService.saveEmployee(emp);
		EmployeeDto empdto = new EmployeeDto();
		if (responseEmp != null) {
			empdto.setEmployeeName(responseEmp.getEmployeeName());
			empdto.setEmailId(responseEmp.getEmailId());
			empdto.setPhoneNumber(responseEmp.getPhoneNumber());
			return ResponseEntity.status(HttpStatus.CREATED).body(empdto);
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
	}

	@PostMapping("/saveListempdto")
	public ResponseEntity<List<EmployeeDto>> saveEmployeeDto(@RequestBody List<Employee> emp) {
		List<Employee> responseEmp = employeeService.saveListEmployee(emp);
		EmployeeDto empdto = new EmployeeDto();
		if (responseEmp != null) {
			empdto.setEmployeeName(responseEmp.get(0).getEmployeeName());
			empdto.setEmailId(responseEmp.get(0).getEmailId());
			empdto.setPhoneNumber(responseEmp.get(0).getPhoneNumber());
			// return ResponseEntity.status(,HttpStatus.C REATED).body(empdto);
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
	}


	@GetMapping("/getData")
	public List<Employee> getdata() {
		List<Employee>  listemp=employeeService.getalldata();
		return listemp;
	}
	
	//employee dto beacause we don't return the all object we return few things 
	//so we will create dto as password that we will not return we will return the dto
	@GetMapping("/getDataEmp")
	public List<EmployeeDto> getdataDto() {
		
		List<Employee>  listemp=employeeService.getalldata();
		List<EmployeeDto> empdtoList =new  ArrayList<EmployeeDto>();
		for(int i=0;i<listemp.size();i++)
		{
		System.out.println(listemp.get(i));
		
		EmployeeDto empdtoobj=new EmployeeDto();
		empdtoobj.setEmailId(listemp.get(i).getEmailId());
		empdtoobj.setEmployeeName(listemp.get(i).getEmployeeName());
		empdtoobj.setPhoneNumber(listemp.get(i).getPhoneNumber());
		
		empdtoList.add(empdtoobj);	
		}
		return empdtoList;
	}

	// id is unique so we will get one data
	@GetMapping("/getData/{employeeId}")
	public Optional<Employee> getacctoId(@PathVariable Integer employeeId) {
		Optional<Employee> emp = employeeService.getdatabyid(employeeId);
		return emp;
	}

	//url for this is ->http://localhost:7979/employee/getParameterData?employeeId=1
	@GetMapping("/getParameterData")
	public Optional<Employee> getacctoParam(@RequestParam Integer employeeId) {
		Optional<Employee> emp = employeeService.getdatabyid(employeeId);
		return emp;
	}
	
}
