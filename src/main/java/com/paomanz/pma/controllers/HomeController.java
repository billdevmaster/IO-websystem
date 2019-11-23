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

   @GetMapping
   public String displayHome(Model model) {
      return "main/home";
   }

}
