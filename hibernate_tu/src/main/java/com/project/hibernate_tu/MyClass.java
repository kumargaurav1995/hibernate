package com.project.hibernate_tu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity 
//@NamedQuery(name="MyClass.byId", query="from MyClass where roll =?")
public class MyClass {

	
@Id
	private int roll;
	private String name;
	private String color;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
