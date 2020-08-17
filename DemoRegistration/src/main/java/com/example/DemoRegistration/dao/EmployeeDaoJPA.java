package com.example.DemoRegistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoRegistration.entity.Employee;

public interface EmployeeDaoJPA extends JpaRepository<Employee, Integer>
{

}
