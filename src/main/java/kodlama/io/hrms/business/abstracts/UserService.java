package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.User;
import kodlama.io.hrms.entities.dtos.LoginDto;

public interface UserService {

	DataResult<List<User>> getAll();
	Result add(User user);
	DataResult<User> checkMail(String mail);
	
	Result login(LoginDto loginDto);
}
