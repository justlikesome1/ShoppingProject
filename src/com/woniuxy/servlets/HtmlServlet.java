package com.woniuxy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.woniuxy.daos.CustomerDao;
import com.woniuxy.daos.GoodsDao;
import com.woniuxy.entitys.Customer;
import com.woniuxy.entitys.Goods;
import com.woniuxy.entitys.PageBean;
import com.woniuxy.tools.MD5TOOL;

/**
 * Servlet implementation class HtmlServlet
 */
@WebServlet({"/login.do","/getAllOfHtml.do","/indexExit.do","/getCustomer.do","/updBySelf.do"})
public class HtmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtmlServlet() {
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
		
		if (path.equals("/login.do")) {
			response.setContentType("text/html;charset=utf-8");
			String cusName = request.getParameter("cusName");
			String cusPwd = request.getParameter("cusPwd");
			CustomerDao cusDao = new CustomerDao();
			
			int cusId;
			try {
				cusId = cusDao.getCusIdByName(cusName, MD5TOOL.getMD5String(cusPwd));
			
			PrintWriter out=response.getWriter();
			
			if (cusId != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("cusName", cusName);
				session.setAttribute("cusPwd", cusPwd);
				session.setAttribute("cusId",String.valueOf(cusId));
			
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
		else if (path.equals("/getAllOfHtml.do")) {
			String tempcutPage = request.getParameter("cutPage");
			String goodsName = request.getParameter("goodsName");
			
			int cutPage = 1;
			try {
				GoodsDao gd = new GoodsDao();
				PageBean<Goods> pageBean = new PageBean<Goods>();
				int totalCount = gd.getAllCount(goodsName);
				//总数�?
				pageBean.setTotalCount(totalCount);
				
				//设置每页显示条数
				pageBean.setPageSize(8);
				//对得到的请求参数进行处理
				if (tempcutPage != null && tempcutPage != "") {
					cutPage = Integer.parseInt(tempcutPage);
				}
				if (cutPage<1) {
					cutPage = 1;
				}
				if (cutPage>pageBean.getPages()) {
					cutPage = pageBean.getPages();
				}
				if (pageBean.getPages() == 0) {
					cutPage = 1;
				}
				pageBean.setCurrentPage(cutPage);
				
				List<Goods> list = gd.getAllGoodsByHtmlName( goodsName, pageBean);
				
				pageBean.setData(list);
				
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				
				String cusName = (String)request.getSession().getAttribute("cusName");
				
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("cusName", cusName);
				map.put("pageBean", pageBean);
				JSONObject js = new JSONObject(map);
				out.print(js);
				out.flush();
				out.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (path.equals("/indexExit.do")) {
			
			HttpSession session = request.getSession();
			session.removeAttribute("cusName");
			session.removeAttribute("cusId");
		
		}
		else if (path.equals("/getCustomer.do")) {
			
			response.setContentType("text/html;charset=utf-8");
			
			String cusName = request.getParameter("cusName");
			
			CustomerDao cd = new CustomerDao();
			Customer cus =cd.getCusByName(cusName);
			
			
			JSONObject obj = new JSONObject(cus);
			PrintWriter out = response.getWriter();
		
			out.print(obj);
			out.flush();
			out.close();
		}
		else if (path.equals("/updBySelf.do")) {
			response.setContentType("text/html;charset=utf-8");
			
			String cusId = request.getParameter("cusId");
			String cusName = request.getParameter("cusName");
			String cusPwd = request.getParameter("cusPwd");
			String cusPhone = request.getParameter("cusPhone");
			String cusAdd = request.getParameter("cusAdd");
			System.out.println(cusName+cusPwd+cusPhone+cusAdd);
			Customer cus;
			try {
				cus = new Customer(Integer.parseInt(cusId),cusName, MD5TOOL.getMD5String(cusPwd), cusPhone, cusAdd);
				CustomerDao cd = new CustomerDao();
				
				boolean isOk = cd.updBySelf(cus);
				PrintWriter out = response.getWriter();
				out.print(isOk);
				out.flush();
				out.close();
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
