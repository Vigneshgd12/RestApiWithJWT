package com.techorak.moneycatcha.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techorak.moneycatcha.models.UserDetails;
import com.techorak.moneycatcha.models.UserRoles;

@Service
public interface UserDetailsService {
	

	List<UserDetails> getUSers();
	
	UserDetails getUSerDetails(long id);
	
	UserDetails addUser(UserDetails details);
	
//	UserDetails updateUser(UserDetails details);
//	
//	void deleteUser(UserDetails details);

	UserRoles addUserRoles(UserRoles userRoles);

	List<UserRoles> getAllUserRoles();
}
