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
import bo.GioHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class StartController
 */
@WebServlet("/StartController")
public class StartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String realPath = request.getServletContext().getRealPath("");
		System.out.println(realPath);
		LoaiBo lbo=new LoaiBo();
		HttpSession session=request.getSession();
	   if (session.getAttribute("gioHang") == null){
		   session.setAttribute("gioHang", new GioHangBo());
	   }
	   
	   if (session.getAttribute("dsloai") == null) 
	   {
			ArrayList<LoaiBean> dsloai = new ArrayList<LoaiBean>();

			try {
				dsloai = lbo.getloai();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				dsloai = new ArrayList<LoaiBean>();
			}
			session.setAttribute("dsloai", dsloai);
	   }
	   response.sendRedirect("HtSachController");
//	   RequestDispatcher rd = request.getRequestDispatcher("HtSachController");
//	   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
