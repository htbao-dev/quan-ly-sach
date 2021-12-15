package dao.sqlServer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.LoaiBean;
import dao.LoaiDao;

public class SqlServerLoaiDao implements LoaiDao{
	private DungChung dungChung;
	
	public SqlServerLoaiDao() {
		dungChung = new DungChung();
	}
	@Override
	public ArrayList<LoaiBean> getLoai(String search) throws Exception {
		search = "%" + search + "%";
		ArrayList<LoaiBean> listLoai = new ArrayList<LoaiBean>();
		String query = "SELECT * FROM loai WHERE tenloai LIKE ?";
		dungChung.connect();
		PreparedStatement statement = dungChung.cn.prepareStatement(query);
		statement.setString(1, search);
		
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String maLoai, tenLoai;
			maLoai = rs.getString("maloai");
			tenLoai = rs.getString("tenloai");
			listLoai.add(new LoaiBean(maLoai, tenLoai));
		}
		rs.close();
		dungChung.disconnect();
		return listLoai;
	}
	
	@Override
	public void deleteLoai(String maLoai) {
		System.out.print("SqlServerLoaiDao xoa loai: " + maLoai);
		
	}
}
