package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.GoodsVO;

public class GoodsDao {
	public GoodsDao(){}
	
	
	
	
	// 전체 데이터를 읽어오는 메소드
	public List<GoodsVO> getGoods() {
		// 리스트를 리턴타입이나 변수로 할 때는 ArrayList 등의 실제 리스트 이름으로 하지 말기. 나중에 하다보면 바뀔 수도 있기 때문.
		// (파라미터)를 만들 때 insert나 update는 vo, delete는 primary key, select는 where절에 대입되어야
		// 하는 데이터.
		// 이번에는 select * from goods 를 수행하는 메소드이고 where절이 없음 => 파라미터는 비워둠 ()

		List<GoodsVO> list = new ArrayList<GoodsVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user12", "user12");
			pstmt = con.prepareStatement("select * from goods");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setDescription(rs.getString("description"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
}
