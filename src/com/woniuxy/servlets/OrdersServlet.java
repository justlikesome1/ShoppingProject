package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.daos.OrdersDao;
import com.woniuxy.entitys.Orders;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet({"/orderConfirm.do"})
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = request.getServletPath();
		System.out.println(path);
		
		if (path.equals("/orderConfirm.do")) {
			
			String address = request.getParameter("address");
			String sids = request.getParameter("sids");
			String orderRemark = request.getParameter("orderRemark");
			String totalPrice = request.getParameter("totalPrice");
			String cusId = (String)request.getSession().getAttribute("cusId");
			
			Orders o = new Orders(Integer.parseInt(cusId),Float.parseFloat(totalPrice), orderRemark,address);
			
			OrdersDao od = new OrdersDao();
			od.addOrders(o, sids);
			
			PrintWriter out = response.getWriter();
			String ordersId = od.getOrderId();
			out.print(ordersId);
			out.flush();
			out.close();
			
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
