package com.example.DemoRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.DemoRegistration.dao.EmployeeDaoJPA;
import com.example.DemoRegistration.entity.Employee;

@Service
@Repository
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoJPA employeeDao;
	
	@Override
	public List<Employee> findAll() 
	{
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id ) 
	{
		Employee employee = null;
		Optional<Employee> result = employeeDao.findById(id);
		if(result.isPresent())
		{
			employee = result.get();
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void deleteById(int id) 
	{
		employeeDao.deleteById(id);
	}

}
