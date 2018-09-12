import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import dao.GoodsDao;
import vo.GoodsVO;

public class Main {
	public static void main(String[] args) {
		// GoodsDao 인스턴스 생성
		//GoodsDao dao = new GoodsDao();
		//GoodsDao dao = GoodsDaoFactory.create();		
		//스프링을 이용해서 객체를 생성 : 싱글톤 패턴이 자동으로 적용 		
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GoodsDaoFactory.class);
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//GoodsDao dao = context.getBean("create", GoodsDao.class);
		GoodsDao dao = context.getBean("goodsDao", GoodsDao.class);
		System.out.println(dao.hashCode());
		
		// 필요한 메소드 호출
		List<GoodsVO> list = dao.getGoods();

		// 메소드 호출 결과 출력
		for (GoodsVO vo : list) {
			System.out.println(vo);
		}
		
		//dao = context.getBean("create", GoodsDao.class);
		dao = context.getBean("goodsDao", GoodsDao.class);
		System.out.println(dao.hashCode());
	}
}


 