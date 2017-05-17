package com.nullptr.service.impl;

import com.nullptr.common.pojo.EasyUITreeNode;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.mapper.TbContentCategoryMapper;
import com.nullptr.pojo.TbContentCategory;
import com.nullptr.pojo.TbContentCategoryExample;
import com.nullptr.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nullptr on 2017/5/17.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    //注入Mapper代理
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCategoryList(Long parentId) {
        //根据Example查询数据
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> tbContentCategoryList = tbContentCategoryMapper.selectByExample(example);

        List<EasyUITreeNode> easyUITreeNodeList = new ArrayList<>();

        //转换成EasyUITreeNode
        for (TbContentCategory tbContentCategory : tbContentCategoryList) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbContentCategory.getId());

            easyUITreeNode.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            //easyUITreeNode.setState("open");
            easyUITreeNode.setText(tbContentCategory.getName());
            //添加到列表
            easyUITreeNodeList.add(easyUITreeNode);
        }
        return easyUITreeNodeList;
    }

    @Override
    public TaotaoResult insertContentCategory(Long parentId, String name) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setName(name);
        tbContentCategory.setStatus(1);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        //插入数据
        tbContentCategoryMapper.insert(tbContentCategory);

        //获取插入数据的主键
        Long id = tbContentCategory.getId();
        //获取父节点
        TbContentCategory tbContentCategoryParent = tbContentCategoryMapper.selectByPrimaryKey(parentId);

        //判断父节点状态是否正常
        if (!tbContentCategoryParent.getIsParent()) {
            tbContentCategoryParent.setIsParent(true);
            //更新父节点状态
            tbContentCategoryMapper.updateByPrimaryKey(tbContentCategoryParent);
        }

        //返回主键
        return TaotaoResult.ok(id);

    }

    @Override
    public TaotaoResult deleteContentCategory(Long id) {
        //查找id对应的ContentCategory
        TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
        //保存需要删除数据对应的父节点ID
        Long parentId = tbContentCategory.getParentId();
        //删除操作
        tbContentCategoryMapper.deleteByPrimaryKey(id);


        //删除后返回的id
        Long nextId = id;

        //保存父节点ID为parentId的数据
        List<TbContentCategory> tbContentCategoryList = new ArrayList<>();

        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria exampleCriteria = example.createCriteria();
        exampleCriteria.andParentIdEqualTo(parentId);
        //查询父节点id为parentId 的节点数据
        tbContentCategoryList = tbContentCategoryMapper.selectByExample(example);

        //如果父节点 无子节点了 那就设置isParent
        if (tbContentCategoryList.size() == 0 || tbContentCategoryList.isEmpty()) {
            //未查找到数据
            TbContentCategory tbParent = tbContentCategoryMapper.selectByPrimaryKey(parentId);
            //设置
            tbParent.setIsParent(false);
            tbContentCategoryMapper.updateByPrimaryKey(tbParent);
            id = parentId;
        } else {
            id = tbContentCategoryList.get(0).getId();
        }


        return TaotaoResult.ok(id);
    }

    @Override
    public TaotaoResult updateContentCategory(Long id, String name) {

        TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id);
        tbContentCategory.setName(name);

        tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);

        return TaotaoResult.ok(tbContentCategory.getId());
    }

}
