package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.dtos.LoginDto;

public interface EmployerService {
	Result add(Employer employer);
	DataResult<List<Employer>> getAll();
	Result login(LoginDto loginDto);
}
