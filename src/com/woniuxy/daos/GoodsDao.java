package com.woniuxy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.Goods;
import com.woniuxy.entitys.PageBean;
import com.woniuxy.tools.ConnectionManager;



public class GoodsDao {

	String sql = null;

	public List<Goods> getAllGoods() {
		Connection conn = ConnectionManager.getConnection();
		List<Goods> list = new ArrayList<Goods>();

		try {
			sql = "select * from goods";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int goodsId = rs.getInt("goods_id");
				int supplierId = rs.getInt("supplier_id");
				int typeId = rs.getInt("type_id");
				String goodsCode = rs.getString("goods_code");
				String goodsName = rs.getString("goods_name");
				int goodsCount = rs.getInt("goods_count");
				float goodsPrice = rs.getFloat("goods_price");
				String goodsImg = rs.getString("goods_img");
				
				Goods goods = new Goods(goodsId, supplierId, typeId, goodsCode, goodsName, goodsCount, goodsPrice, goodsImg);
				list.add(goods);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	//带名
	
	public List<Goods> getAllGoodsAndName() {
		Connection conn = ConnectionManager.getConnection();
		List<Goods> list = new ArrayList<Goods>();

		try {
			sql = " SELECT goods_id,supplier_name,type_name,goods_code,goods_name,goods_count,goods_price,goods_img FROM goods JOIN types ON types.`type_id`= goods.`type_id` JOIN suppliers ON suppliers.`supplier_id` = goods.`supplier_id` WHERE 1 =1 group by goods_code";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int goodsId = rs.getInt("goods_id");
				String supplierName = rs.getString("supplier_name");
				String typeName = rs.getString("type_name");
				String goodsCode = rs.getString("goods_code");
				String goodsName = rs.getString("goods_name");
				int goodsCount = rs.getInt("goods_count");
				float goodsPrice = rs.getFloat("goods_price");
				String goodsImg = rs.getString("goods_img");
				
				Goods goods = new Goods(goodsId,goodsCode, goodsName, goodsCount, goodsPrice, goodsImg, supplierName, typeName);
				list.add(goods);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	public void addGoods(Goods goods) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		
		try {
			sql = "insert into goods(supplier_id,type_id,goods_code,goods_name,goods_price,goods_img) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, goods.getSupplierId());
			ps.setInt(2, goods.getTypeId());
			ps.setString(3, goods.getGoodsCode());
			ps.setString(4, goods.getGoodsName());
			ps.setFloat(5, goods.getGoodsPrice());
			ps.setString(6, goods.getGoodsImg());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		
	}	
	
	
	
		public void DelGoods(int goodsId) {
			Connection conn = null;
			conn = ConnectionManager.getConnection();
			
			try {
				sql = "delete from goods where goods_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, goodsId);
				
				ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnectionManager.closeConnection(conn);
			}
		}
		
		
		public Goods getGoodsById(int goodId) {
			Connection conn = ConnectionManager.getConnection();
			Goods goods = null;

			try {
				sql = "select * from goods where goods_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setInt(1, goodId);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					int goodsId = rs.getInt("goods_id");
					int supplierId = rs.getInt("supplier_id");
					int typeId = rs.getInt("type_id");
					String goodsCode = rs.getString("goods_code");
					String goodsName = rs.getString("goods_name");
					int goodsCount = rs.getInt("goods_count");
					float goodsPrice = rs.getFloat("goods_price");
					String goodsImg = rs.getString("goods_img");
					
					goods = new Goods(goodsId, supplierId, typeId, goodsCode, goodsName, goodsCount, goodsPrice, goodsImg);
				}
				return goods;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally {
				ConnectionManager.closeConnection(conn);
			}
			
		}
		
		
			
			public void UpdGoods(Goods goods) {
				Connection conn = null;
				conn = ConnectionManager.getConnection();
				
				try {
					sql = "update goods set supplier_id = ?,type_id = ?,goods_code = ?,goods_name = ?,goods_price = ?,goods_img = ?,goods_count = ? where goods_id = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, goods.getSupplierId());
					ps.setInt(2, goods.getTypeId());
					ps.setString(3, goods.getGoodsCode());
					ps.setString(4, goods.getGoodsName());
					ps.setFloat(5, goods.getGoodsPrice());
					ps.setString(6, goods.getGoodsImg());
					ps.setInt(7, goods.getGoodsCount());
					ps.setInt(8, goods.getGoodsId());
					
					ps.executeUpdate();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					ConnectionManager.closeConnection(conn);
				}
			}
	
			
			//查询
			public List<Goods> getGoods(String goodsCodes,String goodsName) throws SQLException {
				Connection conn = null;
				conn = ConnectionManager.getConnection();
				try{
				if (goodsCodes==null) {
					goodsCodes="";
				}
				if (goodsName==null) {
					goodsName="";
				}
				String sql="select * from goods where 1=1 ";
				if(goodsCodes!=null&&!goodsCodes.equals("")){
					sql=sql+" and goods_code like ?";
					
				}
				
				if(goodsName!=null&&!goodsName.equals("")){
					
					sql=sql+" and goods_name like ?";
				}
				PreparedStatement ps=conn.prepareStatement(sql);
				
				int count=0;
				
				if(goodsCodes!=null&&!goodsCodes.equals("")){
					count++;
					ps.setString(count,"%"+goodsCodes+"%" );
					
				}
				
				if(goodsName!=null&&!goodsName.equals("")){
					count++;
					ps.setString(count, "%"+goodsName+"%");
				}
				ResultSet rs = ps.executeQuery();
				List<Goods> outList=new ArrayList<Goods>();
						
				while (rs.next()) {
					int goodsId = rs.getInt("goods_id");
					int supplierId = rs.getInt("supplier_id");
					int typeId = rs.getInt("type_id");
					String goodsCode = rs.getString("goods_code");
					String goodsNames = rs.getString("goods_name");
					int goodsCount = rs.getInt("goods_count");
					float goodsPrice = rs.getFloat("goods_price");
					String goodsImg = rs.getString("goods_img");
					
					Goods goods = new Goods(goodsId, supplierId, typeId, goodsCode, goodsNames, goodsCount, goodsPrice, goodsImg);
					outList.add(goods);
					
				}
				return outList;
			}finally{
				ConnectionManager.closeConnection(conn);
			}
				}
			
			
			//分页时查
			public List<Goods> getAllGoodsByCodeAndName(String goodsCodes,String goodName,PageBean<Goods> pageBean) {
				Connection conn = ConnectionManager.getConnection();
				List<Goods> outlist = new ArrayList<Goods>();

				try {
					sql = "SELECT goods_id,supplier_name,type_name,goods_code,goods_name,goods_count,goods_price,goods_img FROM goods JOIN types ON types.`type_id`= goods.`type_id` JOIN suppliers ON suppliers.`supplier_id` = goods.`supplier_id` WHERE 1 =1";
						if (goodsCodes==null) {
							goodsCodes="";
						}
						if (goodName==null) {
							goodName="";
						}
						if(goodsCodes!=null&&!goodsCodes.equals("")){
							sql=sql+" and goods_code like ?";
							
						}
						
						if(goodName!=null&&!goodName.equals("")){
							
							sql=sql+" and goods_name like ?";
						}
						
						sql=sql+" limit ?,?";
						
						PreparedStatement ps=conn.prepareStatement(sql);
						
						int count=0;
						
						if(goodsCodes!=null && !goodsCodes.equals("")){
							count++;
							ps.setString(count,"%"+goodsCodes+"%" );
							
						}
						
						if(goodName!=null && !goodName.equals("")){
							count++;
							ps.setString(count, "%"+goodName+"%");
						}
						
						ps.setInt(count+1,(pageBean.getCurrentPage()-1)*pageBean.getPageSize());
						ps.setInt(count+2, pageBean.getPageSize());
						
						ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						int goodsId = rs.getInt("goods_id");
						String supplierName = rs.getString("supplier_name");
						String typeName = rs.getString("type_name");
						String goodsCode = rs.getString("goods_code");
						String goodsName = rs.getString("goods_name");
						int goodsCount = rs.getInt("goods_count");
						float goodsPrice = rs.getFloat("goods_price");
						String goodsImg = rs.getString("goods_img");
						
						Goods goods = new Goods(goodsId,goodsCode, goodsName, goodsCount, goodsPrice, goodsImg, supplierName, typeName);
						outlist.add(goods);
					}
					return outlist;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}finally {
					ConnectionManager.closeConnection(conn);
				}
		}		
			
			
			/*查询符号条件的数据一共有多少�?*/
			public int getTotalCount(String goodsCodes,String goodName) throws SQLException {
				Connection conn = null;
				try {
				conn = ConnectionManager.getConnection();
				String sql="select count(goods_id) as 'num' from goods where 1=1 ";
				if(goodsCodes!=null&&!goodsCodes.equals("")){
					sql=sql+" and goods_code like ?";
				}
				
				if(goodName!=null&&!goodName.equals("")){
					sql=sql+" and goods_name like ?";
				}
				PreparedStatement ps=conn.prepareStatement(sql);
				int count=0;
				
				if(goodsCodes!=null&&!goodsCodes.equals("")){
					count++;
					ps.setString(count,"%"+goodsCodes+"%" );
				}
				
				if(goodName!=null&&!goodName.equals("")){
					count++;
					ps.setString(count, "%"+goodName+"%");
				}
				ResultSet rs = ps.executeQuery();
						
				if (rs.next()) {
					
					return rs.getInt("num");
				}
				return 0;
				}finally{
					ConnectionManager.closeConnection(conn);
				}
			}
	
			
			
			public int getAllCount(String goodName) throws SQLException {
				Connection conn = null;
				try {
				conn = ConnectionManager.getConnection();
				String sql="select count(goods_id) as 'num' from goods where 1=1 ";
				
				if(goodName!=null&&!goodName.equals("")){
					sql=sql+" and goods_name like ?";
				}
				PreparedStatement ps=conn.prepareStatement(sql);
				int count=0;
				
				if(goodName!=null&&!goodName.equals("")){
					count++;
					ps.setString(count, "%"+goodName+"%");
				}
				ResultSet rs = ps.executeQuery();
						
				if (rs.next()) {
					
					return rs.getInt("num");
				}
				return 0;
				}finally{
					ConnectionManager.closeConnection(conn);
				}
			}



			public List<Goods> getAllGoodsByHtmlName(String goodsName, PageBean<Goods> pageBean) {
				Connection conn = ConnectionManager.getConnection();
				List<Goods> outlist = new ArrayList<Goods>();

				try {
					sql = "SELECT goods_id,supplier_name,type_name,goods_code,goods_name,goods_count,goods_price,goods_img FROM goods JOIN types ON types.`type_id`= goods.`type_id` JOIN suppliers ON suppliers.`supplier_id` = goods.`supplier_id` WHERE 1 =1";
						if (goodsName==null) {
							goodsName="";
						}
						
						if(goodsName!=null&&!goodsName.equals("")){
							
							sql=sql+" and goods_name like ?";
						}
						
						sql=sql+" limit ?,?";
						
						PreparedStatement ps=conn.prepareStatement(sql);
						
						int count=0;
						
						if(goodsName!=null && !goodsName.equals("")){
							count++;
							ps.setString(count, "%"+goodsName+"%");
						}
						
						ps.setInt(count+1,(pageBean.getCurrentPage()-1)*pageBean.getPageSize());
						ps.setInt(count+2, pageBean.getPageSize());
						
						ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						int goodsId = rs.getInt("goods_id");
						String supplierName = rs.getString("supplier_name");
						String typeName = rs.getString("type_name");
						String goodsCode = rs.getString("goods_code");
						String goodName = rs.getString("goods_name");
						int goodsCount = rs.getInt("goods_count");
						float goodsPrice = rs.getFloat("goods_price");
						String goodsImg = rs.getString("goods_img");
						
						Goods goods = new Goods(goodsId,goodsCode, goodName, goodsCount, goodsPrice, goodsImg, supplierName, typeName);
						outlist.add(goods);
					}
					return outlist;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}finally {
					ConnectionManager.closeConnection(conn);
				}
			}
			
}
