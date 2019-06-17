package com.techorak.moneycatcha.enums;

public enum Roles {

	ADM("ADM", "Admin"),
	USR("USR", "User"),
	GUE("GUE", "Guest");
	
	String roleType;
	String roleDesc;
	
	Roles(String roleType, String roleDesc){
		this.roleType = roleType;
		this.roleDesc = roleDesc;
	}
	
	
}
