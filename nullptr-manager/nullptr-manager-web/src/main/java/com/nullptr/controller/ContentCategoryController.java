package com.nullptr.controller;

import com.nullptr.common.pojo.EasyUITreeNode;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Nullptr on 2017/5/17.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") Long paraent) {

        List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(paraent);
        return list;
    }

    //新加内容节点
    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId, String name) {
        System.out.println("create");
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }

    //删除内容节点
    @RequestMapping("/delete")
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long id) {
        System.out.println("delete");
        TaotaoResult result = contentCategoryService.deleteContentCategory(id);
        return result;
    }

    //更新节点内容
    @RequestMapping("/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(Long id, String name) {
        System.out.println("update");
        TaotaoResult result = contentCategoryService.updateContentCategory(id, name);
        return result;
    }
}
