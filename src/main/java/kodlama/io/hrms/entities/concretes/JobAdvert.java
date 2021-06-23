package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_adverts")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_adverts"})

public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="open_position")
	private String openPosition;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd")
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
	@Column(name="application_date")
	private LocalDate applicationDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="working_time")
	private String workingTime;
	
	@Column(name="type_of_work")
	private String typeOfWork;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
}