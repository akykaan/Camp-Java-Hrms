package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;


public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);	
	Result add(Candidate candidate);
	DataResult<Candidate> getByFirstNameAndPassword(String userName,int password);
	//DataResult<List<Candidate>> findByEmail(String email);
	//DataResult<List<Candidate>> findByIdentityNumber(String identity_number);
	//boolean CheckIfRealPerson(Candidate candidate);
}
