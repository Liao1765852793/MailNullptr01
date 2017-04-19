package com.nullptr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.nullptr.common.pojo.PictureResult;
import com.nullptr.service.PictureService;

/**
 * 图片上传Controller
 * 
 * @author Nullptr
 *
 */

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		PictureResult result = pictureService.uploadPic(uploadFile);
		// String string = JSONUtils.toJSONString(result);
		// content-type 为text/plan
		return result;
	}

}
