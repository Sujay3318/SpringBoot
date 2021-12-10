package com.project.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.project.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{	
}
