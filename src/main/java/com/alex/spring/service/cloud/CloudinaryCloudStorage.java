package com.alex.spring.service.cloud;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;

@Component
@PropertySource("classpath:cloudinary.properties")
public class CloudinaryCloudStorage implements CloudStorage {
	
	private Cloudinary cloudinary;
	
	public CloudinaryCloudStorage(Environment env) {
		cloudinary = new Cloudinary(env.getProperty("cloudinary.env"));
	}

	@Override
	public String upload(MultipartFile file, String path, String fileName) {
		
		Uploader uploader = cloudinary.uploader();
		
		Map<?,?> options = ObjectUtils.asMap(
				"public_id", fileName,
				"folder", path,
				"overwrite", true
		);
		
		Map<?,?> result = null;
		
		try {
			InputStream inputStream = file.getInputStream();
			result = uploader.uploadLarge(inputStream, options);
			inputStream.close();
		} catch(IOException e) {
			// XXX add logging here
			e.printStackTrace();
			return null;
		}
		
		return (String) result.get("url");
	}

	@Override
	public String findFile(String path, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
