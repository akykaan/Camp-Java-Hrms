package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

	private EmployeeService employeesService;
	
	@Autowired
	public EmployeeController(EmployeeService employeesService) {
		super();
		this.employeesService = employeesService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employee employees) {
		return this.employeesService.add(employees);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		return this.employeesService.getAll();
	}
	
	
	@PutMapping("/updatebyid/{id}")
	public Result updateById(@PathVariable(value = "id") int id,@RequestBody Employee employees) {		
		return this.employeesService.updateById(id,employees);
	}
}
