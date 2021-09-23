package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;
import kodlama.io.hrms.entities.dtos.CvWithProgrammingLanguageDto;

@RestController
@RequestMapping("/api/programming_language")
@CrossOrigin
public class ProgrammingLanguageController {

	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ProgrammingLanguage>> getAll(){
		return this.programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingLanguage programmingLanguage) {
		return this.programmingLanguageService.add(programmingLanguage);
	} 
	
	@PostMapping("/addprogrammingLanguageforcandidatecv")
	public Result addProgrammingLanguageForCandidateCv(@RequestBody CvWithProgrammingLanguageDto cvWithProgrammingLanguageDto,
			ProgrammingLanguage programminglanguage) {
		return this.programmingLanguageService.addProgrammingLanguageForCandidate
				(cvWithProgrammingLanguageDto, programminglanguage);
	}
}
