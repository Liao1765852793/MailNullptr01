package com.nullptr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;

	@RequestMapping("/list")
	@ResponseBody
	private EasyUiDataGridResult getItemParamList(Integer page, Integer rows) {
		EasyUiDataGridResult result = itemParamService.getItemParamList(page, rows);

		return result;
	}

	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemByCid(@PathVariable Long cid) {
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}

	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
		TaotaoResult result = itemParamService.insertItemParam(cid, paramData);
		return result;

	}

	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteItemByIds(Long[] ids) {
		/*
		 * for (Long string : ids) { System.out.println(string); }
		 */
		TaotaoResult result = itemParamService.deleteItemById(ids);
		return result;

	}
}
