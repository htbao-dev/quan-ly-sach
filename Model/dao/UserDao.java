package dao;

import bean.UserBean;
import common.SignupStatus;

public interface UserDao {
	public UserBean login(String userName, String password) throws Exception;
	public boolean signup(UserBean userBean) throws Exception;
	public UserBean lookupUser(String username) throws Exception;
}
