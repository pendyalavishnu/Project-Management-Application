package com.vishnu.pma.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishnu.pma.dto.ChartData;
import com.vishnu.pma.dto.EmployeeProject;
import com.vishnu.pma.entities.Project;
import com.vishnu.pma.repository.EmployeeRepository;
import com.vishnu.pma.repository.ProjectRepository;

@Controller
public class HomeController {
	@Autowired
	ProjectRepository proRep;
	@Autowired
	EmployeeRepository empRep;
	
	@Value("${version}")
	String ver;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		HashMap<String,Object>map= new HashMap<>();
		List<Project> projects = (List<Project>) proRep.findAll();
		List<EmployeeProject> employeesProjectCnt = empRep.employeeProjects();
		List<ChartData> projectData = proRep.getProjectStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCnt",jsonString);
		model.addAttribute("projects", projects);
		model.addAttribute("employeesListProjectCnt", employeesProjectCnt);
		model.addAttribute("version", ver);
		return "main/home";
	}
}
