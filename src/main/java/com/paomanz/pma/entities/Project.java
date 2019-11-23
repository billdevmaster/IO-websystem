package com.paomanz.pma.entities;

import javax.persistence.*;
import java.util.List;


/* @Entity Annotation
 *  -  Specifies the class as a POJO that will be mapped to a DB Table.
 *     In this case, we will have a table for 'project/s',
 *     and this 'Entity' will be used to insert a new row/record
 *     that will persist all the properties from this Entity.
 * */
@Entity
public class Project {
   /* @GeneratedValue Annotation from Hibernate:
    *  -  Helps to MAP Java Objects to
    *     our DB Tables
    *  @Id Annotation from Java Persistence
    *  -  Generates the unique Identifier (projectId)
    *     for each project.
    * */

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long projectId;

   private String name;
   private String stage;   // Project status - NOT-STARTED, IN PROGRESS, COMPLETED, etc..
   private String description;

   /* Creates One-to-Many relationship
    *  - employeeId as ForeignKey
    *  - Use FK to have 1 project -> many employee
    *  - mappedBy argument refers to the property name
    *    in the Employee table. setting many employee
    *    can work on one/same project.
    * */
   @OneToMany(mappedBy = "project")
   private List<Employee> employees;

   // CONSTRUCTORS:
   public Project() {
   }

   public Project(String name, String stage, String description) {
      this.name = name;
      this.stage = stage;
      this.description = description;
   }


   // GET - SET
   public long getProjectId() {
      return projectId;
   }

   public void setProjectId(long projectId) {
      this.projectId = projectId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getStage() {
      return stage;
   }

   public void setStage(String stage) {
      this.stage = stage;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public List<Employee> getEmployees() {
      return employees;
   }

   public void setEmployees(List<Employee> employees) {
      this.employees = employees;
   }
}
