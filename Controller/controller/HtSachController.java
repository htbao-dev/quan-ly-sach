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
import bean.SachBean;
import bo.GioHangBo;
import bo.LoaiBo;
import bo.SachBo;

/**
 * Servlet implementation class HtSachController
 */
@WebServlet("/HtSachController")
public class HtSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		SachBo sbo=new SachBo();
		ArrayList<SachBean> dssach = null;
		
		try {
			dssach = sbo.getsach();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ml=request.getParameter("ml");
		String key=request.getParameter("search");
		
		
		if (ml!=null)
			try {
				dssach=sbo.TimMaLoai(ml);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(key!=null)
			try {
				dssach=sbo.TimChung(key);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    request.setAttribute("dssach", dssach);
	    RequestDispatcher rd= request.getRequestDispatcher("NhaSach.jsp");
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
