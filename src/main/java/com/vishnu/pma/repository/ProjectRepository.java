package com.vishnu.pma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vishnu.pma.dto.ChartData;
import com.vishnu.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Long> {
	@Query(nativeQuery=true, value="select  stage as label, count(*) as value " + 
			"from project " + 
			"group by stage")
	public List<ChartData> getProjectStatus();
}
