package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.adapters.MernisService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.MailService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private MailService mailService;
	private MernisService mernisService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MailService mailService,MernisService mernisService) {
		super();
		this.candidateDao = candidateDao;
		this.mailService=mailService;
		this.mernisService=mernisService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {		
		
		var email=candidate.getEmail();
		var identityNumber=candidate.getIdentityNumber();
		var checkPerson=this.mernisService.CheckIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear());
		
		if (checkPerson) {
			if( email==null && identityNumber==null) {
				return new ErrorResult("bu mail veya tcno zaten sistemde var");
			}
			this.candidateDao.save(candidate);
			this.mailService.emailVerification(candidate);
			return new SuccessResult("candidate kayıt oldu.");
		}
		return new ErrorResult("gercek bir kisi giriniz!");
		
	}
}
