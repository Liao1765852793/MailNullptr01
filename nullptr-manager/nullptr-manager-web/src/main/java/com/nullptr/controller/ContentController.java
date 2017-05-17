package com.nullptr.controller;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.pojo.TbContent;
import com.nullptr.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Nullptr on 2017/5/17.
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult saveContent(TbContent tbContent) {
        TaotaoResult result = contentService.saveContent(tbContent);
        return result;
    }

    /**
     *
     * @param categoryId categoryId查询的ID，如果没值，查询所有
     * @param page  查询的页数
     * @param rows  每一页的行数
     * @return
     */
    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUiDataGridResult queryListContent(@RequestParam(value = "categoryId", defaultValue = "0") long categoryId, Integer page, Integer rows) {
        EasyUiDataGridResult result = contentService.queryListContent(categoryId, page, rows);

        return result;
    }
}
