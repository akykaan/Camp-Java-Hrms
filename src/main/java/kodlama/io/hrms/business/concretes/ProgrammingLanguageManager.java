package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;
import kodlama.io.hrms.entities.dtos.CvWithProgrammingLanguageDto;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageDao programmingLanguageDao;
	private CvService cvService;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao,CvService cvService) {
		super();
		this.programmingLanguageDao = programmingLanguageDao;
		this.cvService=cvService;
	}

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguage>>
		(this.programmingLanguageDao.findAll(),"Programlama dilleri getirildi.");
	}

	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult("yeni bir dil eklendi.");
	}

	@Override
	public Result addProgrammingLanguageForCandidate(CvWithProgrammingLanguageDto cvWithProgrammingLanguageDto,ProgrammingLanguage programmingLanguage) {
		
		programmingLanguage.setCv(this.cvService.getByCvId(cvWithProgrammingLanguageDto.getCvId()));
		programmingLanguage.setProgrammingLanguage(cvWithProgrammingLanguageDto.getProgrammingLanguage());
		
		
		this.programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult("Yeni bir programlama dili cvye eklendi.");
	}

}
