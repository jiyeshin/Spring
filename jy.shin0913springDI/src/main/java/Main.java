import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import vo.CollectionBean;
import vo.Sample;



public class Main {
	public static void main(String[] args) {
		//스프링 컨테이너 실행하기: 컨테이너 안에 있는 bean의 객체가 전부 생성됨. 
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//classpath: 는 시작점 
		
		//생성된 객체 가져오기 
		//아이디만 대입한 경우는 Object로 리턴되므로 강제 형 변환해서 사용. 
		//동일한 클래스로 만들어진 bean이 1개이면 아이디를 생략하고 클래스이름만 대입해도 됨. 
		Sample sample = context.getBean("sample", Sample.class);
		System.out.println(sample);
		
		
		//CollectionBean 객체 가져오기 
		CollectionBean collectionBean = context.getBean(CollectionBean.class);
		for(String temp: collectionBean.getList()) {
			System.out.println(temp);			
		}
		System.out.println();
		for(String temp: collectionBean.getSet()) {
			System.out.println(temp);			
		}
		System.out.println();
		
		// Map방식 출력하는 방법 
		Set<String>keySet = collectionBean.getMap().keySet();		
		for(String temp: keySet) {
			System.out.println(temp + ":" + collectionBean.getMap().get(temp));
		}
		context.close();
	}
}
