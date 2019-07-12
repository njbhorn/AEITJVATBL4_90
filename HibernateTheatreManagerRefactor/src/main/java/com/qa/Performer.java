package com.qa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Performer {
	
	@Id
	private int membershipID ;
	private String firstName ;
	private String surname ;
	private int height ;
	@ManyToOne
	@JoinColumn ( name = "GroupID" )
	private int groupID ;
	
	
	public Performer() {
		
	}
	
	public Performer(int membershipID, String firstName, String surname, int height, int groupId) {
		super();
		this.membershipID = membershipID;
		this.firstName = firstName;
		this.surname = surname;
		this.height = height;
		this.groupID = groupId;
	}
	
	public int getMembershipID() {
		return membershipID;
	}
	public void setMembershipID(int membershipID) {
		this.membershipID = membershipID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	
	

}
