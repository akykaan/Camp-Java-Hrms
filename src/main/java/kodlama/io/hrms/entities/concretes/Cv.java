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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobExperience","school"})
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")	
	private List<JobExperience> jobExperience;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")	 
	private List<School> school;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")	
	private List<ProgrammingLanguage> programmingLanguage;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")	
	private List<Language> language;
	
	@JsonIgnore
	@OneToOne(mappedBy = "cv")	
	private Image image;
	
	
	
}
