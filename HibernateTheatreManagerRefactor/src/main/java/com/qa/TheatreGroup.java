package com.qa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TheatreGroup {
	
	@Id
	private int groupID ;
	private String groupName ;
	private int director ;
	private String regionID ;
	private Date dateStarted ;
	private double annualRevenue ;
	private String theatreName ;
////	@OneToMany ( mappedBy = "groupID" )
//	@OneToMany(targetEntity=com.qa.Performer.class, mappedBy="GroupID")
	private Set<Performer> performers = new HashSet<Performer>(0) ;
	
	public TheatreGroup() {
		
	}
	
	public TheatreGroup(int groupID, String groupName, int director, String regionID, Date dateStarted,
			double annualRevenue, String theatreName, Set<Performer> performers) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.director = director;
		this.regionID = regionID;
		this.dateStarted = dateStarted;
		this.annualRevenue = annualRevenue;
		this.theatreName = theatreName;
		this.performers = performers;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getDirector() {
		return director;
	}
	public void setDirector(int director) {
		this.director = director;
	}
	public String getRegionID() {
		return regionID;
	}
	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}
	public Date getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	public double getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public Set<Performer> getPerformers() {
		return performers;
	}
	public void setPerformers(Set<Performer> performers) {
		this.performers = performers;
	}
	
	
	

}
