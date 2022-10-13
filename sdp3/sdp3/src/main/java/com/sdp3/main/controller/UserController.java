package com.sdp3.main.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdp3.main.entity.Candidate;
import com.sdp3.main.entity.Election;
import com.sdp3.main.entity.User;
import com.sdp3.main.entity.Vote;
import com.sdp3.main.repository.CandidateRepo;
import com.sdp3.main.repository.ElectionRepo;
import com.sdp3.main.repository.UserRepo;
import com.sdp3.main.repository.VoteRepo;
import com.sdp3.main.service.UserService;

@Controller
@RequestMapping("/candidate")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private CandidateRepo crepo;
	
	@Autowired
	private ElectionRepo erepo;
	
	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private VoteRepo vrepo;
	
	
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = service.getEmail(userName);
		model.addAttribute("user",user);
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model,Principal principal) {
		String userName = principal.getName();
		User user = this.urepo.findByEmail(userName);
		
		model.addAttribute("title","This is Dashboard");
		return "candidate/candidate_dashboard";
	}
	
	
	@GetMapping("/candidateProfile")
	public String userProfile(Model model){
		model.addAttribute("title","This is Profile");
		return "candidate/candidate_profile";
	}
	
	@GetMapping("/addVote")
	public String allElection(Model model, Principal principal) {
		
		List<Election> election=this.erepo.findAll();
		
		model.addAttribute("election",election);
		
		return "candidate/vote";
	}
	
	@GetMapping("/addvote/{id}")
	public String addvote(Model model,@PathVariable("id") int id) {
		List<Candidate> canlist = crepo.findCansByElectionId(id);
		model.addAttribute("canlist",canlist);
		model.addAttribute("eid",id);
		return "candidate/addvote";
	}
	
	@PostMapping("/addvote/saveVote")
	 public  
	String saveVote(Model model,@ModelAttribute("Vote") Vote vote,Principal principal,RedirectAttributes ra) {
		String username = principal.getName();
		Election e = erepo.findElectionNameById(vote.getElectionid());
		vote.setElectionName(e.getElectionname());
		vote.setVotedBy(username);
		vote.setDatevoted(new java.util.Date());
		vrepo.save(vote);
		return "redirect:/candidate/dashboard";
	}
	
	
}
