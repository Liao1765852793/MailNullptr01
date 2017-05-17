package com.nullptr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.mapper.TbContentMapper;
import com.nullptr.pojo.TbContent;
import com.nullptr.pojo.TbContentExample;
import com.nullptr.pojo.TbItem;
import com.nullptr.pojo.TbItemExample;
import com.nullptr.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Nullptr on 2017/5/17.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    /**
     * 保存内容详细信息
     *
     * @return
     */
    @Override
    public TaotaoResult saveContent(TbContent tbContent) {

        tbContent.setCreated(new Date());
        tbContent.setUpdated(new Date());
        tbContentMapper.insert(tbContent);

        return TaotaoResult.ok(tbContent.getId());
    }

    /**
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUiDataGridResult queryListContent(long categoryId, Integer page, Integer rows) {

        // 分页处理
        PageHelper.startPage(page, rows);
        TbContentExample example = new TbContentExample();

        System.out.println("categoryId = " + categoryId);
        if (categoryId != 0) {
            //如果传入值了，按照传入的值查询，如果没有，直接查询所有
            TbContentExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryIdEqualTo(categoryId);
            //criteria.andCategoryIdGreaterThan()

        }
        List<TbContent> tbContentList = tbContentMapper.selectByExample(example);
        PageInfo<TbContent> pgInfo = new PageInfo<TbContent>(tbContentList);
        EasyUiDataGridResult result = new EasyUiDataGridResult();
        result.setTotal(pgInfo.getTotal());
        result.setRows(tbContentList);


        return result;
    }
}
