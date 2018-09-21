package com.jy.aop;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jy.aop.domain.Command;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping(value = "interceptor", method = RequestMethod.GET)
	public String interceptor() {

		int sum = 0;
		for (int i = 1; i < 100000000; i = i + 1) {
			sum = sum + i;
		}

		return "";
	}

	@RequestMapping(value = "fileupload", method = RequestMethod.GET)
	public String fileupload(Model model) {
		return "fileupload";
	}

	@RequestMapping(value = "fileupload", method = RequestMethod.POST)
	public String fileupload(Command command, Model model, HttpServletResponse response) {
		System.out.println("이름:" + command.getName());
		if (command.getReport().isEmpty()) {
			PrintWriter out;
			try {
				response.setContentType("text/html; charset=utf-8");
				out = response.getWriter();
				out.println("<script>alert('첨부파일이 없습니다.');</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 업로드 할 디렉토리 이름 설정
			String uploadPath = "/Users/a503-12/Documents/";
			// 파일 경로 만들기
			String filepath = uploadPath + UUID.randomUUID() + command.getReport().getOriginalFilename();
			// 파일 업로드
			try {
				command.getReport().transferTo(new File(filepath));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("파일 업로드 성공");

		}
		// 변화를 주는 작업을 수행하면 반드시 리다이렉트 해야 합니다.
		return "redirect:./";
	}
}
