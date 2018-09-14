import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.GoodsDao;
import com.mybatis.domain.Goods;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		GoodsDao dao = context.getBean(GoodsDao.class);
		System.out.println(dao);
		
	
		
		Goods g = new Goods();
		g.setCode(2003);
		g.setName("머들러");
		g.setPrice(8000);
		g.setDescription("유");
		dao.insertGoods(g);
		
		List<Goods> list = dao.list();
		for(Goods good: list) {
			System.out.println(good);
		}
		
		context.close();
	}

}
