import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.RegisterDAO;
import com.pk.mybatis.domain.RegisterVO;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		RegisterDAO dao = context.getBean(RegisterDAO.class);
		/*
		List<RegisterVO> list = dao.userlist();
		for(RegisterVO vo : list) {
			System.out.println(vo);
		}
		*/
		
		//id로 데이터를 조회하는 메소드 호출 
		/*
		RegisterVO vo= dao.selectuser("rkm");
		System.out.println(vo);
		vo = dao.selectuser("aaa");
		System.out.println(vo); //없는 데이터이기 때문에 null이 나옴 
		*/		
		
		//insert 하는 메소드 호출 
		Scanner sc = new Scanner(System.in);
		String id="";
		//primary key를 입력받는 경우에는 반드시 중!복!체!크!를 해야 함!!
		while(true) {
			System.out.print("사용할 id를 입력하시오: ");
			id=sc.nextLine();
			RegisterVO vo = dao.selectuser(id);
			if(vo == null) {
				break;
			}
			System.out.println(id + "는 사용 불가능한 id입니다.");
		}
		System.out.print("비밀번호 입력: ");
		String pw = sc.nextLine();
		
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		
		System.out.print("전화번호 입력: ");
		String phone = sc.nextLine();
		
		RegisterVO newVO = new RegisterVO();
		newVO.setId(id);
		newVO.setPw(pw);
		newVO.setName(name);
		newVO.setPhone(phone);
		//select 이외의 구문은 영향받은 행의 개수를 리턴.
		int result = dao.insertprocedure(newVO);
		System.out.println(result);
		
		
		context.close();
	}

}
