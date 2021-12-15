package bo;

import java.util.ArrayList;

import bean.SachBean;
import dao.SachDao;

public class SachBo {
	SachDao sdao= BaseBo.dao.getSachDao();
	
	   public ArrayList<SachBean> getsach() throws Exception{
		   return sdao.getSach("");
	   }
	   public ArrayList<SachBean> TimMaLoai(String maloai) throws Exception{
		   ArrayList<SachBean> result = new ArrayList<SachBean>();
		   maloai = maloai.toLowerCase();
		   for(SachBean item : sdao.getSach("")) {
			   if (item.getMaLoai().toLowerCase().equals(maloai)){
				   result.add(item);
			   }
		   }
		   
		   return result;
	   }
	   public ArrayList<SachBean> TimChung(String key) throws Exception{
		   //Tra ve all sach co ten sach hoac tac gia =key (tương doi)
		   key = key.toLowerCase();
		   ArrayList<SachBean> result = sdao.getSach(key);
//		   sdao.
//		   for(SachBean item : sdao.getSach("")) {
//			   if(item.getTenSach().toLowerCase().contains(key) || item.getTacGia().toLowerCase().contains(key)) {
//				   result.add(item);
//			   }
//		   }
//		   
		   return result;
	   }
	   public long Demsach(String maloai) throws Exception {
		  // Dem xem co ? sach co ma loai: maloai
		   long result = 0;
		   maloai = maloai.toLowerCase();
		   for(SachBean item : sdao.getSach("")) {
			   if (item.getMaLoai().toLowerCase().equals(maloai)){
				   result++;
			   }
		   }
		   return result;
	   }

}
