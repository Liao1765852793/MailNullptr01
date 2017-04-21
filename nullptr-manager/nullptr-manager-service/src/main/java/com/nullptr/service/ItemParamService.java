package com.nullptr.service;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;

public interface ItemParamService {
	// 查询参数列表
	EasyUiDataGridResult getItemParamList(int page, int rows);

	// 查询是否存在规格参数
	TaotaoResult getItemParamByCid(Long cid);

	// 向tb_item_param 表中插入数据
	TaotaoResult insertItemParam(Long cid, String param_data);

	// 从tb_item_param表中删除id为ids的记录
	TaotaoResult deleteItemById(Long [] ids);
}
