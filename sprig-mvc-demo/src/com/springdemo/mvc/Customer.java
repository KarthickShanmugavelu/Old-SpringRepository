package com.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springdemo.mvc.validation.CourseCode;
import com.springdemo.mvc.validation.ProductCode;

public class Customer {
	
	@NotNull(message="First Name must have a value")
	@Size(min=1, message="First Name must have a value")
	private String firstName;
	
	@NotNull(message="Last Name must have a value")
	@Size(min=1, message="Last Name must have a value")
	private String lastName;
	
	private String[] product;
	
	@NotNull(message="Age must have a value")
	@Min(value=1,message="Age must be greater than 1")
	@Max(value=100,message="Age must be less than 100")
	private Integer age;
	
	
	@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$",message="Please enter a valid email id.")
	private String emailid;
	
	@CourseCode(value="KS", message="Please make sure that the Course Code starts with KS :)")
	private String theCourseCode;
	
	@ProductCode(codeValue = {"PC","PDC","PDCTC","PDTC"})
	private String uniproductCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] getProduct() {
		return product;
	}

	public void setProduct(String[] product) {
		this.product = product;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getTheCourseCode() {
		return theCourseCode;
	}

	public void setTheCourseCode(String theCourseCode) {
		this.theCourseCode = theCourseCode;
	}

	public String getUniproductCode() {
		return uniproductCode;
	}

	public void setUniproductCode(String uniproductCode) {
		this.uniproductCode = uniproductCode;
	}

	
	
	
	

}
