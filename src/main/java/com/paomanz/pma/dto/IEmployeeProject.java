package com.paomanz.pma.dto;

public interface IEmployeeProject {

    /* dto = Data Transfer Object
    *  - Need tp have the property names begin with 'get'.
    *    That's how spring-data knows that this Data Transfer Object
    *    needs to be used to populate with the data coming from the table
    *    from the Custom Query we added in IEmployeeRepository.
    * */
   public String getFirstName();
   public String getLastName();
   public int getProjectCount();
}
