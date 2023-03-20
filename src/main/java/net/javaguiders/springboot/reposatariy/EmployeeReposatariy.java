package net.javaguiders.springboot.reposatariy;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguiders.springboot.model.Employee;

public interface EmployeeReposatariy extends JpaRepository<Employee,Long>{

}
