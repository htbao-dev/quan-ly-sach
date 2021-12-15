package bean;

import java.sql.Date;
import java.util.ArrayList;


public class HoaDonBean {
	long maHoaDon;
	long maKH;
	Date ngayMua;
	boolean daMua;
	ArrayList<ChiTietHoaDonBean> chiTiet;
	
	public HoaDonBean(long maHoaDon, long maKH, Date ngayMua, boolean daMua, ArrayList<ChiTietHoaDonBean> chiTiet) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.ngayMua = ngayMua;
		this.daMua = daMua;
		this.chiTiet = chiTiet;
	}
	
	public long getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public long getMaKH() {
		return maKH;
	}
	public void setMaKH(long maKH) {
		this.maKH = maKH;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public boolean isDaMua() {
		return daMua;
	}
	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}
	public ArrayList<ChiTietHoaDonBean> getChiTiet() {
		return chiTiet;
	}
	public void setChiTiet(ArrayList<ChiTietHoaDonBean> chiTiet) {
		this.chiTiet = chiTiet;
	}
	public long getTongTien() {
		long tongTien = 0;
		for (ChiTietHoaDonBean chiTietHoaDonBean : chiTiet) {
			tongTien += chiTietHoaDonBean.getThanhTien();
		}
		return tongTien;
	}
	
	
}
