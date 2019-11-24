package com.paomanz.pma.controllers;

import com.paomanz.pma.dao.IEmployeeRepository;
import com.paomanz.pma.dao.IProjectRepository;
import com.paomanz.pma.entities.Employee;
import com.paomanz.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
   /*
    * @Autowire enables us to use the methods inherited from 'CrudRepository',
    * by automatically create a reference of the Interface (autowiring)
    * without using a constructor of this class, and this interface as its property.
    * */
   @Autowired
   IProjectRepository projectRepository;
   @Autowired
   IEmployeeRepository employeeRepository;

   // GET: Display List of Projects
   @GetMapping
   public String displayProjects(Model model) {
      // query data for Project
      List<Project> projects = projectRepository.findAll();
      model.addAttribute("projectList", projects);

      return "projects/list-projects";
   }

   @GetMapping("/new")
   public String displayProjectForm(Model model) {
      // Pass the project as Attribute
      Project aProject = new Project();   // create an empty Project object
      List<Employee> allEmployees = employeeRepository.findAll();    // Pass Employee as Attribute

      model.addAttribute("project", aProject);  // Bind the object to the form named as "project"
      model.addAttribute("allEmployees", allEmployees);  // Bind the object to the form named as "allEmployees"

      return "projects/new-project";   // points to the file
   }


   @PostMapping("/save")
   public String createProject(Project project, Model model) {

      // Save Project to the DB...
      projectRepository.save(project);

      return "redirect:/projects/new";    // Use redirect to prevent duplicate submissions
   }

}
