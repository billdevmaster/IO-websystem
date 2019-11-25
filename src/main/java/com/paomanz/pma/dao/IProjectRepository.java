package com.paomanz.pma.dao;

import com.paomanz.pma.dto.IEmployeeProject;
import com.paomanz.pma.dto.IChartData;
import com.paomanz.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IProjectRepository extends CrudRepository<Project, Long> {

   @Override
   List<Project> findAll();

   @Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) AS value, " +
           "FROM project " +
           "GROUP BY stage")
   public List<IChartData> getProjectStatus();

}
