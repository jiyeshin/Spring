package com.jy.item.dao;

import java.util.List;

import com.jy.item.domain.Item;

public interface ItemDao {
	//전체 데이터 가져오는 메소드 
	public List<Item> listItem();
	
	//상세보기를 위한 메소드 
	public Item getItem(int itemid);
}
