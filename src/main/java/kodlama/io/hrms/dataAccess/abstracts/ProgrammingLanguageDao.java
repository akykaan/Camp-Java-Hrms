package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer>{

}
