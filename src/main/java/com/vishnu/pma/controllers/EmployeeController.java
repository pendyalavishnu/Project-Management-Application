package com.vishnu.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vishnu.pma.entities.Employee;
import com.vishnu.pma.entities.Project;
import com.vishnu.pma.repository.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeRepository empRep;
	@GetMapping("/new")
	public String displayEmpoyleeForm(Model model) {
		Employee emp= new Employee();
		model.addAttribute("employee",emp);
		return "employees/new-employee";
	}
	@PostMapping("/save")
	public String createEmployee(Model model,Employee employee) {
		empRep.save(employee);
		return "redirect:/employees/new";
	}
	@GetMapping
	public String displayHome(Model model) {
		List<Employee> employees = (List<Employee>) empRep.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
}
