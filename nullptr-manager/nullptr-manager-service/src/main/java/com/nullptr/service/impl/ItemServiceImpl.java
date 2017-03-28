package com.nullptr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nullptr.mapper.TbItemMapper;
import com.nullptr.pojo.TbItem;
import com.nullptr.pojo.TbItemExample;
import com.nullptr.pojo.TbItemExample.Criteria;
import com.nullptr.service.ItemService;

/**
 * 商品查询Service
 * 
 * @author Nullptr
 *
 */

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(Long itemId) {
		TbItemExample example = new TbItemExample();
		// 创建查询条件
		Criteria criteria = example.createCriteria();

		criteria.andIdEqualTo(itemId);

		List<TbItem> list = itemMapper.selectByExample(example);

		TbItem item = null;
		if (list.size() > 0 && list != null) {
			item = list.get(0);
		}
		return item;
	}

}
