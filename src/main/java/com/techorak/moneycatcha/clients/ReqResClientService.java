package com.techorak.moneycatcha.clients;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techorak.moneycatcha.clients.model.Employee;

@Service
public class ReqResClientService {

	@Value("${rest.base.url}")
	String baseUrl;

	private RestTemplate restTemplate;
	
	public ReqResClientService() {
		this.restTemplate = new RestTemplate();
		
	}
	

	public List<Employee> getAllEmployees(HttpServletResponse response) {
		try {
			ResponseEntity<String> employeeResponse = restTemplate.exchange(
					baseUrl+"employees",HttpMethod.GET,null, String.class);
			if(employeeResponse.getStatusCode() == HttpStatus.OK) {
				String result = employeeResponse.getBody();
				ObjectMapper mapper = new ObjectMapper();
				List<Employee> employeeList = mapper.readValue(result, new TypeReference<List<Employee>>(){});
				if(CollectionUtils.isEmpty(employeeList)) {
					response.setStatus(404);
				}
				response.setStatus(200);
				return employeeList;
			}
		} catch (Exception e) {
			response.setStatus(400);
			e.printStackTrace();
		}
		return null;
	}
	
	public Employee getEmployeeById(long employeeId,HttpServletResponse response) {
		try {
			
			ResponseEntity<String> employeeResponse = restTemplate.exchange(baseUrl+"employee/"+employeeId,HttpMethod.GET,null,String.class);
			if(employeeResponse.getStatusCode() == HttpStatus.OK) {
				String result = employeeResponse.getBody();
				ObjectMapper mapper = new ObjectMapper();
				Employee employee = mapper.readValue(result, Employee.class);
				if(employee!= null && employee.getId() != 0)
					response.setStatus(200);
				else
					response.setStatus(404);
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
		return null;
	}
	
	public Employee addEmployee(Employee employee,HttpServletResponse response) {
		try {
			URI uri = new URI(baseUrl+"create");
			
			ResponseEntity<String> employeeResponse = restTemplate.postForEntity(uri, employee,String.class);
			if(employeeResponse.getStatusCode() == HttpStatus.OK) {
				String result = employeeResponse.getBody();
				ObjectMapper mapper = new ObjectMapper();
				response.setStatus(201);
				return mapper.readValue(result, Employee.class);
			}
		} catch (Exception e) {
			response.setStatus(400);
			e.printStackTrace();
		}
		return null;
	}
	
	public String updateEmployee(Employee e,HttpServletResponse response) {
		try {
			URI uri = new URI(baseUrl+"update/"+e.getId());
			restTemplate.put(uri, new Employee(e.getId(),	e.getEmployeeName(),e.getEmployeeSalary(),e.getEmployeeAge()));
			response.setStatus(200);
			return "updated suceesfully";
		} catch (Exception ex) {
			response.setStatus(400);
			ex.printStackTrace();
		}
		return "Error while updating";
	}
	
	public String deleteEmployee(long id,HttpServletResponse response) {
		try {
			URI uri = new URI(baseUrl+"update/"+id);
			restTemplate.delete(uri);
			response.setStatus(200);
			return "deleted suceesfully";
		} catch (Exception e) {
			response.setStatus(400);
			e.printStackTrace();
		}
		return "Error while deleting";

	}

}
