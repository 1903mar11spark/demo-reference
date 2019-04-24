package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * this class is mapped to a DB table using JPA (Java Persistence API) annotations
 * Hibernate has its own, but convention is to use JPA
 */
@Entity // indicates that the class represents a DB entity.
@Table(name = "BAT") // use this if you want to change the name of the generated/mapped table
public class Bat {

	public Bat() {
		super();
	}

	public Bat(int id, String name, double wingspan) {
		super();
		this.id = id;
		this.name = name;
		this.wingspan = wingspan;
	}

	@Id // indicates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "batSequence")
	@SequenceGenerator(allocationSize = 1, name = "batSequence", sequenceName = "SQ_BAT_PK")
	@Column(name = "BAT_ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "WINGSPAN")
	private double wingspan;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWingspan() {
		return wingspan;
	}

	public void setWingspan(double wingspan) {
		this.wingspan = wingspan;
	}

	@Override
	public String toString() {
		return "Bat [id=" + id + ", name=" + name + ", wingspan=" + wingspan + "]";
	}

}
