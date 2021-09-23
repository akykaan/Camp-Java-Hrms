package kodlama.io.hrms.entities.filters;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilterDto {

	private int id;
	private String jobDescription;
	private String cityName;
	private String openPosition;	
	private LocalDate applicationDate;
	private LocalDate applicationDeadline;
	private String workingTime;
	private String typeOfWork;
}
