package dao;

import java.util.ArrayList;

import bean.SachBean;

public interface SachDao {
	public ArrayList<SachBean> getSach(String search) throws Exception;
	public void deleteSach(String maSach) throws Exception;
}
