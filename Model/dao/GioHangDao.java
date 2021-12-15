package dao;

import java.sql.Date;
import java.util.ArrayList;

import bean.GioHangBean;
import bean.UserBean;

public interface GioHangDao {
	public void datMua(ArrayList<GioHangBean> dsSanPham, UserBean userBean, Date ngayMua) throws Exception;
}
