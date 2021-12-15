package bo;

import java.util.ArrayList;

import bean.LoaiBean;
import dao.LoaiDao;

public class LoaiBo {
	LoaiDao ldao= BaseBo.dao.getLoaiDao();
	
	  public ArrayList<LoaiBean> getloai() throws Exception{
			return ldao.getLoai("");
	  }
}
