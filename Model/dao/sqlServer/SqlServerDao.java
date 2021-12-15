package dao.sqlServer;

import dao.Dao;
import dao.GioHangDao;
import dao.HoaDonDao;
import dao.LoaiDao;
import dao.SachDao;
import dao.UserDao;

public class SqlServerDao implements Dao{

	@Override
	public SachDao getSachDao() {
		return new SqlServerSachDao();
	}

	@Override
	public LoaiDao getLoaiDao() {
		// TODO Auto-generated method stub
		return new SqlServerLoaiDao();
	}

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new SqlServerUserDao();
	}
	
	public GioHangDao getGioHangDao() {
		return new SqlServerGioHangDao();
	}
	
	@Override
	public HoaDonDao getHoaDonDao() {
		// TODO Auto-generated method stub
		return new SqlServerHoaDonDao();
	}
}
