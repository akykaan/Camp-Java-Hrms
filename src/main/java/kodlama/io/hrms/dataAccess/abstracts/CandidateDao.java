package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	List<Candidate> findByEmail(String email);
	List<Candidate> findByIdentityNumber(String identityNumber);
	Candidate getById(int id);
	Candidate getByFirstNameAndPassword(String firstName,int password);
}
