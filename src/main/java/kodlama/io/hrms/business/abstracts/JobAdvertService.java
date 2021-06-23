package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllSortedByActive();
	DataResult<List<JobAdvert>> getAllSortedByDate();
	
	//Result updateById(JobAdvert jobAdvert,int id);
	Result updateById(int id);
	
	
}
