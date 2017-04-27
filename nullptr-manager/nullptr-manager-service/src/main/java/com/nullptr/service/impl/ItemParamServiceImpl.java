package com.nullptr.service.impl;

import java.util.Date;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.mapper.TbItemParamMapper;
import com.nullptr.pojo.TbItemParam;
import com.nullptr.pojo.TbItemParamExample;
import com.nullptr.pojo.TbItemParamExample.Criteria;
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
		List<TbItemParam> list = itemparamMapper.selectByExampleWithBLOBs(itemParamExample);

		// System.out.println(list.toArray().toString());
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);

		EasyUiDataGridResult result = new EasyUiDataGridResult();

		result.setTotal(pageInfo.getTotal());
		result.setRows(list);

		return result;

	}

	@Override
	public TaotaoResult getItemParamByCid(Long cid) {
		// TODO Auto-generated method stub
		// 查询条件
		TbItemParamExample itemParamExample = new TbItemParamExample();
		Criteria criteria = itemParamExample.createCriteria();
		criteria.andItemCatIdEqualTo(cid);

		// 执行查询
		List<TbItemParam> list = itemparamMapper.selectByExample(itemParamExample);
		
		// 判断是否查询到结果
		if (list != null && list.size() > 0) {
			TbItemParam itemParam = list.get(0);
			// 如果已经存在，返回带数据的TaotaoResult
			return TaotaoResult.ok(itemParam);
		}

		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(Long cid, String param_data) {
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(param_data);
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());

		// TODO Auto-generated method stub
		itemparamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteItemById(Long[] ids) {
		// TODO Auto-generated method stub
		for (Long long1 : ids) {
			itemparamMapper.deleteByPrimaryKey(long1);
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult getItemParamByCidcid(Long cid) {
		// TODO Auto-generated method stub
		TbItemParamExample itemParamExample = new TbItemParamExample();
		Criteria criteria = itemParamExample.createCriteria();
		criteria.andItemCatIdEqualTo(cid);

		// 执行查询
		List<TbItemParam> list = itemparamMapper.selectByExampleWithBLOBs(itemParamExample);
		for (TbItemParam tbItemParam : list) {
			System.out.println(tbItemParam.getParamData());
		}
		if (list.size() > 0 && list != null) {
			return TaotaoResult.ok(list.get(0));
		}
		return TaotaoResult.ok();
	}

}
