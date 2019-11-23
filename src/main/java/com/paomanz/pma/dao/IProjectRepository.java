package com.paomanz.pma.dao;

import com.paomanz.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IProjectRepository extends CrudRepository<Project, Long> {
   @Override
   List<Project> findAll();
}
