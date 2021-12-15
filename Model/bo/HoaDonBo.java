package bo;

import java.util.ArrayList;

import bean.HoaDonBean;
import dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao hoaDonDao;
	
	public HoaDonBo() {
		hoaDonDao = BaseBo.dao.getHoaDonDao();// TODO Auto-generated constructor stub
	}
	
	public ArrayList<HoaDonBean> getListHoaDon(long maKhachHang) throws Exception {
		return hoaDonDao.getHoaDon(maKhachHang);
	}
}
