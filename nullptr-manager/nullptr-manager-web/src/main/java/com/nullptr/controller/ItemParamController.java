package com.nullptr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.service.ItemParamService;

@Controller
public class ItemParamController {
	@Autowired
	private ItemParamService ItemParamService;

	@RequestMapping("/item/param/list")
	@ResponseBody
	private EasyUiDataGridResult getItemParamList(Integer page, Integer rows) {
		EasyUiDataGridResult result = ItemParamService.getItemParamList(page, rows);

		return result;
	}
}
