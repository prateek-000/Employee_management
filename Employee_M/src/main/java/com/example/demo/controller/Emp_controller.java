package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Emp_controller {

	@Autowired
	private EmpService service;
	
	
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp =service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index" ;
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		
		return "add_emp" ;
	}
	
	@GetMapping("/check")
	public String checking() {
		
		return "word" ;
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg", "employee added successfuly");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employee e=service.getEMpById(id);
	
		m.addAttribute("emp",e);
		
		return "edit" ;
		
		
	}
}
