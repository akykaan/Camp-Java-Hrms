package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.School;
import kodlama.io.hrms.entities.dtos.CvWithSchoolDto;

@RestController
@RequestMapping("/api/school")
@CrossOrigin
public class SchoolController {

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	} 
	
	@PostMapping("/addschoolforcandidatecv")
	public Result addSchoolForCandidateCv(@RequestBody CvWithSchoolDto cvWithSchoolDto,School school) {
		System.out.println("api:"+cvWithSchoolDto.getEndYear());
		System.out.println("api:"+cvWithSchoolDto.getDepartmentName());
		return this.schoolService.addSchoolForCandidate(cvWithSchoolDto, school);
	}
	
}
