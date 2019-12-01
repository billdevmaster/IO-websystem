package com.paomanz.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paomanz.pma.dao.IEmployeeRepository;
import com.paomanz.pma.dao.IProjectRepository;
import com.paomanz.pma.dto.IChartData;
import com.paomanz.pma.dto.IEmployeeProject;
import com.paomanz.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/")
public class HomeController {

   /* Field injection style(Not Recommended) -> Constructor Injection
    * @Autowired
    * IProjectRepository projectRepository;
    * @Autowired
    * IEmployeeRepository employeeRepository;
    */

   private final IProjectRepository projectRepository;
   private final IEmployeeRepository employeeRepository;

   // Constructor Injection
   @Autowired
   public HomeController(IProjectRepository projectRepository, IEmployeeRepository employeeRepository) {
      this.projectRepository = projectRepository;
      this.employeeRepository = employeeRepository;
   }

   @GetMapping
   public String displayHome(Model model) throws JsonProcessingException {

      // Use for converting Chart Data into JSON
      Map<String, Object> map = new HashMap<>();

      //--- query data for Projects
      List<Project> projects = projectRepository.findAll();
      model.addAttribute("projectList", projects);


      //--- Custom query for project data
      List<IChartData> projectData = projectRepository.getProjectStatus();
      // Convert projectData object into a json structure for use in javascript(ChartsJs)
      ObjectMapper objectMapper = new ObjectMapper();
      String jsonString = objectMapper.writeValueAsString(projectData);

      model.addAttribute("projectStatusCount", jsonString);


      //--- query data for Employees
      List<IEmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
      model.addAttribute("employeeListProjectCount", employeesProjectCount);

      return "main/home";
   }

}
