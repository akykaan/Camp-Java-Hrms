package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService{

	private CandidateService candidateService;
	private EmployerService employerService;
	
	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
	}

	@Override
	public DataResult<Candidate> registerCandidate(Candidate candidate, String confirmPassword) {
		if(this.confirmPass(candidate.getPassword(), confirmPassword).isSuccess()) {
			var register=this.candidateService.add(candidate);
			return new SuccessDataResult<Candidate>(register.getMessage());
		}
		return new ErrorDataResult<Candidate>("register failed"); 
	}

	@Override
	public DataResult<Employer> registerEmployer(Employer employer, String confirmPassword) {
		if(this.confirmPass(employer.getPassword(), confirmPassword).isSuccess()) {
			if(this.checkEmailDomain(employer.getEmail(), employer.getWebAdress()).isSuccess()) {
				
			   this.employerService.add(employer);
			   
			   return new SuccessDataResult<Employer>(employer,"Kayıt olundu");
			}
			return new ErrorDataResult<Employer>(employer,"Domain ile mail eslesmedi");			
		}
		return new ErrorDataResult<Employer>("Hatalı kayıt");
	}
	
	private Result confirmPass(String password,String confirmPassword) {
		if (password.equals(confirmPassword)) {
			return new SuccessResult("Sifreler Eslesti");
		}
		return new ErrorResult("Sifreler Eslesmedi.");
	}
	
	private Result checkEmailDomain(String email,String website) {
		
		//iletisim@firmadi.com örn mail
		String[] mail=email.split("@",2); // limit-1 olarak calısır 2-1=1 tek @ alır
		// mail=firmadi.com olarak gelir.
		// website=firmadi.com 
		// mail==website eşit ise calısır
		String web=website.substring(4); // www kısmını silmek icin
		
		if(mail[1].equals(web)) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

}
