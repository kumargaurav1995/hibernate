package com.project.com.hibernate4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.project.com.hibernate4.Vehicle;

@Entity
@Table(name="User_Details")
public class UserDetails2 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int userId;
	private String userName;
	//@OneToMany(mappedBy="user")
	//@ManyToMany
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="User-Vehicle", joinColumns=@JoinColumn(name="User_Id"),inverseJoinColumns=@JoinColumn(name="Vehicle_Id"))
	private Collection<Vehicle> vehicle= new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street", column=@Column(name="HOME_STREET-NAME") ),
	@AttributeOverride(name="city", column=@Column(name="HOME_CITY-NAME") ),
	@AttributeOverride(name="state", column=@Column(name="HOME_STATE-NAME") ),	
	@AttributeOverride(name="pincode", column=@Column(name="HOME_PINCODE") ),		
	})
	private Address homeAddress;
    @Embedded
    private Address officeAddress;
    
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	private String description;
	@Transient
	private String qualification;
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	
	@Lob
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="Name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
