package dao.Fake;

import java.util.ArrayList;

import bean.LoaiBean;
import dao.LoaiDao;

public class FakeLoaiDao implements LoaiDao{
	ArrayList<LoaiBean> ds;
	public FakeLoaiDao() {
		ds = new ArrayList<LoaiBean>();
		ds.add(new LoaiBean("cntt", "Công nghệ thông tin"));
		ds.add(new LoaiBean("yte", "Y tế"));
		ds.add(new LoaiBean("sinh", "Sinh học"));
		ds.add(new LoaiBean("vatly", "Vật lý"));
		ds.add(new LoaiBean("dia", "Địa lý"));
		ds.add(new LoaiBean("sinh", "Sinh họcc"));
		ds.add(new LoaiBean("hoa", "Hoá học"));
		ds.add(new LoaiBean("van", "Văn học"));
		ds.add(new LoaiBean("su", "Sử"));
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<LoaiBean> getLoai(String search) {
		ArrayList<LoaiBean> list = new ArrayList<LoaiBean>();
		for (LoaiBean loaiBean : ds) {
			if (loaiBean.getTenLoai().contains(search)) {
				list.add(loaiBean);	
			}
		}
		return list;
	}
	
	@Override
	public void deleteLoai(String maLoai) {
		System.out.print("LoaiFakeDao Xoa Loai: " + maLoai);
		
	}
}
