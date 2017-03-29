package com.nullptr.service;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(Long itemId);

	EasyUiDataGridResult getItemList(int page, int rows);
}
