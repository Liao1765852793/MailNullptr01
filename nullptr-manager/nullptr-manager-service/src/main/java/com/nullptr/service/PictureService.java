package com.nullptr.service;

import org.springframework.web.multipart.MultipartFile;

import com.nullptr.common.pojo.PictureResult;

public interface PictureService {

	public PictureResult uploadPic(MultipartFile picFile);
}
