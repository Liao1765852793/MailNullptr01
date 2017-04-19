package com.nullptr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.pojo.TbItem;
import com.nullptr.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemservice;

	@RequestMapping("items/{itemId}")
	@ResponseBody
	private TbItem getItemById(@PathVariable Long itemId) {
		System.out.println("items/{itemId}");
		TbItem item = itemservice.getItemById(itemId);
		return item;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	private EasyUiDataGridResult getItemList(Integer page, Integer rows) {
		System.out.println("controller:/item/list");
		EasyUiDataGridResult result = itemservice.getItemList(page, rows);
		return result;
	}

	@RequestMapping(value = "/item/save", method = RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItemDesc(TbItem item, String desc) {
		TaotaoResult result = itemservice.createItem(item, desc);

		return result;
	}

	@RequestMapping("/item/param/list")
	@ResponseBody
	private EasyUiDataGridResult getItemParamList(Integer page, Integer rows) {
		System.out.println("controller:/item/param/list");
		EasyUiDataGridResult result = itemservice.getItemParamList(page, rows);
		System.out.println(result.getRows());
		return result;
	}
}
