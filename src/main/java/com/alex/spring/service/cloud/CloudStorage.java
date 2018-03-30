package com.alex.spring.service.cloud;

import org.springframework.web.multipart.MultipartFile;

public interface CloudStorage {
	
	String upload(MultipartFile file, String path, String fileName);
	
	String findFile(String path, String fileName);
}
