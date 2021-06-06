package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) 
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name="candidates")

public class Candidate extends User{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
		
	//@Column(name="candidate_image")
	//private String candidateImage;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private int birthYear;
		
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<Cv> cv;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="cv_id")
	//private Cv cv;
	
	//@OneToMany(mappedBy = "candidateId",cascade = CascadeType.ALL)
	//private List<Cv> CvCandidateId;
}
