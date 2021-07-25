package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.User;
import kodlama.io.hrms.entities.dtos.LoginDto;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService) {
		super();
		this.employerDao = employerDao;
		this.userService=userService;
	}

	@Override
	public Result add(Employer employer) {
		if (this.userService.checkMail(employer.getEmail()).getData()!=null ) {
			return new ErrorResult("Böyle bir mail zaten var");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer eklendi.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Employer listelendi.");
	}

	@Override
	public Result login(LoginDto loginDto) {
		Employer employer=employerDao.findByEmail(loginDto.getEmail() );
		if ( emailCheck(employer) && passwordCheck(loginDto, employer)) {
			return new SuccessResult("giris yapıldı");
		}
		return new ErrorResult("mail veya sifre hatalı");
	}
	private boolean passwordCheck(LoginDto loginDto, Employer employer) {
		if(!employer.getPassword().equals(loginDto.getPassword())) {
			
			return false;
		}
		return true;
	}

	private boolean emailCheck(Employer employer) {
		if(employer==null) {
			return false;
		}
		return true;
	}
}
