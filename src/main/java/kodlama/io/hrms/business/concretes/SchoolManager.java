package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SchoolDao;
import kodlama.io.hrms.entities.concretes.School;
import kodlama.io.hrms.entities.dtos.CvWithSchoolDto;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	private CvService cvService;
	
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao,CvService cvService) {
		super();
		this.schoolDao = schoolDao;
		this.cvService=cvService;
	}

	@Override
	public DataResult<List<School>> getAll() {
		Sort sort=Sort.by(Sort.Direction.DESC,"endYear");
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAll(sort),"tüm okullar getirildi.");
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("basarılı");
	}

	@Override
	public Result addSchoolForCandidate(CvWithSchoolDto cvWithSchoolDto, School school) {
		
		school.setCv(this.cvService.getByCvId(cvWithSchoolDto.getCvId()));
		school.setSchoolName(cvWithSchoolDto.getSchoolName());
		school.setDepartmentName(cvWithSchoolDto.getDepartmentName());
		school.setStartYear(cvWithSchoolDto.getStartYear());
		school.setEndYear(cvWithSchoolDto.getEndYear());
		
		System.out.println("school:"+cvWithSchoolDto.getStartYear());
		System.out.println("school:"+cvWithSchoolDto.getEndYear());
		this.schoolDao.save(school);
		return new SuccessResult("Yeni bir okul eklendi.");
	}

}
