package com.paomanz.pma.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class httpRequestTest {

   @LocalServerPort
   private int port;

   /* TestRestTemplate :
   *  - allows us to do the same process and request as using
   *  a normal rest api, but TestRestTemplate inherits from a separate
   *  superclass. It's intentionally created this way to prevent injection
   *  problems that could corrupt the rest template the production uses.
   * */
   @Autowired
   private TestRestTemplate restTemplate;

   @Test
   public void homePageReturnsVersionNumberCorrectly_thenSuccess() {
      String renderedHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
      assertTrue(renderedHtml.contains("3.3.3"));
   }
}
