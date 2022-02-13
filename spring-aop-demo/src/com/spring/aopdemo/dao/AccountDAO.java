package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	
	public void provideAccess() {
		
		System.out.println(getClass()+": Provided access to added account");
		
	}

}
