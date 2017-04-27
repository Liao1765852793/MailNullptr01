package com.nullptr.service;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(Long itemId);

	EasyUiDataGridResult getItemList(int page, int rows);
	
	
	//创建商品
	TaotaoResult createItem(TbItem item, String desc,String itemParam);
	
	//获取规格参数，用来展示在Html中
	String getItemParamByItemCid(Long itemId);
}
