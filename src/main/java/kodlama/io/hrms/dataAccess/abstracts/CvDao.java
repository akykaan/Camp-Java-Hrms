package kodlama.io.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dtos.CvDto;

public interface CvDao extends JpaRepository<Cv, Integer>{
	//List<Cv> getAllCv();	
	Cv getById(int id);
	
					  
	/*@Query("Select new  kodlama.io.hrms.entities.dtos.CvDto"
	  		+ "(c.cvId, c.candidate, c.jobExperience,"
	  		+ "c.progLanguage,c.language,c.school,c.githubLink,c.linkedinLink,c.coverLetter) "
	  		+ "From c Inner Join c.products p")*/
	//List<CvDto> getAllCvDetails();
	
	
	
	/*
	 * 
	 * 
	 * SELECT cv.id,cover_letter,github_link,linkedin_linK,
languages.language_level,
languages.language_name,
programming_language.programming_language,
school.department_name,
school.school_name,
school.start_year,
school.end_year
FROM cv
INNER JOIN job_experience ON cv.id = job_experience.cv_id
INNER JOIN languages ON cv.id = languages.cv_id
INNER JOIN programming_language ON cv.id = programming_language.cv_id
INNER JOIN school ON cv.id = school.cv_id
WHERE cv.id=27
	 * 
	 */
}
