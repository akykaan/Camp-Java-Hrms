package kodlama.io.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvWithProgrammingLanguageDto {

	private int cvId;
	private String programmingLanguage;
	private int languageLevel;
}
