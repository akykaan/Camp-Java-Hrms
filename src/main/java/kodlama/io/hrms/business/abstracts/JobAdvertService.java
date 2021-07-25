package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize);
	DataResult<List<JobAdvert>> getAllKeywordAndPageable(String keyword, int pageNo, int pageSize);
	DataResult<List<JobAdvert>> getAllSortedByActive();
	DataResult<List<JobAdvert>> getAllSortedByDate();
	DataResult<List<JobAdvert>> getAllByNotActive();
	
	DataResult<List<JobAdvert>> getJobAdvertFilterDetails(String typeOfWork,String cityName);
	
	Result updateById(int id);
	
	List<JobAdvert> search(String keyword);
	
	
}
