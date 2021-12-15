package dao.sqlServer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ChiTietHoaDonBean;
import bean.HoaDonBean;
import bean.SachBean;
import dao.HoaDonDao;

public class SqlServerHoaDonDao implements HoaDonDao{
	DungChung dungChung;
	
	public SqlServerHoaDonDao() {
		dungChung = new DungChung();
	}
	
	@Override
	public ArrayList<HoaDonBean> getHoaDon(long maKhachHang) throws Exception {
		ArrayList<HoaDonBean> listHoaDon = new ArrayList<HoaDonBean>();
		String sqlHoaDon = "SELECT * FROM hoadon "
				+ "WHERE makh = ?";
		dungChung.connect();
		PreparedStatement statement = dungChung.cn.prepareStatement(sqlHoaDon);
		statement.setLong(1, maKhachHang);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			long maHoaDon = rs.getLong("MaHoaDon");
			Date ngayMua = rs.getDate("NgayMua");
			boolean daMua = rs.getBoolean("damua");
			listHoaDon.add(new HoaDonBean(maHoaDon, maKhachHang, ngayMua, daMua, null));
		}
		
		String sqlCTHD = "SELECT CTHD.MaChiTietHD, CTHD.SoLuongMua, CTHD.damua, S.* FROM ChiTietHoaDon as CTHD "
				+ "	JOIN sach as S ON CTHD.MaSach = S.masach "
				+ "	WHERE CTHD.MaHoaDon = ?";
		statement = dungChung.cn.prepareStatement(sqlCTHD);
		for (HoaDonBean hoaDonBean : listHoaDon) {
			statement.setLong(1, hoaDonBean.getMaHoaDon());
			rs = statement.executeQuery();
			ArrayList<ChiTietHoaDonBean> chiTiet = new ArrayList<ChiTietHoaDonBean>();
			while (rs.next()) {
				long maChiTietHoaDon = rs.getLong("MaChiTietHD");
				int soLuongMua = rs.getInt("SoLuongMua");
				boolean daMua = rs.getBoolean("damua");
				String maSach= rs.getString("masach");
			    String tenSach = rs.getString("tensach");
			    String tacGia = rs.getString("tacgia");
			    long gia = rs.getLong("gia");
			    String anh =rs.getString("anh");
			    String maLoai = rs.getString("maloai");
			    
			    ChiTietHoaDonBean tam = new ChiTietHoaDonBean(maChiTietHoaDon, 
						new SachBean(maSach, tenSach, tacGia, gia, anh, maLoai),
						soLuongMua, daMua);
			    chiTiet.add(tam);
			}
			hoaDonBean.setChiTiet(chiTiet);
		}
		rs.close();
		dungChung.disconnect();
		return listHoaDon;
	}
}
