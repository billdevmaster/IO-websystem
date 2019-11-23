package com.paomanz.pma.controllers;

import com.paomanz.pma.dao.IEmployeeRepository;
import com.paomanz.pma.entities.Employee;
import com.paomanz.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

   @Autowired
   IEmployeeRepository employeeRepository;

   // GET: Display List of Employees
   @GetMapping
   public String displayEmployees(Model model) {
      // query data for Employee
      List<Employee> employees = employeeRepository.findAll();
      model.addAttribute("employeeList", employees);

      return "employees/list-employees";
   }

   @GetMapping("/new")
   public String displayEmpoyeeForm(Model model) {
      Employee aEmployee = new Employee();
      model.addAttribute("employee", aEmployee);

      return "employees/new-employee"; // this is pointing to the html file
   }

   @PostMapping("/save")
   public String createEmployee(Employee employee, Model model) {
      // save New Employee to DB
      employeeRepository.save(employee);

      return "redirect:/employees/new";   // This is pointing to the URL
   }
}
