package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>
		(this.cvDao.findAll(),"cvler geldi.");
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("yeni cv eklendi.");
	}

	@Override
	public DataResult<Cv> getById(int id) {
		return new SuccessDataResult<Cv>
		(this.cvDao.getById(id),"Data listelendi");	
	}

	@Override
	public Cv getByCvId(int id) {
		return this.cvDao.getById(id);		
	}

	@Override
	public Result addCv(CvDto cvDto) {		
		//Cv cv=cvDao.getById(cvDto.getCvId());
		Cv cv=new Cv();
		System.out.println("cv:"+cv);
		System.out.println("cv Id:"+cvDto.getCvId());
		cv.setJobExperience(cvDto.getJobExperience());
		System.out.println("tecrübe:"+cvDto.getJobExperience());
		cv.setProgrammingLanguage(cvDto.getProgLanguage());
		cv.setLanguage(cvDto.getLanguage());
		cv.setSchool(cvDto.getSchool());
		cv.setGithubLink(cvDto.getGithubLink());
		cv.setLinkedinLink(cvDto.getLinkedinLink());
		cv.setCoverLetter(cvDto.getCoverLetter());		
		this.cvDao.save(cv);
		return new SuccessResult("yeni cv eklendi.");
	}
}
