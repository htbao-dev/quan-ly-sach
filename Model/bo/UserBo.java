package bo;

import bean.UserBean;
import common.SignupStatus;
import dao.UserDao;



public class UserBo {
	UserDao userDao = BaseBo.dao.getUserDao();
	
	public UserBean login(String username, String password) throws Exception {
		return userDao.login(username, password);
	}
	
	public boolean isValidUsername(String username) {
		return true;
	}
	
	public boolean isValidPassword(String passowrd)
	{
		return true;
	}
	
	public boolean isValidConfirmPassword(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}
	
	public SignupStatus signup(UserBean userBean, String confirmPassword) throws Exception {
		SignupStatus status = SignupStatus.UNKNOW_ERROR;
		UserBean userLookup = userDao.lookupUser(userBean.getUsername());
		if (!isValidUsername(userBean.getUsername())) {
			status = SignupStatus.INVALID_USERNAME;
		}
		else if (!isValidPassword(userBean.getPassword())) {
			status = SignupStatus.INVALID_PASSWORD;
		}
		else if (!isValidConfirmPassword(userBean.getPassword(), confirmPassword)) {
			status = SignupStatus.INVALID_CONFIRM_PASSWORD;
		}
		else if(userLookup != null){ 
			System.out.println("UserBo Lookup: " + userLookup);
			status = SignupStatus.AVALIABLE_USERNAME;	
		}else {
			boolean isSuccessful = userDao.signup(userBean);
			if (isSuccessful) {
				status = SignupStatus.SIGNUP_SUCCESS;
			}
			else {
				status = SignupStatus.UNKNOW_ERROR;
			}
		}
		
		return status;
	}
}
