package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	@Query("From JobAdvert where isActive=true")
	List<JobAdvert> getByIsActive();
	
	@Query("From JobAdvert where isActive=false")
	List<JobAdvert> getByIsNotActive();
	
	
	@Query("From JobAdvert where typeOfWork=:typeOfWork and cityName=:cityName")
	List<JobAdvert> getJobAdvertFilterDetails(String typeOfWork,String cityName);
	
	/*@Query("select j from JobAdvert j where j.workingTime LIKE %?1%"
			+" OR j.typeOfWork LIKE %?1%")*/
	@Query("select j from JobAdvert j where concat(j.workingTime,' ',j.typeOfWork) LIKE %?1%")
	List<JobAdvert> search(String keyword);
	
	@Query("select j from JobAdvert j where concat(j.workingTime,' ',j.cityName) LIKE %?1%") // sehir ve calısma tipi
	List<JobAdvert> searchKeywordAndPageable(String keyword,Pageable pageable);
}
