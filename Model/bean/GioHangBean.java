package bean;

public class GioHangBean {
	private SachBean sachBean;
	private int soLuong;
	
	public GioHangBean(SachBean sachBean, int soLuong) {
		super();
		this.sachBean = sachBean;
		this.soLuong = soLuong;
	}

	public SachBean getSachBean() {
		return sachBean;
	}
	
	public void setSachBean(SachBean sachBean) {
		this.sachBean = sachBean;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public long getThanhTien() {
		return sachBean.getGia() * soLuong;
	}
}
