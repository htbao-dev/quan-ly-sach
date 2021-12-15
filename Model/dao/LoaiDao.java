package dao;

import java.util.ArrayList;

import bean.LoaiBean;

public interface LoaiDao {
	public ArrayList<LoaiBean> getLoai(String search) throws Exception;
	public void deleteLoai(String maLoai) throws Exception;
}
