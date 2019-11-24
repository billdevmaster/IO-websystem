package com.paomanz.pma.controllers;

import com.paomanz.pma.dao.IEmployeeRepository;
import com.paomanz.pma.dao.IProjectRepository;
import com.paomanz.pma.entities.Employee;
import com.paomanz.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

   @Autowired
   IProjectRepository projectRepository;
   @Autowired
   IEmployeeRepository employeeRepository;

   @GetMapping
   public String displayHome(Model model) {
      // query data for Projects
      List<Project> projects = projectRepository.findAll();
      model.addAttribute("projectList", projects);

      // query data for Employees
      List<Employee> employees = employeeRepository.findAll();
      model.addAttribute("employeeList", employees);

      return "main/home";
   }

}
