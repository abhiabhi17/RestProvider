package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptions.ResourseNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;

@Api
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeService empService;
	
	
	@PostMapping("save")
	@ApiResponse(response=EmployeeController.class,code=200,message="Employee Saved")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(empService.save(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("getAll")
	@ApiResponse(response=EmployeeController.class,code=200,message="getallempolyees")
	public List<Employee> getAllEmployee()
	{
		System.out.println("====Rest PROVIDER  called=========");
		return empService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	@ApiResponse(response=EmployeeController.class,code=200,message="findbyeid")
	public ResponseEntity<Employee> findById(@PathVariable("id") long empid) throws ResourseNotFoundException{
		return new ResponseEntity<Employee>(empService.findById(empid),HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") long empid,@RequestBody Employee emp) throws ResourseNotFoundException
	{
		return new ResponseEntity<Employee>(empService.update(empid,emp),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long empid) throws ResourseNotFoundException
	{
		empService.deleteByid(empid);
		return new ResponseEntity<String>("Message Deleted",HttpStatus.OK);
		
	}
}
