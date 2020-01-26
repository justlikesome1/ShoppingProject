package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniuxy.daos.CustomerDao;
import com.woniuxy.tools.MD5TOOL;

/**
 * Servlet implementation class SettleServlet
 */
@WebServlet("/payment.do")
public class SettleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		System.out.println(path);
		
		if (path.equals("/payment.do")) {
			String cusName = request.getParameter("cusName");
			String cusPwd = request.getParameter("cusPwd");
			
			CustomerDao cusDao = new CustomerDao();

			int cusId;
			try {
				cusId = cusDao.getCusIdByName(cusName, MD5TOOL.getMD5String(cusPwd));
			
			PrintWriter out=response.getWriter();
			
			if (cusId != 0) {

				out.print(true);
				
			}else {
				out.print(false);
			}
			out.flush();
			out.close();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
