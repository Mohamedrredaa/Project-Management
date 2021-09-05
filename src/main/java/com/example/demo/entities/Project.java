package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="Project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	
	private String projectName;
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", stage=" + stage
				+ ", description=" + description + ", employees=" + employees + "]";
	}

	private String stage;  //Not started, in_progress , completed 
	
	private String description ;
	
	
	
//	@OneToMany(mappedBy = "project")
//	private List<Employee> employees;
//	
	  
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee" , joinColumns =  @JoinColumn(name="Project_Id")
					, inverseJoinColumns =  @JoinColumn(name="Employee_Id"))
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	public Project() {
		
	}
	
	
	
	public Project(String projectName, String stage, String description) {
		super();
		this.projectName = projectName;
		this.stage = stage;
		this.description = description;
	}

	
	
	

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	

}
