package kodlama.io.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) {		
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(pageable).getContent(),"is ilanları geldi.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllKeywordAndPageable(String keyword, int pageNo, int pageSize) {		
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		if(keyword!=null) {
			return new SuccessDataResult<List<JobAdvert>>
			(this.jobAdvertDao.searchKeywordAndPageable(keyword,pageable),"is ilanları geldi."); 
		}
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(pageable).getContent(),"is ilanları geldi.");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllSortedByActive() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsActive());
	}
	@Override
	public DataResult<List<JobAdvert>> getAllByNotActive() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsNotActive());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSortedByDate() {
		
		Sort sort=Sort.by(Sort.Direction.ASC,"applicationDeadline");
		
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(sort));
	}


	@Override
	public Result updateById(int id) {
		JobAdvert jobAdvertId=this.jobAdvertDao.findById(id).get();		
		
		jobAdvertId.setActive(true);
		this.jobAdvertDao.save(jobAdvertId);
		return new SuccessResult("iş ilanı aktifleştirildi.");
	}


	@Override
	public DataResult<List<JobAdvert>> getJobAdvertFilterDetails(String typeOfWork, String cityName) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getJobAdvertFilterDetails(typeOfWork, cityName),"Data listelendi.");
	}


	@Override
	public List<JobAdvert> search(String keyword) {
		if (keyword!=null) {
			return jobAdvertDao.search(keyword);
		}
		return jobAdvertDao.findAll();
	}
	
}
