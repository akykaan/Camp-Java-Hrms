package kodlama.io.hrms.adapters.Cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	
	@SuppressWarnings("rawtypes")
	DataResult<Map> uploadImage(MultipartFile imageFile) throws IOException;
	
}
