package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;
import kodlama.io.hrms.entities.dtos.CvWithProgrammingLanguageDto;

public interface ProgrammingLanguageService {
	DataResult<List<ProgrammingLanguage>> getAll();
	Result add(ProgrammingLanguage programmingLanguage);
	
	Result addProgrammingLanguageForCandidate(CvWithProgrammingLanguageDto cvWithLanguageDto,ProgrammingLanguage programmingLanguage);
}
