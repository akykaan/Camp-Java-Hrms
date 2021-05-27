package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Employer;

public interface AuthService {
	DataResult<Candidate> registerCandidate(Candidate candidate,String confirmPassword);
	DataResult<Employer> registerEmployer(Employer employer,String confirmPassword);
}
