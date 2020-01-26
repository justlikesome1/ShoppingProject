package com.woniuxy.daos;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.Customer;
import com.woniuxy.tools.ConnectionManager;
import com.woniuxy.tools.MD5TOOL;



public class CustomerDao {
	
	String sql = null;
	
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = ConnectionManager.getConnection();
		sql = "select * from customer";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int customerId = rs.getInt("cus_id");
				String customerName = rs.getString("cus_name");
				String customerPwd = rs.getString("cus_pwd");
				String customerPhone = rs.getString("cus_phone");
				String customerAdd = rs.getString("cus_add");
				String customerStatus = rs.getString("cus_status");
				Customer cus = new Customer(customerId, customerName, customerPwd, customerPhone, customerAdd, customerStatus);
				list.add(cus);
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
	
	
	
	public void addCustomer(Customer cus) {
		Connection conn = ConnectionManager.getConnection();
		
		sql = "insert into customer(cus_name,cus_pwd,cus_phone,cus_add,cus_status) values(?,?,?,?,'启用')";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cus.getCusName());
			ps.setString(2, cus.getCusPwd());
			ps.setString(3, cus.getCusPhone());
			ps.setString(4, cus.getCusAdd());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	public void onCustomer(int cusId) {
		Connection conn = ConnectionManager.getConnection();
		
		sql ="update customer set cus_status = '停用' where cus_id = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	public void offCustomer(int cusId) {
		Connection conn = ConnectionManager.getConnection();
		
		sql ="update customer set cus_status = '启用' where cus_id = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}



	public void delCustomer(int cusId) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		
		sql ="delete from customer where cus_id = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	public List<Customer> getCusById(int cusId) {
		Connection conn = ConnectionManager.getConnection();
		List<Customer> list = new ArrayList<Customer>();
		sql ="select * from customer where cus_id = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cusId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String customerName = rs.getString("cus_name");
				String customerPwd = rs.getString("cus_pwd");
				String customerPhone = rs.getString("cus_phone");
				String customerAdd = rs.getString("cus_add");
				String customerStatus = rs.getString("cus_status");
				Customer cus = new Customer(cusId, customerName, customerPwd, customerPhone, customerAdd, customerStatus);
				list.add(cus);
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
	
	
	
	
	public void updCustomer(Customer cus) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		
		sql ="update customer set cus_name=?,cus_phone=?,cus_add=? where cus_id = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cus.getCusName());
			ps.setString(2, cus.getCusPhone());
			ps.setString(3, cus.getCusAdd());
			ps.setInt(4, cus.getCusId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	public void resetPwd(int cusId) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		
		sql ="update customer set cus_pwd=? where cus_id = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, MD5TOOL.getMD5String("123"));
			ps.setInt(2, cusId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}



	public int getCusIdByName(String cusName, String cusPwd) {
		Connection conn = ConnectionManager.getConnection();
		
		sql ="select cus_id from customer where cus_name = ? and cus_pwd = ? and cus_status = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cusName);
			ps.setString(2, cusPwd);
			ps.setString(3, "启用");
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int cusId = rs.getInt("cus_id");
				return cusId;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	
	public Customer getCusByName(String cusName) {
		Connection conn = ConnectionManager.getConnection();
//		List<Customer> list = new ArrayList<Customer>();
		Customer cus = null;
		
		sql ="select * from customer where cus_name = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cusName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int cusId = rs.getInt("cus_id");
				String customerName = rs.getString("cus_name");
				String customerPwd = rs.getString("cus_pwd");
				String customerPhone = rs.getString("cus_phone");
				String customerAdd = rs.getString("cus_add");
				String customerStatus = rs.getString("cus_status");
				cus = new Customer(cusId, customerName, customerPwd, customerPhone, customerAdd, customerStatus);
				
			}
			return cus;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	
	public boolean updBySelf(Customer cus) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		boolean isOk = false;
		
		sql ="update customer set cus_name=?,cus_pwd=?,cus_phone=?,cus_add=? where cus_id = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cus.getCusName());
			ps.setString(2, cus.getCusPwd());
			ps.setString(3, cus.getCusPhone());
			ps.setString(4, cus.getCusAdd());
			ps.setInt(5, cus.getCusId());
			
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
