package dao.Fake;

import bean.UserBean;
import common.SignupStatus;
import dao.UserDao;

public class FakeUserDao implements UserDao{
	@Override
	public UserBean login(String userName, String password) {
		if (userName.equals("admin") && password.equals("admin"))
		{
			return new UserBean("admin", 1, "Huynh Bao", "", "0123", "");
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean signup(UserBean userBean) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public UserBean lookupUser(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
