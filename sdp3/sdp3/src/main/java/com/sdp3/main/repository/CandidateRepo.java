package com.sdp3.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sdp3.main.entity.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Integer>{

	@Query("FROM Candidate AS C WHERE C.electionid =:id")
	List<Candidate> findCansByElectionId(@Param("id") int id);
	
}
