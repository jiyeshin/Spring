import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.RegisterInterface;
import com.pk.mybatis.domain.RegisterVO;

public class InterfaceMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
	
	//매퍼 인터페이스를 구현한 객체 찾아오기
		RegisterInterface registerInterface = context.getBean(RegisterInterface.class);
		/*
		List<RegisterVO> list = registerInterface.listuser();
		for(RegisterVO vo: list) {
			System.out.println(vo);
		}	
		
		RegisterVO vo = registerInterface.selectoneuser("rkm");
		System.out.println(vo);
		*/
		List<RegisterVO> del = registerInterface.deleteuser("bbb");
		
		
	}
}
