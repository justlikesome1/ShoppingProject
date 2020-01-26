package com.woniuxy.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniuxy.daos.CustomerDao;
import com.woniuxy.entitys.Customer;
import com.woniuxy.tools.MD5TOOL;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet({"/customer.do","/addCustomer.do","/onCustomer.do","/offCustomer.do","/delCustomer.do","/updCustomer.do","/register.do"})
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
	 * @param String 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		System.out.println(path);
		CustomerDao cusDao = new CustomerDao();
		
		if (path.equals("/customer.do")) {
			request.setCharacterEncoding("UTF-8");
			
			List<Customer> list = cusDao.getAll();
			request.setAttribute("customer", list);
			
			request.getRequestDispatcher("Jsps/customer.jsp").forward(request, response);
		}
		else if(path.equals("/addCustomer.do")){
			request.setCharacterEncoding("UTF-8");
			
			String cusName = request.getParameter("cusName");
			String cusPhone = request.getParameter("cusPhone");
			String cusAdd = request.getParameter("cusAdd");
			
			try {
				Customer cus = new Customer(cusName, MD5TOOL.getMD5String("123"), cusPhone, cusAdd);
				
				cusDao.addCustomer(cus);
				
				response.sendRedirect("customer.do");
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		    }
		}
		else if(path.equals("/onCustomer.do")){
			
			String cusId = request.getParameter("cusId");
			
			cusDao.onCustomer(Integer.parseInt(cusId));
			
			response.sendRedirect("customer.do");
			
		}
		else if(path.equals("/offCustomer.do")){
			
			String cusId = request.getParameter("cusId");
			
			cusDao.offCustomer(Integer.parseInt(cusId));
			
			response.sendRedirect("customer.do");
			
		}	
		else if(path.equals("/delCustomer.do")){
			
			String cusId = request.getParameter("cusId");
			
			cusDao.delCustomer(Integer.parseInt(cusId));
			
			response.sendRedirect("customer.do");
			
		}	
		else if(path.equals("/updCustomer.do")){
			
			String cusId = request.getParameter("cusId");
			String cusName = request.getParameter("cusName");
			String cusPhone = request.getParameter("cusPhone");
			String cusAdd = request.getParameter("cusAdd");
			Customer cus = new Customer(cusId, cusName, cusPhone, cusAdd);
			
			cusDao.updCustomer(cus);
			
			response.sendRedirect("customer.do");
			
		}		
		else if (path.equals("/register.do")) {//зЂВс
			String cusName = request.getParameter("cusName");
			String cusPhone = request.getParameter("cusPhone");
			String cusAdd = request.getParameter("cusAdd");
			
			CustomerDao cd = new CustomerDao();
			try {
				String cusPwd = MD5TOOL.getMD5String("123");
				Customer cus = new Customer(cusName, cusPwd, cusPhone, cusAdd);
				
				cd.addCustomer(cus);
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			

	}

}
