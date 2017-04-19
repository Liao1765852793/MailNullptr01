package com.nullptr.common.pojo;

/**
 * 图片上传结果解析POJO类
 * JS中控件KindEditor的返回参数
 * @author Nullptr
 *
 */
public class PictureResult {
	//错误码
	private int error;
	//图片上传路径
	private String url;
	//信息
	private String message;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
