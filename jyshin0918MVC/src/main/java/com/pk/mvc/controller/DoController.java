package com.pk.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller 클래스를 만들고 Bean을 자동생성하는 어노테이션 
@Controller
public class DoController {
	//사용자의 요청을 처리하는 메소드 
	@RequestMapping("hello.do")
	public String greeting(Model model) {
		model.addAttribute("data", "Spring MVC");
		return "views/hello.jsp";
	}
	//URL의 가장 마지막 부분을 분할해서 사용하는 
	@RequestMapping("/archives/{num}")
	public String archives(@PathVariable int num, Model model) {
		model.addAttribute("data", num);
		return "../../views/archives.jsp";
	}
}
