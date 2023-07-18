package com.amarildo.crud_hibernate_thymeleaf.repository;

import com.amarildo.crud_hibernate_thymeleaf.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
