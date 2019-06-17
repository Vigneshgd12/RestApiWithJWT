package com.techorak.moneycatcha.clients.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("employee_name")
	private String employeeName;
	
	@JsonProperty("employee_salary")
	private int employeeSalary;
	
	@JsonProperty("employee_age")
	private int employeeAge;
	
	@JsonProperty("profile_image")
	private String avatarURL;
	
	@JsonIgnore
	private String name;
	
	@JsonIgnore
	private long salary;
	
	@JsonIgnore
	private long age;
	
	public Employee(){
		
	}

	public Employee(Long id, String employeeName, int employeeSalary, int employeeAge, String avatarURL) {
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.avatarURL = avatarURL;
	}
	
	

	public Employee(long id, String name, long salary, long age) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

		
}
