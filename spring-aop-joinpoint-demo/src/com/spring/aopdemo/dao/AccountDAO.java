package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name,Servicecode;
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public void provideAccess() {
		
		System.out.println(getClass()+": Provided access to added account");
		
	}

	public String getName() {
		System.out.println(getClass()+": Executing getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": Executing setName");
		this.name = name;
	}

	public String getServicecode() {
		System.out.println(getClass()+": Executing getServiceCode");
		return Servicecode;
	}

	public void setServicecode(String servicecode) {
		System.out.println(getClass()+": Executing setServiceCode");
		Servicecode = servicecode;
	}

}
