package com.nullptr.service;

import com.nullptr.common.pojo.EasyUITreeNode;
import com.nullptr.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by Nullptr on 2017/5/17.
 */
public interface ContentCategoryService {

    /**
     * 根据Id 查询tb_content_category表中的数据
     *
     * @param parentId
     * @return
     */
    public List<EasyUITreeNode> getContentCategoryList(Long parentId);

    /**
     * 往数据库表tb_content_category插入数据
     *
     * @param parentId 父节点的id
     * @param name     当前节点名字
     * @return
     */
    public TaotaoResult insertContentCategory(Long parentId, String name);

    /**
     * 根据传入参数ID 删除tb_content_category表中对应的内容
     * @param id
     * @return
     */
    public TaotaoResult deleteContentCategory(Long id);

    /**
     * 根据传入id以及name，更新表tb_content_category 中对应的数据
     * @param id
     * @param name
     * @return
     */
    public TaotaoResult updateContentCategory(Long id,String name);
}
