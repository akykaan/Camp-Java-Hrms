package kodlama.io.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.adapters.Cloudinary.CloudinaryService;
import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.concretes.Image;
import kodlama.io.hrms.entities.dtos.ImageDto;

@Service
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	private CvService cvService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService, CvService cvService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
		this.cvService = cvService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result add(ImageDto imageDto, MultipartFile multipartFile) throws IOException {
		
		Image image =new Image();
		image.setCv(this.cvService.getByCvId(imageDto.getCvId()));		
		
		Map<String, String> uploadImage = this.cloudinaryService.uploadImage(multipartFile).getData();
		
		image.setImageUrl(uploadImage.get("url")); // gelen datadan url cekmek icin
		
		this.imageDao.save(image);
		
		return new SuccessResult("image eklendi.");
	}

	
}
