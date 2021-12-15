package dao;

import java.util.ArrayList;

import bean.HoaDonBean;

public interface HoaDonDao {
	public ArrayList<HoaDonBean> getHoaDon(long maKhachHang) throws Exception;
}
