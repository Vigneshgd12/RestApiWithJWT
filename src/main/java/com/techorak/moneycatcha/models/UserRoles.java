package com.techorak.moneycatcha.models;

import javax.persistence.*;

import com.techorak.moneycatcha.enums.Roles;

@Entity(name = "user_roles")
public class UserRoles {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserDetails userDetails;
	
	@JoinColumn(name="role")
	private Roles roles;
	
	public UserRoles() {}

	public UserRoles(UserDetails userDetails, Roles roles) {
		super();
		this.userDetails = userDetails;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Roles setRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	

}
