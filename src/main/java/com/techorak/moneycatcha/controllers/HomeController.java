package com.techorak.moneycatcha.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techorak.moneycatcha.enums.Roles;
import com.techorak.moneycatcha.models.UserDetails;
import com.techorak.moneycatcha.models.UserRoles;
import com.techorak.moneycatcha.services.UserDetailsService;

@RestController
@RequestMapping("api/v1")
public class HomeController {
	
	private UserDetailsService userService;
	
	@Autowired
	public HomeController(UserDetailsService service) {
		this.userService = service;
	}
	
		
	@GetMapping("/users")
	public ResponseEntity<List<UserDetails>> getAllUsers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return new ResponseEntity<List<UserDetails>>(userService.getUSers(), HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDetails> getUserById(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) throws Exception{
		return new ResponseEntity<UserDetails>(userService.getUSerDetails(id), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserDetails> addUsers(HttpServletRequest request, HttpServletResponse response, @RequestBody UserDetails details) throws Exception{
		return new ResponseEntity<UserDetails>(userService.addUser(details), HttpStatus.OK);
	}
	
	
	@PostMapping("/user/{userId}/roles/{role}")
	public ResponseEntity<UserRoles> addUSerRoles(HttpServletRequest request,HttpServletResponse response,
												@PathVariable(value = "userId") Long userId,@PathVariable(value = "role") Roles roles){
		return new ResponseEntity<UserRoles>(userService.addUserRoles(new UserRoles(new UserDetails(userId), roles)),HttpStatus.OK);
	}
	
	@GetMapping("/user/roles")
	public ResponseEntity<List<UserRoles>> getAllUserRoles(HttpServletRequest request, HttpServletResponse response){
		return new ResponseEntity<List<UserRoles>>(userService.getAllUserRoles(),HttpStatus.OK);
	}
	
}
