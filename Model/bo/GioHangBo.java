package bo;

import java.sql.Date;
import java.util.ArrayList;

import bean.GioHangBean;
import bean.UserBean;
import dao.GioHangDao;


public class GioHangBo {
	private ArrayList<GioHangBean> dsSanPham;
	private GioHangDao gioHangDao;
	public GioHangBo() {
		dsSanPham = new ArrayList<GioHangBean>();
		gioHangDao = BaseBo.dao.getGioHangDao();
	}
	
	public ArrayList<GioHangBean> getDsSanPham(){
		return new ArrayList<GioHangBean>(dsSanPham);
	}
	
	public void xoaDsSanPham() {
		dsSanPham.clear();
	}
	
	public boolean them(GioHangBean newItem) {
		String maSach = newItem.getSachBean().getMaSach();
		for(GioHangBean item : dsSanPham) {
			if (item.getSachBean().getMaSach().equals(maSach)) {
				int sl = item.getSoLuong();
				item.setSoLuong(sl++);
				return true;
			}
		}
		return dsSanPham.add(newItem);
	}
	
	public boolean xoa(String maSach) {
		for(GioHangBean item : dsSanPham) {
			if (item.getSachBean().getMaSach().equals(maSach)) {
				dsSanPham.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public void capNhatSoLuong(int index, int soLuong) {
		dsSanPham.get(index).setSoLuong(soLuong);
	}
	
	public long tongTien() {
		long result = 0;
		for(GioHangBean item : dsSanPham) {
			result += item.getThanhTien();
		}
		return result;
	}
	
	public void datMua(UserBean userBean) throws Exception {
		long millis=System.currentTimeMillis();  
		Date ngayMua = new Date(millis);
		gioHangDao.datMua(dsSanPham, userBean, ngayMua);
	}
}
