package com.paomanz.pma.entities;

import javax.persistence.*;
import java.util.List;


@Entity
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")      // SEQUENCE is the fastest
   @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq",
           allocationSize = 1,initialValue=1)
   private long employeeId;

   private String firstName;
   private String lastName;
   private String email;

   /* Assignable Rules
    *  - cascade, fetch
    * */
   @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
           fetch = FetchType.LAZY)
   @JoinTable(name = "project_employee",
           joinColumns = @JoinColumn(name = "employee_id"),
           inverseJoinColumns = @JoinColumn(name = "project_id"))
   private List<Project> projects;

   // CONSTRUCTORS:
   public Employee() {
   }

   public Employee(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   // GET- SET:

   public long getEmployeeId() {
      return employeeId;
   }

   public void setEmployeeId(long employeeId) {
      this.employeeId = employeeId;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public List<Project> getProjects() {
      return projects;
   }

   public void setProjects(List<Project> projects) {
      this.projects = projects;
   }
}
