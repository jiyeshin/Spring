package com.jy.item.service;

import java.util.List;

import com.jy.item.domain.Item;

public interface ItemService {
	//전체 데이를 가져오는 메소
	//파라미터가 없으면 dao메소드와 동일한 구조임. 
	public List<Item> iservice();
	
	//itemid로 하나의 데이터를 찾아오는 메소드 
	public Item getItem(String itemname);
}
