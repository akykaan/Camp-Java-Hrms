package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/job_adverts")
@CrossOrigin
public class JobAdvertController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {		
		return this.jobAdvertService.add(jobAdvert);
	}	
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("getAllByPage")
	public DataResult<List<JobAdvert>> getAll(int pageNo,int pageSize){
		return this.jobAdvertService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getallbyactive")
	public DataResult<List<JobAdvert>> getAllSortedByActive(){
		return this.jobAdvertService.getAllSortedByActive();
	}
	@GetMapping("/getallbynotactive")
	public DataResult<List<JobAdvert>> getAllByNotActive(){
		return this.jobAdvertService.getAllByNotActive();
	}
	
	@GetMapping("/getallbydate")
	public DataResult<List<JobAdvert>> getAllSortedByDate(){
		return this.jobAdvertService.getAllSortedByDate();
	}
	
	@PutMapping("/updatebyid/{Id}")
	public Result updateById(@PathVariable("Id") int id) {
		return this.jobAdvertService.updateById(id);
		
	}
	
	@GetMapping("/getbyjobadvertfilterdetails")
	public DataResult<List<JobAdvert>> getByJobAdvertFilterDetails
	(@RequestParam("typeOfWork") String typeOfWork,@RequestParam("cityName") String cityName){
		return this.jobAdvertService.getJobAdvertFilterDetails(typeOfWork, cityName);
	}
	
	@GetMapping("/search")
	public DataResult<List<JobAdvert>> getBySearch(String keyword,@RequestParam(defaultValue ="1",required = false) int pageNumber,@RequestParam(defaultValue="10",required = false)int pageSize){
		return this.jobAdvertService.getAllKeywordAndPageable(keyword,pageNumber,pageSize);
	}
	
	
}
