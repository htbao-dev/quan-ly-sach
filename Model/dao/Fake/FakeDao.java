package dao.Fake;

import dao.Dao;
import dao.GioHangDao;
import dao.HoaDonDao;
import dao.LoaiDao;
import dao.SachDao;
import dao.UserDao;

public class FakeDao implements Dao{

	@Override
	public SachDao getSachDao() {
		return new FakeSachDao();
	}

	@Override
	public LoaiDao getLoaiDao() {
		return new FakeLoaiDao();
	}
	
	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new FakeUserDao();
	}
	
	public GioHangDao getGioHangDao() {
		return new FakeGioHangDao();
	}
	
	@Override
	public HoaDonDao getHoaDonDao() {
		// TODO Auto-generated method stub
		return null;
	}
}
