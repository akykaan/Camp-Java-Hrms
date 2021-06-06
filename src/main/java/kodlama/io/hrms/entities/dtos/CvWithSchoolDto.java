package kodlama.io.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithSchoolDto {
	
	private int cvId;
	private String schoolName;
	private String departmentName;
	private String startYear;
	private String endYear;
}
