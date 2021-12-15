package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoaiBean;
import bean.UserBean;
import bo.LoaiBo;
import bo.UserBo;

/**
 * Servlet implementation class TaiKhoanController
 */
@WebServlet("/TaiKhoanController")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaiKhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		boolean isLogout = Boolean.parseBoolean(request.getParameter("logout"));
	   	String username = request.getParameter("username");
	   	String password = request.getParameter("password");
	   	UserBo ubo = new UserBo();

	   	if (username != null){
	   		try {
	   			UserBean userBean = ubo.login(username, password);
				if (userBean != null){
					session.setAttribute("user", userBean);
				}
				else{
					session.setAttribute("user", null);
					session.setAttribute("loginFail", "true");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String header = request.getHeader("referer");
    		response.sendRedirect(header);
	   	}
	   	
		if(isLogout){
			session.removeAttribute("user");
			response.sendRedirect("HtSachController");
		}
//		String context = request.getContextPath();
//		String url = header.substring(header.indexOf(context) + context.length() + 1);
//	    		System.out.println(url);
//	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
