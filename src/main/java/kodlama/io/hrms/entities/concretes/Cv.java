package kodlama.io.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class Cv {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="active")
	private boolean active;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<JobExperience> jobExperience;
	
	//@OneToMany(mappedBy = "jobExperiences")
	///private List<JobExperience> 
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore //bunu koyunca swagger kısmında gözükmez
	private List<School> school;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<ProgrammingLanguage> programmingLanguage;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Language> language;
	
	@OneToOne(mappedBy = "cv")
	@JsonIgnore
	private Image image;
	
	//@ManyToOne
	//@JoinColumn(name="language_id")
	//private List<Language> languageId;
	
	//@OneToMany(mappedBy = "cv")
	//private List<Candidate> candidate;	
	
	//@ManyToOne
	//@JoinColumn(name="language_id")
	//private Language language;
	
	//@ManyToOne
	/*@JoinColumn(name="job_experience_id")
	private JobExperience jobExperience;
	
	@ManyToOne()
	@JoinColumn(name="programming_language_id")
	private ProgrammingLanguage programmingLanguage;
	
	@OneToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidateId;
	
	@ManyToOne()
	@JoinColumn(name="school_id")
	private School school;
	
	@OneToMany(mappedBy = "cvId")
	private List<School> schoolCvId;*/
	
	
}
