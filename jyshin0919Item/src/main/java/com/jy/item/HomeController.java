package com.jy.item;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jy.item.domain.Item;
import com.jy.item.service.ItemService;


@Controller
public class HomeController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Item> list = itemService.iservice();
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping(value="detail", method= RequestMethod.GET)
	//itemid 라는 파라미터를 정수로 itemid에 저장 
	public String getItem(@RequestParam("itemname") String itemname, Model model) {
		Item item = itemService.getItem(itemname);
		model.addAttribute("item", item);
		return "detail";
	}
	
}
