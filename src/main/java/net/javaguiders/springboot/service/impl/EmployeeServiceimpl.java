package net.javaguiders.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import net.javaguiders.springboot.exception.ResourseNotFoundException;
import net.javaguiders.springboot.model.Employee;
import net.javaguiders.springboot.reposatariy.EmployeeReposatariy;
import net.javaguiders.springboot.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	private EmployeeReposatariy employeeReposatariy;
//	private CrudRepository<Employee, Long> employeeReposatariy;
	

	public EmployeeServiceimpl(EmployeeReposatariy employeeReposatariy) {
		super();
		this.employeeReposatariy = employeeReposatariy;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeReposatariy.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		return employeeReposatariy.findAll();
}


	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee=employeeReposatariy.findById(id);
//		if(employee.isPresent())
//		{
//			return employee.get();
//		}
//		else
//		{
//			throw new ResourseNotFoundException("Employee", "Id", id);
//		}
		return employeeReposatariy.findById(id).orElseThrow(() ->
		new ResourseNotFoundException("Employee", "Id", id));
}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
//		we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee=employeeReposatariy.findById(id).orElseThrow(() ->
		new ResourseNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
//		save existing employee to DB
		employeeReposatariy.save(existingEmployee);
		return existingEmployee;
	}
	@Override
	public void deleteEmployee(long id)
	{
		employeeReposatariy.findById(id).orElseThrow(() ->
		new ResourseNotFoundException("Employee", "id",id));
		employeeReposatariy.deleteById(id);
		
		
	}
}