package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlama.io.hrms.entities.concretes.JobAdvert;


@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}
	
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("yeni is ilanı eklendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(),"is ilanları geldi.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllSortedByActive() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsActive());
	}


	@Override
	public DataResult<List<JobAdvert>> getAllSortedByDate() {
		
		Sort sort=Sort.by(Sort.Direction.ASC,"applicationDeadline");
		
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(sort));
	}


	

}
