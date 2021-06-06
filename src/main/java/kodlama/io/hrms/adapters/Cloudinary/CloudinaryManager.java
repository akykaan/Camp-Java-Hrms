package kodlama.io.hrms.adapters.Cloudinary;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements CloudinaryService{

	private Cloudinary cloudinary;
	
	//Map<String,String> valuesMap=new HashMap<String, String>();
		
	public CloudinaryManager() {
//		valuesMap.put("cloud_name", "dixod4nlj");
//		valuesMap.put("api_key", "598568481392336");
//		valuesMap.put("api_secret", "D5MolmH_IBebq9E8ml5WOSkHzPE"); // üye olunca gelen üyelik bilgileri
//		this.cloudinary = new Cloudinary(valuesMap);
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dixod4nlj",
				"api_key", "598568481392336",
				"api_secret", "D5MolmH_IBebq9E8ml5WOSkHzPE"));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> uploadImage(MultipartFile imageFile) throws IOException {
		
		Map uploadResult =cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
		return new SuccessDataResult<>(uploadResult);
	}
}

