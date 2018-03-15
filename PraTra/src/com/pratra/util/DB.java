package com.pratra.util;

/**
 * 2016-07-09
 * @author ÂÞÎ°·²
 * Êý¾Ý¿â²Ù×÷
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pratra.entity.WriUser;

public class DB {
	public static void templete(WriUser w) throws SQLException{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
			try{
				conn = DBUtil.getConnection();
				String sql = "insert into tb_write (state,place,no,name,"
						+ "kind,stara,inspa,diar,"
						+ "rent,cono,cost,cofi,phone)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				stat = conn.prepareStatement(sql);
				stat.setString(1,w.getState() );
				stat.setString(2, w.getPlace());
				stat.setString(3, w.getNo());
				stat.setString(4, w.getName());
				stat.setString(5, w.getKind());
				stat.setString(6, w.getStrar());
				stat.setString(7,w.getInspa());
				stat.setString(8, w.getDiar());
				stat.setString(9, w.getRent());
				stat.setString(10, w.getCofi());
				stat.setString(11,w.getCost());
				stat.setString(12, w.getCofi());
				stat.setString(13, w.getPhone());
				stat.executeUpdate();
				System.out.println("db");
//				rs = stat.executeQuery();
//				rs = stat.executeQuery("select * from db_test");
//				while(rs.next()){
//					System.out.println(rs.getObject(1)+"\t"
//				+rs.getObject(2)+"\t"
//				+rs.getObject(3)+"\t"
//				+rs.getObject(4));
//				}
			}finally{
				DBUtil.free(conn, stat, rs);
			}
		
	}

}
