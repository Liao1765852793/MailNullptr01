package com.nullptr.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nullptr.common.pojo.EasyUITreeNode;
import com.nullptr.mapper.TbItemCatMapper;
import com.nullptr.pojo.TbItemCat;
import com.nullptr.pojo.TbItemCatExample;
import com.nullptr.pojo.TbItemCatExample.Criteria;
import com.nullptr.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITreeNode> geTreeNode(long id) {
		// TODO Auto-generated method stub
		System.out.println("geTreeNode id = " + id);
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();

		// addCriterion("parent_id =", value, "parentId");
		// 传入ID后，查询条件为 parent_id = id
		criteria.andParentIdEqualTo(id);

		List<TbItemCat> list = itemCatMapper.selectByExample(example);

		List<EasyUITreeNode> treeNodeList = new ArrayList<>();

		for (TbItemCat tbItemCat : list) {
			// for循环 新建EasyUiTreeNode
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			//这里的closed 跟open作为节点状态，是根据EasyUi里面的Tree节点的属性来决定的
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			node.setText(tbItemCat.getName());

			treeNodeList.add(node);
		}

		System.out.println("获取到的list节点数：" + treeNodeList.size());
		return treeNodeList;
	}

}
