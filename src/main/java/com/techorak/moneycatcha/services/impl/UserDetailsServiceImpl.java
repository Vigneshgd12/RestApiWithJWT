package com.techorak.moneycatcha.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techorak.moneycatcha.models.UserDetails;
import com.techorak.moneycatcha.models.UserRoles;
import com.techorak.moneycatcha.repositories.UserDetailsRepository;
import com.techorak.moneycatcha.repositories.UserRolesRepository;
import com.techorak.moneycatcha.services.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private UserDetailsRepository detailsRepository;
	private UserRolesRepository userRolesRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserDetailsRepository detailsRepository,UserRolesRepository userRolesRepository) {
		this.detailsRepository = detailsRepository;
		this.userRolesRepository = userRolesRepository;
	}
	
	public List<UserDetails> getUSers(){
		List<UserDetails> details = new ArrayList<UserDetails>();
		detailsRepository.findAll().forEach(detail-> details.add(detail));
		return details;
	}
	
	public UserDetails getUSerDetails(long id) {
		return detailsRepository.findById(id).get();
	}
	
	public UserDetails addUser(UserDetails details) {
		return detailsRepository.save(details);
	}
//	
//	public UserDetails updateUser(UserDetails details) {
//		return detailsRepository.save(details);
//	}
//	
//	public void deleteUser(UserDetails details) {
//		detailsRepository.delete(details);
//	}
//	
	public UserRoles addUserRoles(UserRoles userRoles) {
		return userRolesRepository.save(userRoles);
	}
	
	public List<UserRoles> getAllUserRoles() {
		List<UserRoles> userRoles = new ArrayList<UserRoles>();
		userRolesRepository.findAll().forEach(userRole-> userRoles.add(userRole));
		return userRoles;
	}
}
