package com.nullptr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.mapper.TbItemParamMapper;
import com.nullptr.pojo.TbItemParam;
import com.nullptr.pojo.TbItemParamExample;
import com.nullptr.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemparamMapper;

	@Override
	public EasyUiDataGridResult getItemParamList(int page, int rows) {
		// TODO Auto-generated method stub
		// 分页处理
		PageHelper.startPage(page, rows);
		TbItemParamExample itemParamExample = new TbItemParamExample();
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

		return result;

	}

}
