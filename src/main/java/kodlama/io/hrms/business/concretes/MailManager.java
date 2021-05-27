package kodlama.io.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.MailService;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Candidate;

@Service
public class MailManager implements MailService{
	
	@Override
	public SuccessResult emailVerification(Candidate candidate) {		
		return new SuccessResult("mail dogrulama basarılı");
	}
}
