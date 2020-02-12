package com.vishnu.pma.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private String port;
	@Test
	public void testVersionNum_thenSuccess() {
		String renderedHtml=this.restTemplate.getForObject("http://localhost:"+port+"/", String.class);
		assertEquals(renderedHtml.contains("test"),true);
	}
}
