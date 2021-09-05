package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.employeeRepository;
import com.example.demo.dao.projectRepository;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Project;

@Controller
@RequestMapping("/Projects")
public class ProjectController {
	
	
	@Autowired
	projectRepository projectRepo;  //This repository is used to make CRUD opertion through the Project table in db 
	
	@Autowired
	employeeRepository empRepo;  //This repository is used to make CRUD opertion through the Project table in db 
	
	
	@RequestMapping("/")
	public String displayProjectForm(Model model) {

		List<Project> Projects =  projectRepo.findAll();

		model.addAttribute("Projects" , Projects);
		
		return "projects.html";
		
		
	}
	@RequestMapping("/add")
	public String addNewProject(Model model) {
		List<Employee> employeesList =  empRepo.findAll();

		model.addAttribute("employeeList" , employeesList);
		model.addAttribute("project", new Project());
		return "new-project.html";
		
	}
	
	
	@PostMapping("/save")
	public String saveNewProject(@ModelAttribute("project") Project projectSubmitted , @RequestParam List<Long> employees) {
		
		System.out.println("Reached here ");
		System.out.println(projectSubmitted.toString());
		projectRepo.save(projectSubmitted);
		
		Iterable<Employee> employeeList=empRepo.findAllById(employees);
		
		for(Employee emp:employeeList) {
			emp.setProject(projectSubmitted);
			empRepo.save(emp);
		}
		
		return "redirect:/Projects/";   //This is to prevent duplicate submissions 
	}
}
