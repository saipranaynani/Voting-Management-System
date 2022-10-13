package com.sdp3.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdp3.main.entity.Candidate;
import com.sdp3.main.entity.Election;
import com.sdp3.main.entity.User;
import com.sdp3.main.entity.Vote;
import com.sdp3.main.repository.CandidateRepo;
import com.sdp3.main.repository.ElectionRepo;
import com.sdp3.main.repository.VoteRepo;
import com.sdp3.main.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import antlr.StringUtils;



@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService service;
	
	@Autowired
	private CandidateRepo crepo;
	
	@Autowired
	private VoteRepo vrepo;
	
	@Autowired
	private ElectionRepo erepo;
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = service.getEmail(userName);
		model.addAttribute("user",user);
	}
	
	@GetMapping("/adminProfile")
	public String userProfile(Model model){
		model.addAttribute("title","This is Profile");
		return "admin/admin_profile";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		model.addAttribute("title","This is Dashboard");
		String username = principal.getName();
		
		
		
		return "admin/admin_dashboard";
	}
	
	
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	  @RequestMapping("/")
	  public String UploadPage(Model model) {
		  return "uploadview";
	  }
	  
	
    

    
	  @RequestMapping("allElections/viewcans/{id}/addCan")
	public String addCandidate(@PathVariable("id") int id,Model model) {
		
		model.addAttribute("eid",id);
		
		return "admin/add_candidate";
	}
	
	
	
	@PostMapping("/allElections/viewcans/{id}/saveCan")
	
	public String addcandidate(@PathVariable("id") int id,@ModelAttribute("Candidate") Candidate candidate,Model model,
			RedirectAttributes ra) {
		Election e = erepo.findElectionNameById(id);
		candidate.setElectionName(e.getElectionname());
		candidate.setElectionid(id);
       this.crepo.save(candidate);
       ra.addAttribute("id",id);
		return "redirect:/admin/allElections/viewcans/{id}";
	}
	
	@GetMapping("/addElection")
	public String addElection(Model model, Principal principal) {
		
		model.addAttribute("election",new Election());
		
		return "admin/add_election";
	}
	@PostMapping("/addelection")
	public String addelection(@ModelAttribute("Election") Election  election,Model model, Principal principal) {
		this.erepo.save(election);
		
		return "admin/admin_dashboard";
	}
	
	@GetMapping("/allElections")
	public String allElection(Model model, Principal principal) {
		
		List<Election> election=this.erepo.findAll();
		
		model.addAttribute("election",election);
		
		return "admin/all_elections";
	}
	@RequestMapping("allElections/viewcans/{id}")
	public String viewCandidates(@PathVariable("id") int id,Model model) {
		List<Candidate> canlist = crepo.findCansByElectionId(id);
		model.addAttribute("canlist",canlist);
		model.addAttribute("eid",id);
		return "admin/viewCans";
	}
	@RequestMapping("allElections/viewvotes/{id}")
	public String viewVotes(@PathVariable("id") int id,Model model) {
		List<Vote> vlist = vrepo.findAllById(id);
		model.addAttribute("vlist",vlist);
		return "admin/viewVotes";
	}
	
}