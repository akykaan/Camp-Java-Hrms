package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithJobExperienceDto {
	
	private int cvId;	
	private String workPlaceName;
	private String position;
	private LocalDate startYear;
	private LocalDate endYear;	
}
