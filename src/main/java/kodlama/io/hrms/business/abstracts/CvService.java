package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dtos.CvDto;

public interface CvService {
	DataResult<List<Cv>> getAll();
	Result add(Cv cv);	
	DataResult<Cv> getById(int id);
	
	Cv getByCvId(int id);
	
	Result addCv(CvDto cvDto);
	
}
