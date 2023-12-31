package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add method to sort by first name
    // we have to fallow specific pattern to understand the spring data jpa "findAllOrderByFirstNameAsc"
    public List<Employee> findAllByOrderByFirstNameAsc();

}
