package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	//fields and annotations
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;

	static int reviewCount=0;
	
	//constructors
	public Review() {

		//System.out.println("Review class: Default Constructor");
		
	}

	public Review(String comment) {
		super();
		this.comment = comment;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	//toString()
	@Override
	public String toString() {
		reviewCount++;
		return "Review "+reviewCount+":  [id=" + id + ", comment=" + comment + "]";
	}
	
}
