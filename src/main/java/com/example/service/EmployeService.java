package com.example.service;

import java.util.List;

import com.example.exceptions.ResourseNotFoundException;
import com.example.model.Employee;

public interface EmployeService {

	Employee save(Employee emp);

	List<Employee> getAllEmployees();

	Employee findById(long empid) throws ResourseNotFoundException;

	Employee update(long empid, Employee emp) throws ResourseNotFoundException;

	void deleteByid(long empid) throws ResourseNotFoundException;

}
