package com.vishnu.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.vishnu.pma.entities.Project;
import com.vishnu.pma.repository.ProjectRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql","classpath:data.sql"}),
	@Sql(executionPhase=ExecutionPhase.AFTER_TEST_METHOD, scripts= "classpath:drop.sql")})
public class ProjectRepositoryIntegratinTest {

	@Autowired
	ProjectRepository proRep;
	
	@Test
	public void ifNewProjectIsSaved_thenSuccess()
	{
		Project newProject= new Project("blood finder","COMPLETED","List of Donors");
		proRep.save(newProject);
		
		assertEquals(5, proRep.count());
	}
}
