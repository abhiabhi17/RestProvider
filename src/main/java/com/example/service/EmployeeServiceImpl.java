package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptions.ResourseNotFoundException;
import com.example.model.Employee;
import com.example.repo.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeService{

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee findById(long empid) throws ResourseNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> opt= empRepo.findById(empid);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else {
			throw new ResourseNotFoundException("Resource Notfound");
		}
	}

	@Override
	public Employee update(long empid, Employee emp) throws ResourseNotFoundException {
		// TODO Auto-generated method stub
		Employee em=empRepo.findById(empid).orElseThrow(()-> new ResourseNotFoundException("ResourceNotFound"));
		em.setFirstName(emp.getFirstName());
		em.setLastName(emp.getLastName());
		em.setEmail(emp.getLastName());
		return em;
	}

	@Override
	public void deleteByid(long empid) throws ResourseNotFoundException {
		// TODO Auto-generated method stub
		empRepo.findById(empid).orElseThrow(()-> new ResourseNotFoundException("not found"));
		empRepo.deleteById(empid);
		return;
	}
	
	
}
