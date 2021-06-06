package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.dtos.CvWithJobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	private CvService cvService;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao,CvService cvService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.cvService=cvService;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAll(),"İs tecrübeleri getirildi.");
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Yeni is tecrübesi eklendi.");
	}

	@Override
	public Result addJobExperienceForCandidate(CvWithJobExperienceDto cvWithJobExperienceDto,
			JobExperience jobExperience) {
		
		jobExperience.setCv(this.cvService.getByCvId(cvWithJobExperienceDto.getCvId()));
		jobExperience.setWorkplaceName(cvWithJobExperienceDto.getWorkPlaceName());
		jobExperience.setPosition(cvWithJobExperienceDto.getPosition());
		jobExperience.setStartYear(cvWithJobExperienceDto.getStartYear());
		jobExperience.setEndYear(cvWithJobExperienceDto.getEndYear());
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("yeni iş deneyimi eklendi.");
		
	}
}
