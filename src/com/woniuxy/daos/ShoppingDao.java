package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.woniuxy.entitys.Goods;
import com.woniuxy.entitys.Shoppings;
import com.woniuxy.tools.ConnectionManager;

public class ShoppingDao {
	
	String sql = null;
	
	
	public boolean isExistShopping(Shoppings shoppings) {
		Connection conn = ConnectionManager.getConnection();
		boolean isExist = false;
		
		sql = "select * from shoppings where goods_id =? and cus_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shoppings.getGoodsId());
			ps.setInt(2, shoppings.getCusId());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				isExist = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isExist = false;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		
		return isExist;
		
	}
	
	
	public void addShopping(Shoppings shoppings) {
		Connection conn = ConnectionManager.getConnection();
		
		boolean isExist = isExistShopping(shoppings);
		
		
		if (isExist) {
			sql = "update shoppings set shopping_count = shopping_count+1 where goods_id = ? and cus_id = ?";
		
		}else {
			sql = "insert into shoppings(goods_id,cus_id,shopping_count,shopping_time) values(?,?,1,now())";
			
		}
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shoppings.getGoodsId());
			ps.setInt(2, shoppings.getCusId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	
	}
	
	
	
	
	public List<Shoppings> getGoodsByCusId(int cusId) {
		Connection conn = ConnectionManager.getConnection();
		List<Shoppings> shList=new ArrayList<Shoppings>();
		
		sql = "select shopping_id,shoppings.goods_id,shopping_count,shopping_time,cus_id,goods_name,goods_price,goods_img,goods_count from shoppings LEFT JOIN goods on shoppings.goods_id=goods.goods_id where shoppings.cus_id=?";
	        
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int shopping_id=rs.getInt("shopping_id");
				int goods_id=rs.getInt("goods_id");
				int shopping_count=rs.getInt("shopping_count");
				Date shopping_time=rs.getDate("shopping_time");
				int cus_id=rs.getInt("cus_id");
				String goods_name=rs.getString("goods_name");
				float goods_price=rs.getFloat("goods_price");
				int goods_count=rs.getInt("goods_count");
				String goods_img=rs.getString("goods_img");
				//封装goods对象
				Goods goods = new Goods(goods_name, goods_count, goods_price, goods_img);
				
				Shoppings shopping=new Shoppings(shopping_id, goods_id, cus_id, shopping_count, shopping_time, goods);
				shList.add(shopping);
			}
			
			return shList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	
	
	public boolean updateShoppingCount(int shoppingId, int shoppingCount ) {
		boolean isTrue = false;
		Connection conn = ConnectionManager.getConnection();
		sql = "update shoppings set shopping_count = ? where shopping_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, shoppingCount);
			ps.setInt(2, shoppingId);
			ps.executeUpdate();
			
			return isTrue = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return isTrue;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		
		
	}


	public List<Shoppings> getSubShoppings(String sids) {
		Connection conn = ConnectionManager.getConnection();
		List<Shoppings> shList=new ArrayList<Shoppings>();
		
		String str = sids;
		
		sql = "select shopping_id,shoppings.goods_id,shopping_count,shopping_time,cus_id,goods_name,goods_price,goods_img,goods_count from shoppings LEFT JOIN goods on shoppings.goods_id=goods.goods_id where shoppings.shopping_id in ( "+str+" )";
	        
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int shopping_id=rs.getInt("shopping_id");
				int goods_id=rs.getInt("goods_id");
				int shopping_count=rs.getInt("shopping_count");
				Date shopping_time=rs.getDate("shopping_time");
				int cus_id=rs.getInt("cus_id");
				String goods_name=rs.getString("goods_name");
				float goods_price=rs.getFloat("goods_price");
				int goods_count=rs.getInt("goods_count");
				String goods_img=rs.getString("goods_img");
				//封装goods对象
				Goods goods = new Goods(goods_name, goods_count, goods_price, goods_img);
				
				Shoppings shopping=new Shoppings(shopping_id, goods_id, cus_id, shopping_count, shopping_time, goods);
				shList.add(shopping);

			}
			
			return shList;
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		
		
		
	}


	public int getShoppingCount(int cusId) {
		Connection conn = ConnectionManager.getConnection();
		String sql = "";
		
		try {
			sql = "select count(shopping_id) as 'num' from shoppings where cus_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("num");
			}
			
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	public boolean clearShopping(int cusId) {
	
		Connection conn = ConnectionManager.getConnection();
		boolean isOk = false;
		String sql = "";
		
		try {
			sql = "delete from shoppings where cus_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			
			ps.executeUpdate();
			isOk = true;
			
			return isOk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return isOk;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		
		
	}
	
}
