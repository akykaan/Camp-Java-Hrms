package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;
import kodlama.io.hrms.entities.dtos.LoginDto;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Userlar getirildi.");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("user kayıt oldu.");
	}

	@Override
	public DataResult<User> checkMail(String mail) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(mail));
	}
	
	@Override
	public Result login(LoginDto loginDto) {
		User user= userDao.findByEmail(loginDto.getEmail());
			
		if ( emailCheck(user) && passwordCheck(loginDto, user)) {
			return new SuccessResult("giris yapıldı");
		}
		return new ErrorResult("mail veya sifre hatalı");
	}

	private boolean passwordCheck(LoginDto loginDto, User user) {
		if(!user.getPassword().equals(loginDto.getPassword())) {
			
			return false;
		}
		return true;
	}

	private boolean emailCheck(User user) {
		if(user==null) {
			return false;
		}
		return true;
	}
}
