package com.vishnu.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vishnu.pma.entities.Employee;
import com.vishnu.pma.entities.Project;
import com.vishnu.pma.repository.EmployeeRepository;
import com.vishnu.pma.repository.ProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRep;
	@Autowired
	EmployeeRepository empRep;
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = (List<Employee>) empRep.findAll();
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aProject);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRep.save(project);
		
		
		return "redirect:/projects";
	}
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = (List<Project>) proRep.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
}
