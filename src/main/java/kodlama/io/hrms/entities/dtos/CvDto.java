package kodlama.io.hrms.entities.dtos;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.JobExperience;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;
import kodlama.io.hrms.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {	
	private int cvId;
	private Candidate candidate;
	private List<JobExperience> jobExperience;
	private List<ProgrammingLanguage> progLanguage;
	private List<Language> language;
	private List<School> school;
	private String githubLink;
	private String linkedinLink;
	private String coverLetter;
}
