package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import bo.UserBo;
import common.SignupStatus;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		UserBo userBo = new UserBo();
		SignupStatus status;
		String username = request.getParameter("TenDangNhap");
		if (username != null) {
			String hoTen = request.getParameter("HoTen");
			String password = request.getParameter("MatKhau");
			String confirmPassword = request.getParameter("NhapLaiMatKhau");
			String email = request.getParameter("Email");
			String diaChi = request.getParameter("DiaChi");
			String soDT = request.getParameter("SoDienThoai");
			UserBean userBean = new UserBean(username, password, -1, hoTen, diaChi, soDT, email);
			request.setAttribute("userBean", userBean);
			try {
				status = userBo.signup(userBean, confirmPassword);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				status = SignupStatus.UNKNOW_ERROR;
				e.printStackTrace();
			}
			System.out.println(status);
			request.setAttribute("status", status);
		}
	    RequestDispatcher rd= request.getRequestDispatcher("DangKy.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
