package com.nullptr.service;

import com.nullptr.common.pojo.EasyUiDataGridResult;
import com.nullptr.common.pojo.TaotaoResult;
import com.nullptr.pojo.TbContent;

/**
 * 更新表tb_content内容
 * Created by Nullptr on 2017/5/17.
 */
public interface ContentService {

    /**
     * 保存内容详细信息
     *
     * @return
     */
    public TaotaoResult saveContent(TbContent tbContent);

    /**
     *
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
    public EasyUiDataGridResult queryListContent(long categoryId, Integer page, Integer rows);
}
