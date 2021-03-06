package com.jy.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jy.view.domain.DataReport;
import com.jy.view.domain.DataStructure;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "home";
	}
	
	@RequestMapping(value="data.xml", method=RequestMethod.GET)
	public String data(Model model) {
		DataStructure ds1 = new DataStructure();
		ds1.setName("list");
		ds1.setContent("데이터를 순서대로 저장 ");
		
		DataStructure ds2 = new DataStructure();
		ds2.setName("set");
		ds2.setContent("데이터를 중복없이 해싱을 이용해서 저장 ");
		
		DataStructure ds3 = new DataStructure();
		ds3.setName("map");
		ds3.setContent("키와 값을 쌍으로 저장 ");
		
		List<DataStructure> list = new ArrayList<DataStructure>();
		list.add(ds1);
		list.add(ds2);
		list.add(ds3);
		
		DataReport dr = new DataReport();
		dr.setList(list);
		
		//위의 데이터를 모델에 저장 
		//서버가 클라이언트에게 주는 데이터가 attribute. 여기서는 dataReport 
		model.addAttribute("dataReport", dr);
				
		return "dataxml";
	}
	
	
	
}
