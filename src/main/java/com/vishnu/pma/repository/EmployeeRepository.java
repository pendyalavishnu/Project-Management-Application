package com.vishnu.pma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vishnu.pma.dto.EmployeeProject;
import com.vishnu.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " + 
			"from employee e left join project_employee pe " + 
			"on e.employee_id=pe.employee_id " + 
			"group by e.first_name,e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
}
