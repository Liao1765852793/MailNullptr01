package com.nullptr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.nullptr.common.pojo.EasyUiDataGridResult;

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
		System.out.println("service  getItemById");
		System.out.println("itemId = " + itemId);
		TbItemExample example = new TbItemExample();
		// 创建查询条件
		Criteria criteria = example.createCriteria();

		criteria.andIdEqualTo(itemId);

		System.out.println(criteria.getAllCriteria().toArray().toString());

		List<TbItem> list = itemMapper.selectByExample(example);
		System.out.println("list = " + list.toString());
		TbItem item = null;
		if (list.size() > 0 && list != null) {
			item = list.get(0);
		}
		return item;
	}

	@Override
	public EasyUiDataGridResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		System.out.println("page = " + page + "  rows = " + rows);
		// 分页处理
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		System.out.println("example : " + example.getOredCriteria());

		// 需要查询所有数据，所以不需要给Example设置查询条件
		// 执行查询
		List<TbItem> list = itemMapper.selectByExample(example);

		// 取分页信息
		PageInfo<TbItem> pgInfo = new PageInfo<>(list);

		EasyUiDataGridResult result = new EasyUiDataGridResult();

		result.setTotal(pgInfo.getTotal());
		result.setRows(list);

		System.out.println("result : " + result.getTotal() + "  " + result.getRows());
		return result;
	}

}
