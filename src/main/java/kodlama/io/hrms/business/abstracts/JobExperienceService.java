package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.dtos.CvWithJobExperienceDto;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getAll();
	Result add(JobExperience jobExperience);
	
	Result addJobExperienceForCandidate(CvWithJobExperienceDto cvWithJobExperienceDto);
	
	DataResult<JobExperience> getById(int id);
}
