package com.paomanz.pma.dao;


import com.paomanz.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
   @Override
   List<Employee> findAll();
}
