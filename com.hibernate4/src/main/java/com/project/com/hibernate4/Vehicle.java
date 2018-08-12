package com.project.com.hibernate4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	/*ManyToMany(mappedBy="Vehicle")
	private Collection<UserDetails2> userlist =new ArrayList();
	public Collection<UserDetails2> getUserlist() {
		return userlist;
	}
	public void setUserlist(Collection<UserDetails2> userlist) {
		this.userlist = userlist;
	}*/
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	//JoinColumn(name="user_id")
	private UserDetails2 user;
	public UserDetails2 getUser() {
		return user;
	}
	public void setUser(UserDetails2 user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
}
