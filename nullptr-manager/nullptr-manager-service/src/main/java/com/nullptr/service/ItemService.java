package com.nullptr.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nullptr.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(Long itemId);

}
