package com.sdp3.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	@GeneratedValue
	private int id;
	private String candidatename;
	private String partyid;
	private String partyname;
	private int electionid;
	private String election_name;
	
	
	public int getElectionid() {
		return electionid;
	}
	public void setElectionid(int electionid) {
		this.electionid = electionid;
	}
	public String getElectionName() {
		return election_name;
	}
	public void setElectionName(String electionName) {
		this.election_name = electionName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCandidatename() {
		return candidatename;
	}
	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}
	public String getPartyid() {
		return partyid;
	}
	public void setPartyid(String partyid) {
		this.partyid = partyid;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public Bank(int id, String candidatename, String partyid, String partyname, int electionid,
			String electionName) {
		super();
		this.id = id;
		this.candidatename = candidatename;
		this.partyid = partyid;
		this.partyname = partyname;
		this.electionid = electionid;
		this.election_name = electionName;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
