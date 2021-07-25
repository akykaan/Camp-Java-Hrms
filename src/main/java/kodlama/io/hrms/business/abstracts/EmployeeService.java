package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeService {
	Result add(Employee employees);
	DataResult<List<Employee>> getAll();
	Result updateById(int id,Employee employees);
}
