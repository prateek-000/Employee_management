package com.example.demo.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepo;
@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	public void addEmp(Employee e) {
		
		repo.save(e);
	}
	
	public List<Employee> getAllEmp()
	{
		return repo.findAll();
	}
	
	public Employee getEMpById(int id) {
		
		java.util.Optional<Employee> e=repo.findById(id);
		if (e.isPresent()) {
			
			return e.get();
		}
		return null;
	}

}
