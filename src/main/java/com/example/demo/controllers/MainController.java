package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.employeeRepository;
import com.example.demo.dao.projectRepository;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Project;

@Controller
public class MainController {
	
		@Autowired
		employeeRepository empRepo;
		
		@Autowired
		projectRepository proRepo;
	
		@RequestMapping("/")
		public String displayMainPage(Model model) {

		
			
			List<Project> Projects =  proRepo.findAll();

			model.addAttribute("Projects" , Projects);
			
			
			List<Employee> employees =  empRepo.findAll();

			model.addAttribute("employees" , employees);
			
			return "main-page.html";
			
		}
}
