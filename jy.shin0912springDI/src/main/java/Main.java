import org.springframework.context.support.GenericXmlApplicationContext;

import vo.PersonVo;

public class Main {
	public static void main(String[] args) {
		// spring 설정 파일의 내용 가져오기: xml파일은 GenericXmlApllicationContext 로 가져옴. 
		//사실 객체가 만들어지는건 이때임. getBean 할 때가 아니라. 
		//스프링이 미리 생성자를 다 만들어준다는 의미임. 안그러면 내가 순서 알아서 직접 생성자 만들어야 하는 수고가 생김. 땡큐 
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("1");
		
		//person이라는 id를 가진 객체 가져오기 : new 없이도 객체 생성이 가능하다. <-applicationContext.xml에서 만들어 놨기 때문 
		PersonVo personVo = context.getBean("person", PersonVo.class); //applicationContext.xml에서 만들어 둔 것 아이디로 가져오기 
		System.out.println("2");
		System.out.println(personVo);
		System.out.println("3");
		
		context.close();
	}
}
