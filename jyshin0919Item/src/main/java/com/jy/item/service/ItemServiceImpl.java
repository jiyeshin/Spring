package com.jy.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.item.dao.ItemDao;
import com.jy.item.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemdao;

	@Override
	//파라미터가 없는 경우는 dao 메소드의 결과를 바로 리턴 
	public List<Item> iservice() {

		return itemdao.listItem();
	}

	@Override
	public Item getItem(int itemid) {		
		return itemdao.getItem(itemid);
	}
}
