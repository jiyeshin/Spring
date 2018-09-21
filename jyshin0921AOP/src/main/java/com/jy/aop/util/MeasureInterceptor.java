package com.jy.aop.util;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//bean을 자동생성 해주는 어노테이션. 
//bean의 id는 클래스 이름 중에서 첫 글자만 소문자로 변경. 여기서는 measureInterceptor  
@Component
public class MeasureInterceptor implements HandlerInterceptor {

	long start;

	// controller가 요청을 처리하기 전에 호출되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		start = System.currentTimeMillis();

		//어디에서(ip) 언제(시간)에서 서비스를 사용했는지 파일에 기록 
		
		//오늘 날짜 만들기 
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		try(FileOutputStream fos = new FileOutputStream("/Users/a503-12/Documents/"+date.toString()+".txt", true);
				PrintWriter pw = new PrintWriter(fos);){
			String ip = request.getRemoteAddr();
			String msg = String.format("%04d%02d%02d%02d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, 
					cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR),
					cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
			pw.println(ip+"-"+ msg);
		}
		
		// false를 리턴하면 controller로 이동하지 않음
		return true;
	}

	// controller가 예외가 발생하지 않은 상태로 작업을 종료하고, 뷰를 출력하기 직전에 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	// 예외발생 여부와 상관없이 controlelr가 작업을 종료하면 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}
