package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result add(@RequestBody Employer employer,String confirmPass) {
		return this.authService.registerEmployer(employer, confirmPass);
	}
	
	@PostMapping("/registerCandidate")
	public Result add(@RequestBody Candidate jobHunter,String confirmPass) {
		return this.authService.registerCandidate(jobHunter, confirmPass);
	}
}
