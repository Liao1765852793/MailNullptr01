package com.nullptr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nullptr.common.pojo.EasyUITreeNode;
import com.nullptr.service.ItemCatService;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/item/cat/list ")
	@ResponseBody
	public List<EasyUITreeNode> geEasyUITreeNodes(@RequestParam(value = "id", defaultValue = "0") long parentId) {
		System.out.println("parentId = " + parentId);
		List<EasyUITreeNode> list = itemCatService.geTreeNode(parentId);
		return list;
	}

}
