package com.example.DemoRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DemoRegistration.entity.Employee;
import com.example.DemoRegistration.service.EmployeeService;

@Controller
public class DemoController
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String welcome(Model model)
	{
		List<Employee> employees  = employeeService.findAll();
		model.addAttribute("employee", employees);
		return "welcome";
	}
	
	@GetMapping("/updateemployee")
	public String showEditForm(@RequestParam("employeeId") int id, Model model)
	{
		// get Employee by ID
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employee-form";
	}
	@GetMapping("/addemployee")
	public String getEmployeeForm(Model model)
	{
		Employee employee = new Employee();			
		
		model.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute("Employee") Employee employee)
	{
		employeeService.save(employee);			
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteemployee")
	public String deleteEmployee(@RequestParam("employeeId") int id)
	{
		employeeService.deleteById(id);
		return "redirect:/";
	}
}
