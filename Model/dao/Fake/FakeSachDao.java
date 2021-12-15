package dao.Fake;

import java.util.ArrayList;

import bean.SachBean;
import dao.SachDao;

public class FakeSachDao implements SachDao{
	ArrayList<SachBean> ds;// = new ArrayList<SachBean>();
	
	public FakeSachDao() {
		ds = new ArrayList<SachBean>();
		ds.add(new SachBean("s1", "Cấu trúc dữ liệu", "Đỗ Ngọc", (long)120000,"b11.jpg", "cntt"));
	   ds.add(new SachBean("s2", "Cơ sở dữ liệu", "Đỗ Ngọc", (long)12000,"b12.jpg", "cntt"));
	   ds.add(new SachBean("s3", "lập trình Java", "Quách Tuấn Ngọc", (long)1000,"b14.jpg", "cntt"));
	   ds.add(new SachBean("s11", "Cấu trúc dữ liệu1", "Đỗ Ngọc", (long)120000, "b21.jpg", "cntt"));
	   ds.add(new SachBean("s22", "Cơ sở dữ liệu2", "Đỗ Ngọc", (long)120000, "b22.jpg", "cntt"));
	   ds.add(new SachBean("s33", "lập trình Java3", "Quách Tuấn Ngọc", (long)120000,"b24.jpg", "cntt"));
	   ds.add(new SachBean("s4", "Địa chất công trình", "Đỗ Ngọc", (long)120000, "b20.jpg", "dia"));
	   ds.add(new SachBean("s5", "Bản đồ", "Đỗ Ngọc", (long)120000, "b11.jpg", "dia"));
	}
	@Override
	public ArrayList<SachBean> getSach(String search) {
		ArrayList<SachBean> res = new ArrayList<SachBean>();
		for (SachBean sachBean : ds) {
			if (sachBean.getTenSach().contains(search) || sachBean.getTacGia().contains(search)) {
				res.add(sachBean);
			}
		}
		return res;
	}
	
	@Override
	public void deleteSach(String maSach) {
		System.out.print("SachFakeDao xoa sach: " + maSach);
	}
}
