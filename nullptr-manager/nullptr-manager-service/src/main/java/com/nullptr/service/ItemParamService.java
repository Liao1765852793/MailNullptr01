package com.nullptr.service;

import com.nullptr.common.pojo.EasyUiDataGridResult;

public interface ItemParamService {
	// 查询参数列表
	EasyUiDataGridResult getItemParamList(int page, int rows);
}
