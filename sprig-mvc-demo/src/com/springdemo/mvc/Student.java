package com.springdemo.mvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;

public class Student {

	private String firstName, lastName, country, course,gender,timezone;
	
	private String[] source;

	private LinkedHashMap<String, String> countryOptions,timezoneOptions;

	public Student() {

		countryOptions= new LinkedHashMap<>();
		timezoneOptions=new LinkedHashMap<>();
		countryOptions.put("India", "India");
		countryOptions.put("United States of America", "United States of America");
		countryOptions.put("Australia", "Australia");
		countryOptions.put("China", "China");
		countryOptions.put("Japan", "Japan");
		
		timezoneOptions.put("CST", "CST");
		timezoneOptions.put("IST", "IST");
		timezoneOptions.put("PST", "PST");
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	/*
	 * public LinkedHashMap<String, String> getCourseList() { return courseList; }
	 * 
	 * public void setCourseList(LinkedHashMap<String, String> courseList) {
	 * this.courseList = courseList; }
	 */

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public LinkedHashMap<String, String> getTimezoneOptions() {
		return timezoneOptions;
	}

	public String[] getSource() {
		return source;
	}

	public void setSource(String[] source) {
		this.source = source;
	}
	
	

}
