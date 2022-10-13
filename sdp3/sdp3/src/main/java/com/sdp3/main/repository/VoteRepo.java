package com.sdp3.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdp3.main.entity.Vote;

public interface VoteRepo extends JpaRepository<Vote, Integer>{

	@Query("FROM Vote as v WHERE v.electionid =:id")
	List<Vote> findAllById(int id);

}
