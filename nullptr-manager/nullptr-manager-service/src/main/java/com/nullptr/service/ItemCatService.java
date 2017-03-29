package com.nullptr.service;

import java.util.List;

import com.nullptr.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	/**
	 * 根据传入参数id，去表tb_item_cat中获取商品类目信息，
	 * @param id
	 * @return EasyUITreeNode用于EasyUi中tree结构的展示,一個List
	 */
	public List<EasyUITreeNode> geTreeNode(long id);
}
