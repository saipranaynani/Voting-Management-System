package com.sdp3.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Election {
	@Id
	@GeneratedValue
	private int id;
	private int electionid;
	public Election(int id, int electionid, String electionname, String startdate, String enddate) {
		super();
		this.id = id;
		this.electionid = electionid;
		this.electionname = electionname;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public int getElectionid() {
		return electionid;
	}
	public void setElectionid(int electionid) {
		this.electionid = electionid;
	}
	private String electionname;
	private String startdate;
	private String enddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getElectionname() {
		return electionname;
	}
	public void setElectionname(String electionname) {
		this.electionname = electionname;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	public Election() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
