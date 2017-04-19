package com.nullptr.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nullptr.common.pojo.PictureResult;
import com.nullptr.common.utils.FastdfsClient;
import com.nullptr.service.PictureService;

/**
 * 图片上传的Service
 * 
 * @author Nullptr
 *
 */
@Service
public class PictureServiceImpl implements PictureService {

	@Value("${IMAGE_SERVER_BASE_URL}")
	private String IMAGE_SERVER_BASE_URL;

	@Override
	public PictureResult uploadPic(MultipartFile picFile) {
		PictureResult result = new PictureResult();
		// TODO Auto-generated method stub
		// 判断图片是否为空
		if (picFile.isEmpty()) {
			result.setError(1);
			result.setMessage("图片为空！");
			return result;
		}

		try {
			// 取图片原始的名字
			String originName = picFile.getOriginalFilename();
			// 取扩展名不要.
			String extName = originName.substring(originName.lastIndexOf(".") + 1);
			// 上传到图片服务器
			FastdfsClient fastdfsClient = new FastdfsClient("classpath:properties/client.conf");
			String url = fastdfsClient.uploadFile(picFile.getBytes(), extName);
			url = IMAGE_SERVER_BASE_URL + url;
			// 拼接url，加上图片服务器的域名或者IP地址

			result.setUrl(url);
			result.setMessage("图片上传成功！");
			result.setError(0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setError(1);
			result.setMessage("图片上传失败");
		}
		return result;
	}

}
