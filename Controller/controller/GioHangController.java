package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHangBean;
import bean.LoaiBean;
import bean.SachBean;
import bean.UserBean;
import bo.GioHangBo;
import bo.LoaiBo;
import bo.SachBo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		GioHangBo gioHangBo = (GioHangBo)session.getAttribute("gioHang");
		
		String them_MaSach = request.getParameter("them");
		String xoa_MaSach = request.getParameter("xoa");
		String mua = request.getParameter("mua");
		String[] soLuong = request.getParameterValues("soLuong");
		
		if (mua != null) {
			UserBean userBean = (UserBean)session.getAttribute("user");
			if (userBean == null) {
				request.setAttribute("muaStatus", 0);
			}
			else {
				try {
					gioHangBo.datMua(userBean);
					request.setAttribute("muaStatus", 1);
					gioHangBo.xoaDsSanPham();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("muaStatus", -1);
					e.printStackTrace();
				}
				
			}
		}
		
		if (them_MaSach != null){
			SachBo sachBo = new SachBo();
			ArrayList<SachBean> listSach = null;
			try {
				listSach = sachBo.getsach();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(SachBean sachBean : listSach){
				if (sachBean.getMaSach().equals(them_MaSach)){
					gioHangBo.them(new GioHangBean(sachBean, 1));
					break;
				}
			}
		}
		
		if (xoa_MaSach != null){
			try{
				gioHangBo.xoa(xoa_MaSach);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if (soLuong != null){

			for (int i = 0; i < soLuong.length; i++){
				gioHangBo.capNhatSoLuong(i, Integer.parseInt(soLuong[i]));
			}
		}
	    RequestDispatcher rd= request.getRequestDispatcher("GioHang.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mua = request.getParameter("mua");
		doGet(request, response);
	}

}
