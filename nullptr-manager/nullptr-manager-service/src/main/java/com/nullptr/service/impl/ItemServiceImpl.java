package com.nullptr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.common.utils.IDUtils;
import com.nullptr.mapper.TbItemDescMapper;
import com.nullptr.mapper.TbItemMapper;
import com.nullptr.mapper.TbItemParamMapper;
import com.nullptr.pojo.TbItem;
import com.nullptr.pojo.TbItemDesc;
import com.nullptr.pojo.TbItemExample;
import com.nullptr.pojo.TbItemExample.Criteria;
import com.nullptr.pojo.TbItemParam;
import com.nullptr.pojo.TbItemParamExample;
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
	@Autowired
	private TbItemDescMapper itemDescMapper;

	@Autowired
	private TbItemParamMapper itemparamMapper;

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

	@Override
	public EasyUiDataGridResult getItemParamList(int page, int rows) {
		// TODO Auto-generated method stub
		System.out.println("page = " + page + "  rows = " + rows);
		// 分页处理
		PageHelper.startPage(page, rows);
		TbItemParamExample itemParamExample = new TbItemParamExample();
		System.out.println("itemParamExample : " + itemParamExample.getOredCriteria());
		// 查询所有数据
		List<TbItemParam> list = itemparamMapper.selectByExample(itemParamExample);
		for (TbItemParam tbItemParam : list) {
			System.out.println(tbItemParam.getId());
		}
		// System.out.println(list.toArray().toString());
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);

		EasyUiDataGridResult result = new EasyUiDataGridResult();

		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		System.out.println("result : " + result.getTotal() + "  " + result.getRows());

		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item, String desc) {
		// TODO Auto-generated method stub

		// 生成商品ID
		long itemId = IDUtils.genItemId();

		item.setId(itemId);

		// 商品状态：1-正常、2-下架、3-删除
		item.setStatus((byte) 1);
		// 创建时间和更新时间
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		// 插入商品表
		itemMapper.insert(item);

		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		// 插入商品描述
		itemDescMapper.insert(itemDesc);

		return TaotaoResult.ok();
	}

}
