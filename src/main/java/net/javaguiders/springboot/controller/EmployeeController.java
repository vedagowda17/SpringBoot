package net.javaguiders.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguiders.springboot.exception.ResourseNotFoundException;
import net.javaguiders.springboot.model.Employee;
import net.javaguiders.springboot.reposatariy.EmployeeReposatariy;
import net.javaguiders.springboot.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
//	build create employee REST API
	
	@PostMapping()
	public HttpStatus saveEmployee(@RequestBody Employee employee)
	
	{
		employeeService.saveEmployee(employee);
		return HttpStatus.CREATED;
	}
//	build get All employee REST API
	
	@GetMapping()
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployee();
		
	}
//	build get employee by id REST API
	
//	http://localhost:8080/api/employee/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)

	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
	
//	build update employee REST API
	
//	http://localhost:8080/api/employee/1
	
	@PutMapping("employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	

	
	
	
	
//	build delete employee REST API
	
//	http://localhost:8080/api/employee/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}
//	
//	
//	@DeleteMapping("/employee/{id}")
//	public void deleteemployeeById(@PathVariable long id)
//	{
//			employeeService.deleteById(id);
//	}
}
