package dao.sqlServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import bean.UserBean;
import common.SignupStatus;
import dao.UserDao;

public class SqlServerUserDao implements UserDao{
	private DungChung dungChung;
	public SqlServerUserDao() {
		dungChung = new DungChung();
	}
	@Override
	public UserBean login(String username, String password) throws Exception {
		UserBean userBean;
		String query = "SELECT * FROM KhachHang WHERE tendn = ? AND pass = ?";
		dungChung.connect();
		PreparedStatement statement = dungChung.cn.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			String hoTen, diaChi, email, soDT;
			long maKH;
			hoTen = rs.getString("hoten");
			diaChi = rs.getString("diachi");
			soDT = rs.getString("sodt");
			email = rs.getString("email");
			maKH = rs.getLong("makh");
			userBean = new UserBean(username, maKH, hoTen, diaChi, soDT, email);
		}
		else {
			userBean = null;
		}
		rs.close();
		dungChung.disconnect();
		return userBean;
	}
	
	@Override
	public UserBean lookupUser(String username) throws Exception {
		UserBean userBean = null;
		String sqlCheckUsername = "SELECT * FROM KhachHang WHERE tendn = ?";
		dungChung.connect();
		PreparedStatement statement = dungChung.cn.prepareStatement(sqlCheckUsername);
		statement.setString(1, username);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			String hoTen, diaChi, email, soDT;
			long maKH;
			hoTen = rs.getString("hoten");
			diaChi = rs.getString("diachi");
			soDT = rs.getString("sodt");
			email = rs.getString("email");
			maKH = rs.getLong("makh");
			userBean = new UserBean(username, maKH, hoTen, diaChi, soDT, email);
		}
		rs.close();
		dungChung.disconnect();
		System.out.println(userBean);
		return userBean;
	}
	
	@Override
	public boolean signup(UserBean userBean) throws Exception {
		boolean status = false;
		dungChung.connect();
		String sql = "INSERT INTO KhachHang "
				+ "(hoten, tendn, pass, email, sodt, diachi)"
				+ "OUTPUT inserted.makh "
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = dungChung.cn.prepareStatement(sql);
		
		statement.setString(1, userBean.getHoTen());
		statement.setString(2, userBean.getUsername());
		statement.setString(3, userBean.getPassword());
		statement.setString(4, userBean.getEmail());
		statement.setString(5, userBean.getSoDT());
		statement.setString(6, userBean.getDiaChi());
		
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			status = true;
		}
		else {
			status = false;
		}
			
		rs.close();
		dungChung.disconnect();
		return status;
	}
}
