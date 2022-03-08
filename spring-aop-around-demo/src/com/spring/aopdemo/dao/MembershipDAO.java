package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public String addMember() {
		
		return getClass()+" : DOING STUFF: ADDING A MEMBERSHIP";
	}
	
public void providePreveliges() {
		
		System.out.println(getClass()+": Provided previges to added member");
		
	}

}
