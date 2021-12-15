package bo;

import dao.Dao;
import dao.Fake.FakeDao;
import dao.sqlServer.SqlServerDao;

public class BaseBo {
	static public Dao dao = new SqlServerDao();
}