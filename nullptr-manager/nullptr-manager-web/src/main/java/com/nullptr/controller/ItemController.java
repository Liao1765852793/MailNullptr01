package com.nullptr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	private TaotaoResult createItemDesc(TbItem item, String desc, String itemParams) {
		TaotaoResult result = itemservice.createItem(item, desc, itemParams);
		return result;
	}

	@RequestMapping("/item/param/{itemId}")
	@ResponseBody
	private String getItemParamList(@PathVariable Long itemId, Model model) {
		String result = itemservice.getItemParamByItemCid(itemId);
		// model.addAttribute("html", result);
		model.addAttribute("itemparam", result);
		return "item-param";
	}

	// 直接输出html静态文本内容显示到页面上
	@RequestMapping("/item/param/writeHtml/{itemId}")
	@ModelAttribute
	private void getItemParamListToHtml(@PathVariable Long itemId, HttpServletResponse response) throws IOException {
		String result = itemservice.getItemParamByItemCid(itemId);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);

	}

}
