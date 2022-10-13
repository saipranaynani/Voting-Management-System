package com.sdp3.main.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote {
	@Id
	@GeneratedValue
	private int id;
	private String votedBy;
	private String electionName;
	private int electionid;
	private String candidatename;
	private String partyname;
	private int voted;
	private Date datevoted;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVotedBy() {
		return votedBy;
	}
	public void setVotedBy(String votedBy) {
		this.votedBy = votedBy;
	}
	public String getElectionName() {
		return electionName;
	}
	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}
	public int getElectionid() {
		return electionid;
	}
	public void setElectionid(int electionid) {
		this.electionid = electionid;
	}
	public String getCandidatename() {
		return candidatename;
	}
	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public int getVoted() {
		return voted;
	}
	public void setVoted(int voted) {
		this.voted = voted;
	}
	
	public Date getDatevoted() {
		return datevoted;
	}
	public void setDatevoted(Date datevoted) {
		this.datevoted = datevoted;
	}
	public Vote(int id, String votedBy, String electionName, int electionid, String candidatename, String partyname,
			int voted,Date datevoted) {
		super();
		this.id = id;
		this.votedBy = votedBy;
		this.electionName = electionName;
		this.electionid = electionid;
		this.candidatename = candidatename;
		this.partyname = partyname;
		this.voted = voted;
		this.datevoted=datevoted;
	}
	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
