package com.techorak.moneycatcha.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techorak.moneycatcha.clients.ReqResClientService;
import com.techorak.moneycatcha.clients.model.Employee;


@RestController
@RequestMapping("api/v1")
public class EmployeeController {


	private ReqResClientService clientService;
	
	@Autowired
	public EmployeeController(ReqResClientService clientService) {
		this.clientService = clientService;
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return new ResponseEntity<List<Employee>>(clientService.getAllEmployees(response),HttpStatus.valueOf(response.getStatus()));
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) throws Exception{
		return new ResponseEntity<Employee>(clientService.getEmployeeById(id,response),HttpStatus.valueOf(response.getStatus()));
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(HttpServletRequest request, HttpServletResponse response, @RequestBody Employee details) throws Exception{
		return new ResponseEntity<Employee>(clientService.addEmployee(details,response),HttpStatus.valueOf(response.getStatus()));
	}
	
	@PutMapping("/employee")
	public ResponseEntity<String> updateUSers(HttpServletRequest request, HttpServletResponse response, @RequestBody Employee details) throws Exception{
		return new ResponseEntity<String>(clientService.updateEmployee(details,response),HttpStatus.valueOf(response.getStatus()));
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteUSers(HttpServletRequest request, HttpServletResponse response, @PathVariable long id ) throws Exception{
		return new ResponseEntity<String>(clientService.deleteEmployee(id,response),HttpStatus.valueOf(response.getStatus()));
	}
	
	
	
	

	
}
