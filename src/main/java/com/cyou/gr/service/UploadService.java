package com.cyou.gr.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	String doUpload(MultipartFile file,String fileType);
	
}
