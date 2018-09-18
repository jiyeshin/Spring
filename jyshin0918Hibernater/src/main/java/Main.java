import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.dao.GoodsDao;
import com.pk.domain.Goods;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml"); 
		
		GoodsDao dao = context.getBean(GoodsDao.class);
		/*
		Goods goods = new Goods();
		goods.setCode(9);
		goods.setName("배");
		goods.setManufacture("나주");
		goods.setPrice(25000);
		dao.deleteGoods(goods);
		*/
		
		List<Goods> list = dao.list();
		for(Goods goods : list) {
			System.out.println(goods);
		}
		
		System.out.println("=======================");
		System.out.println(dao.get(1));
		System.out.println(dao.get(11));
		
		
		context.close();
	}

}
