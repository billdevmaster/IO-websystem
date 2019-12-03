package com.paomanz.pma.controllers;

import com.paomanz.pma.dao.IEmployeeRepository;
import com.paomanz.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Constructor;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

   /* Field injection style(Not Recommended) -> Constructor Injection
    * @Autowired
    * IEmployeeRepository employeeRepository;
    */

   private final IEmployeeRepository employeeRepository;

   /** Constructor Injection */
   @Autowired
   public EmployeeController(IEmployeeRepository employeeRepository) {
      this.employeeRepository = employeeRepository;
   }

   // GET: Display List of Employees
   @GetMapping
   public String displayEmployees(Model model) {
      // query data for Employee
      List<Employee> employees = employeeRepository.findAll();
      model.addAttribute("employeeList", employees);

      return "employees/list-employees";
   }

   @GetMapping("/new")
   public String displayEmployeeForm(Model model) {
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
