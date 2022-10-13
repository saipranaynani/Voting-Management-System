package com.sdp3.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdp3.main.entity.Election;


public interface ElectionRepo extends JpaRepository<Election, Integer> {

	@Query("FROM Election AS e WHERE e.electionid = :id")
	Election findElectionNameById(int id);

}
