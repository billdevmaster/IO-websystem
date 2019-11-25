package com.paomanz.pma.dao;


import com.paomanz.pma.dto.IEmployeeProject;
import com.paomanz.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
   @Override
   List<Employee> findAll();

   /* @Query
    *  - We want to find out how many projects each employee is assigned to.
    *  - Display the number of projects for each employee in the table.
    *
    *  nativeQuery means query that is specific to the database (H2).
    * */
   @Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) AS projectCount " +
           "FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id " +
           "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
   public List<IEmployeeProject> employeeProjects();
}
