package com.paomanz.pma.dao;

import com.paomanz.pma.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


/**   @SpringBootTest
 *    -This annotation replaces the @ContextConfiguration because
 *    our Test Files is now, in the same package (com.paomanz.pma)
 *    as our 'ProjectManagementApplication.java' which SpringBoot can
 *    reference automatically for the context we needed to run
 *    pur tests.
 *
 *    @SqlGoup may or may Not be needed. It is up to us to use it, maybe
 *    for more of a custom data to inject. it's is more of a choice to
 *    opt for separate or other sql schemas to seed for testing purposes.
 * */
@SpringBootTest
@RunWith(SpringRunner.class)
/*@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")
})*/
public class ProjectRepositoryIntegrationTest {

   @Autowired
   IProjectRepository projectRepository;

   @Test
   public void ifNewProjectSaved_thenSuccess() {
      Project newProject = new Project("New test Project", "COMPLETE", "Test description");
      projectRepository.save(newProject);

//      assertEquals(5, projectRepository.findAll().size());
      assertEquals(1, projectRepository.findAll().size());
   }
}
