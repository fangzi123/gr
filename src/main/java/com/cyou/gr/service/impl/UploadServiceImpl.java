package com.cyou.gr.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cyou.gr.service.UploadService;
import com.cyou.gr.util.Constants;



@Service
@Transactional
public class UploadServiceImpl implements UploadService, InitializingBean {
	@Override
	public String doUpload(MultipartFile file, String fileType) {

		// 记录上传信息
		Boolean operFlag = true;
		String serverfilePath = "";
		try {
			// 保存到服务器指定路径下
			serverfilePath = copyFile2ServerPath(file, uploadPath);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			operFlag = false;
		}
		String singleFileName = ((CommonsMultipartFile) file).getFileItem()
				.getName();

		return serverfilePath;
	}

	/**
	 * copy上传文件至指定路径下
	 * 
	 * @param file
	 */
	private String copyFile2ServerPath(MultipartFile file, String uploadPath) {
		String singleFileName = ((CommonsMultipartFile) file).getFileItem()
				.getName();
		
		String fileSeparator = System.getProperty("file.separator");
		int pos = singleFileName.lastIndexOf(fileSeparator);
		if (pos >= 0) {
			singleFileName=singleFileName.substring(pos+1);
		}
		System.out.println("============singleFileName====" + singleFileName);
		//log.error("============singleFileName====" + singleFileName);
		// 处理上传文件
		String filename = DateTime.now().toString("yyyyMMddHHmmss");
		String newname = filename+fileSeparator + singleFileName;

		String newFilePath = uploadPath + fileSeparator
				+ DateTime.now().toString("yyyyMMdd");

		File directFile = new File(newFilePath);
		// 目录是否存在
		if (!directFile.isDirectory()) {
			// 创建日期（yyyyMMdd）目录
			directFile.mkdir();
		}

		String path = newFilePath + fileSeparator + newname;

		try {
			// copy 文件
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					path));
		} catch (IOException e1) {
			log.error("文件上传失败:" + e1.getMessage());
		}

		return path;
	}


	private transient Logger log = LoggerFactory.getLogger(this.getClass());

	private String uploadPath=Constants.UPLOADPATH;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(uploadPath, "请配置上传路径");
	}


}
