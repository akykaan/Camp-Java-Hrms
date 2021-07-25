package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeesDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeesDao) {
		super();
		this.employeesDao = employeesDao;
	}

	@Override
	public Result add(Employee employees) {
		this.employeesDao.save(employees);
		return new SuccessResult("Yeni personel kayıt oldu");
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>
		(this.employeesDao.findAll(),"tüm personel getirildi.");
	}

	@Override
	public Result updateById(int id,Employee employees ) {
		Employee employeesId=this.employeesDao.findById(id).get();	
		employeesId.setFirstName(employees.getFirstName());
		employeesId.setLastName(employees.getLastName());
		employeesId.setAddress(employees.getAddress());
		employeesId.setPhoneNumber(employees.getPhoneNumber());
		this.employeesDao.save(employeesId);
		return new SuccessResult("Personel bilgisi degistirildi.");
	}
}
