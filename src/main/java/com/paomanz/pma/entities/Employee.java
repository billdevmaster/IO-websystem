package com.paomanz.pma.entities;

import javax.persistence.*;


@Entity
public class Employee {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long employeeId;

   private String firstName;
   private String lastName;
   private String email;

   /* Assignable Rules of the OneToMany
    *  - cascade, fetch
    * */
   @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
           fetch = FetchType.LAZY)
   @JoinColumn(name = "project_id")
   private Project project;

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

   public Project getProject() {
      return project;
   }

   public void setProject(Project project) {
      this.project = project;
   }
}
