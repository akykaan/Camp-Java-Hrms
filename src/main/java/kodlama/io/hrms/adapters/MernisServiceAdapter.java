package kodlama.io.hrms.adapters;


import org.springframework.stereotype.Service;



@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean CheckIfRealPerson(String tc,String firstName,String lastName,int birthDate) {
		// Dogrulama icin sahte bir yapı
		return true;
	}

}
