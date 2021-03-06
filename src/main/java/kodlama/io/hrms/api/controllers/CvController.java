package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin
public class CvController {

	private CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	
	@GetMapping("/getAll")
	private DataResult<List<Cv>> getAll(){
		return this.cvService.getAll();
	}
	
	@PostMapping("/add")
	private Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	
	@GetMapping("/getById")
	public DataResult<Cv> getById(@RequestParam int id){
		return this.cvService.getById(id);
	}
	
	@PostMapping("/addCv")
	public Result addCv(@RequestBody CvDto cvDto) {
		return cvService.addCv(cvDto);
	}
	
}
