package bean;

public class UserBean {
	private String username;
	private long maKH;
	private String hoTen;
	private String diaChi;
	private String soDT;
	private String email;
	private String password;
	
	
	public UserBean(String username, long maKH, String hoTen, String diaChi, String soDT, String email) {
		super();
		this.username = username;
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
	}
	
	
	
	public UserBean(String username, String password, long maKH, String hoTen, String diaChi, String soDT, String email) {
		super();
		this.username = username;
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.email = email;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getMaKH() {
		return maKH;
	}
	public void setMaKH(long maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
