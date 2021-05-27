package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Candidate;


public interface MailService {
	SuccessResult emailVerification(Candidate candidate);
}
