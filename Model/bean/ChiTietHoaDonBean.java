package bean;

public class ChiTietHoaDonBean {
	long maChiTietHoaDon;
	SachBean sach;
	int soLuongMua;
	boolean daMua;
	
	public ChiTietHoaDonBean(long maChiTietHoaDon, SachBean sach, int soLuongMua, boolean daMua) {
		super();
		this.maChiTietHoaDon = maChiTietHoaDon;
		this.sach = sach;
		this.soLuongMua = soLuongMua;
		this.daMua = daMua;
	}
	
	public long getMaChiTietHoaDon() {
		return maChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(long maChiTietHoaDon) {
		this.maChiTietHoaDon = maChiTietHoaDon;
	}
	public SachBean getSach() {
		return sach;
	}
	public void setSach(SachBean sach) {
		this.sach = sach;
	}
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuong) {
		this.soLuongMua = soLuong;
	}

	public boolean isDaMua() {
		return daMua;
	}

	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}
	
	public long getThanhTien() {
		return soLuongMua * sach.getGia();
	}
	
	
	
}
