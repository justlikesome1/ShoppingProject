package com.woniuxy.daos;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.entitys.Users;
import com.woniuxy.tools.ConnectionManager;
import com.woniuxy.tools.MD5TOOL;

public class UserDao {

	public boolean isExist(String usersName,String usersPwd) {
		
		int userId;
		String userName = null;
		String userPwd = null;
		String userRole = null;
		String userStatus = null;
		boolean isTrue = false;
		
		
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		Users user = null;
		
		try {
			String sql = "select * from users where user_name = ? and user_pwd = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usersName);
			ps.setString(2, usersPwd);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				userId = rs.getInt("user_id");
				userName = rs.getString("user_name");
				userPwd = rs.getString("user_pwd");
				userRole = rs.getString("user_role");
				userStatus = rs.getString("user_status");
				
				user = new Users(userId, userName, userPwd, userRole, userStatus);
			}
			
			if (usersName.equals(userName) && usersPwd.equals(userPwd)) {
				
				isTrue = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isTrue = false;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		return isTrue;
		
	}
	
	public int getUserId(String userName) {
		
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		Users user = null;
		int userId = 0;
		
		String sql = "select * from users where user_name = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("user_id");
			}
			return userId;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	public boolean isTrue(int userId,String userPwd) {
		
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		boolean b = false;
		
		String sql = "select * from users where user_id = ? and user_pwd = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, userPwd);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = true;
			}
			return b;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return b = false;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	
	
	
	public void updatePwdByeId(int userId,String userPwd) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		String sql = "update users set user_pwd = ? where user_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userPwd);
			ps.setInt(2, userId);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		
	}	
	
	
	
	
	public List<Users> getAllUser() {
		List<Users> list = new ArrayList<Users>();
		Connection conn = ConnectionManager.getConnection();
		String sql =null;
		sql ="select * from users";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userPwd = rs.getString("user_pwd");
				String userRole = rs.getString("user_role");
				String userStatus = rs.getString("user_status");
				Users user = new Users(userId, userName, userPwd, userRole, userStatus);
				list.add(user);
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
	
	
	
		
		public void onUser(int uId) {
			Connection conn = ConnectionManager.getConnection();
			String sql =null;
			sql ="update users set user_status = 'Õ£”√' where user_id = ?";
					
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, uId);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnectionManager.closeConnection(conn);
			}
		}
		
		
		public void offUser(int uId) {
			Connection conn = ConnectionManager.getConnection();
			String sql =null;
			sql ="update users set user_status = '∆Ù”√' where user_id = ?";
					
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, uId);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnectionManager.closeConnection(conn);
			}
		}
		
		
		public void resetPwd(int uId) throws NoSuchAlgorithmException {
			// TODO Auto-generated method stub
			Connection conn = ConnectionManager.getConnection();
			String sql =null;
			sql ="update users set user_pwd=? where user_id = ?";
					
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, MD5TOOL.getMD5String("123456"));
				ps.setInt(2, uId);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnectionManager.closeConnection(conn);
			}
		}

		public void delUser(int uId) {
			// TODO Auto-generated method stub
			Connection conn = ConnectionManager.getConnection();
			String sql =null;
			sql ="delete from users where user_id = ?";
					
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, uId);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnectionManager.closeConnection(conn);
			}
		}
		
		public void addUser(Users user) {
			Connection conn = ConnectionManager.getConnection();
			String sql =null;
			sql = "insert into users(user_name,user_pwd,user_role,user_status) values(?,?,?,'∆Ù”√')";
					
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUserName());
				ps.setString(2, MD5TOOL.getMD5String("123456"));
				ps.setString(3, user.getUserRole());
				
				ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnectionManager.closeConnection(conn);
			}
		}
		
	
	
	
	
}
