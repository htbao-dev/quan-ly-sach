package dao.sqlServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.SachBean;
import dao.SachDao;

public class SqlServerSachDao implements SachDao{
	private DungChung dungChung;
	public SqlServerSachDao() {
		dungChung = new DungChung();
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<SachBean> getSach(String search) throws Exception {
		search = "%" + search + "%";
		ArrayList<SachBean> listSach = new ArrayList<SachBean>();
		String query = "SELECT * FROM sach WHERE (tensach LIKE ? or tacgia LIKE ?) AND DangBan = 1";
		dungChung.connect();
		PreparedStatement statement = dungChung.cn.prepareStatement(query);
		statement.setString(1, search);
		statement.setString(2, search);
		ResultSet rs = statement.executeQuery();
		while(rs.next()){
			String maSach;
		    String tenSach;
		    String tacGia;
		    long gia;
		    String anh;
		    String maLoai;
		    
		    maSach = rs.getString("masach");
		    tenSach = rs.getString("tensach");
		    tacGia = rs.getString("tacgia");
		    gia = rs.getLong("gia");
		    anh =rs.getString("anh");
		    maLoai = rs.getString("maloai");
		    
		    listSach.add(new SachBean(maSach, tenSach, tacGia, gia, anh, maLoai));
		}
		rs.close();
		dungChung.disconnect();
		return listSach;
	}
	
	@Override
	public void deleteSach(String maSach) {
		System.out.print("SqlServerSachDao xoa sach: " + maSach);
		
	}
}
