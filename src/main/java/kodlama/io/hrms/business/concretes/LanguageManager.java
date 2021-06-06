package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.LanguageDao;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.dtos.CvWithLanguageDto;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	private CvService cvService;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao,CvService cvService) {
		super();
		this.languageDao = languageDao;
		this.cvService=cvService;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>
		(this.languageDao.findAll(),"Tüm diller getirildi.");
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Yeni bir dil eklendi.");
	}

	@Override
	public Result addLanguageForCandidate(CvWithLanguageDto cvWithLanguageDto, Language language) {
		language.setCv(this.cvService.getByCvId(cvWithLanguageDto.getCvId()));
		language.setLanguageLevel(cvWithLanguageDto.getLanguageLevel());
		language.setLanguageName(cvWithLanguageDto.getLanguage());
		this.languageDao.save(language);
		return new SuccessResult("Yeni bir dil eklendi.");
	}
}
