package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// named queries - allow us to create reusable queries (remember, Query has full DML as well 
// as DQL, so it's not an exact mapping onto PL/SQL views)
@NamedQueries({ @NamedQuery(name = "getAllBats", query = "from Bat"), // notice this is HQL - not referencing
																		// tables/columns, but Java objects
		@NamedQuery(name = "getBatsByCave", query = "from Bat where cave.id = :caveVar") })

/*
 * this class is mapped to a DB table using JPA (Java Persistence API)
 * annotations Hibernate has its own, but convention is to use JPA
 */
@Entity // indicates that the class represents a DB entity.
@Table(name = "BAT") // use this if you want to change the name of the generated/mapped table
public class Bat {

	public Bat() {
		super();
	}

	public Bat(String name) {
		super();
		this.name = name;
	}

	public Bat(String name, double wingspan) {
		super();
		this.name = name;
		this.wingspan = wingspan;
	}

	public Bat(int id, String name) {
		super();
		this.name = name;
		this.id = id;
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
	private double wingspan = 20.0;

	// can set up "cascade" - allows transitive persistence
	// can cause DML ops to "cascade" onto related entities (e.g. can create a new
	// Cave if a Bat is created with an unknown Cave)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CAVE_ID")
	private Cave cave;

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

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "Bat [id=" + id + ", name=" + name + ", wingspan=" + wingspan + ", cave=" + cave + "]";
	}

}
