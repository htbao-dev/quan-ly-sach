package dao.sqlServer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.GioHangBean;
import bean.UserBean;
import dao.GioHangDao;

public class SqlServerGioHangDao implements GioHangDao{
	private DungChung dungChung;
	
	public SqlServerGioHangDao() {
		dungChung = new DungChung();// TODO Auto-generated constructor stub
	}
	
	@Override
	public void datMua(ArrayList<GioHangBean> dsSanPham, UserBean userBean, Date ngayMua) throws Exception {
		dungChung.connect();
		String maHoaDon;
		String sqlInsertHoaDon = "INSERT INTO hoadon "
				+ "(makh, NgayMua, damua) "
				+ "OUTPUT inserted.MaHoaDon "
				+ "VALUES "
				+ "(?, ?, ?)";
		PreparedStatement statement = dungChung.cn.prepareStatement(sqlInsertHoaDon);
		statement.setLong(1, userBean.getMaKH());
		statement.setDate(2, ngayMua);
		statement.setBoolean(3, false);
		ResultSet rs = statement.executeQuery();
		rs.next();
		maHoaDon = rs.getString("MaHoaDon");
		rs.close();
		
		String sqlInsertCTHD = "INSERT INTO ChiTietHoaDon "
				+ "		(MaSach, SoLuongMua, MaHoaDon) "
				+ "		VALUES "
				+ "		(?, ?, ?)";
		statement = dungChung.cn.prepareStatement(sqlInsertCTHD);
		for (GioHangBean gioHangBean : dsSanPham) {
			statement.setString(1, gioHangBean.getSachBean().getMaSach());
			statement.setInt(2, gioHangBean.getSoLuong());
			statement.setString(3, maHoaDon);
			statement.execute();
		}
		
		dungChung.disconnect();
		
	}
}
