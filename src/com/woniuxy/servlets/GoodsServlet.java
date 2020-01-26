package com.woniuxy.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.woniuxy.daos.GoodsDao;
import com.woniuxy.entitys.Goods;
import com.woniuxy.entitys.PageBean;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet({ "/goods.do", "/goodsAdd.do", "/delGoods.do", "/UpdGoods.do", "/UpdGoodsSave.do" })
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		System.out.println(path);
		GoodsDao gd = new GoodsDao();

		if (path.equals("/goods.do")) {
			request.setCharacterEncoding("UTF-8");
			//首页
			List<Goods> list = new ArrayList<Goods>();
			list = gd.getAllGoodsAndName();
			
				//查询
				String goodsCode = request.getParameter("goodsCode");
				String goodsName = request.getParameter("goodsName");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("goodCode", goodsCode);
				map.put("goodsName", goodsName);
				
					//分页
					PageBean<Goods> pagebean = new PageBean<Goods>();
					try {
						int totalCount = gd.getTotalCount(goodsCode, goodsName);
						
						//总行�?
						pagebean.setTotalCount(totalCount);
						//每页显示总行�?
						String tempPageBean = request.getParameter("pageSize");
						int pageSize = 5;
						if (tempPageBean != null) {
							pageSize = Integer.parseInt(tempPageBean);
						}
						pagebean.setPageSize(pageSize);
						//设置当前�?
						int currentPage = 1;
						String temeCurrentPage = request.getParameter("cutPage");
						if (temeCurrentPage != null) {
							currentPage = Integer.parseInt(temeCurrentPage);
						}
						if (currentPage<1) {
							currentPage = 0;
						}
						if (currentPage>pagebean.getPages()) {
							currentPage = pagebean.getPages();
						}
						if (currentPage == 0) {
							currentPage = 1;
						}
						pagebean.setCurrentPage(currentPage);
						
						//获得每页显示的数�?
						List<Goods> date = gd.getAllGoodsByCodeAndName(goodsCode, goodsName,pagebean);
						pagebean.setData(date);
						request.setAttribute("pageBean", pagebean);
						
						request.setAttribute("queryMap", map);
						
//			request.setAttribute("Goods", list);
						request.getRequestDispatcher("/Jsps/Goods.jsp").forward(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				

		} else if (path.equals("/goodsAdd.do")) {
			request.setCharacterEncoding("UTF-8");
			// 得到项目在服务器上的真实路径：D:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\TangShopping\
			String realPath = request.getServletContext().getRealPath("/");
			// 项目路径下的front/upload目录
			String dirPath = realPath + File.separator + "front" + File.separator + "upload";

			File f = new File(dirPath);
			if (!f.exists()) {

				f.mkdirs();
			}
			// 处理文件上传：请求对�? 存放路径 文件大小 编码
			MultipartRequest mreq = new MultipartRequest(request, dirPath, 5 * 1024 * 1024, "utf-8");
			// 不能再使用原来的请求对象得到请求参数，必须使用mreq

			String supplierId = mreq.getParameter("goodsSupplier");
			String typeId = mreq.getParameter("goodsType");
			String goodsCode = mreq.getParameter("goodsCode");
			String goodsName = mreq.getParameter("goodsName");
			String goodsPrice = mreq.getParameter("goodsPrice");

			// 参数写文件域的名�?
			String oldFileName = mreq.getFilesystemName("goodsImg");

			// 得到文件的新名称
			Date d = new Date(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String dateStr = sdf.format(d);
			Random random = new Random();
			int rn = random.nextInt(10000);// [)
			// 得到源文件的后缀
			String ext = oldFileName.substring(oldFileName.indexOf("."));
			// 得到新文件名�?
			String newFileName = dateStr + rn + ext;
			// 创建�?个针对原文件的文件对�?
			File oldFile = new File(dirPath + File.separator + oldFileName);
			// 更改文件名称
			oldFile.renameTo(new File(dirPath + File.separator + newFileName));
			// 存放数据�?
			String goodsImg = "front" + File.separator + "upload" + File.separator + newFileName;

			Goods goods = new Goods(Integer.parseInt(supplierId), Integer.parseInt(typeId),goodsCode,goodsName, 
					Float.parseFloat(goodsPrice), goodsImg);

			gd.addGoods(goods);

			response.sendRedirect("goods.do");

		} else if (path.equals("/delGoods.do")) {
			String goodsId = request.getParameter("goodsId");

			gd.DelGoods(Integer.parseInt(goodsId));

			response.sendRedirect("goods.do");

		} else if (path.equals("/UpdGoods.do")) {
			String goodsId = request.getParameter("goodsId");

			Goods goods = gd.getGoodsById(Integer.parseInt(goodsId));

			request.setAttribute("goods", goods);

			request.getRequestDispatcher("Jsps/goodsUpd.jsp").forward(request, response);

		} else if (path.equals("/UpdGoodsSave.do")) {

			// 得到项目在服务器上的真实路径：D:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\TangShopping\
			String realPath = request.getServletContext().getRealPath("/");
			// 项目路径下的front/upload目录
			String dirPath = realPath + File.separator + "front" + File.separator + "upload";

			File f = new File(dirPath);
			if (!f.exists()) {

				f.mkdirs();
			}
			// 处理文件上传：请求对�? 存放路径 文件大小 编码
			MultipartRequest mreq = new MultipartRequest(request, dirPath, 10 * 1024 * 1024, "utf-8");
			// 不能再使用原来的请求对象得到请求参数，必须使用mreq

			String goodsId = mreq.getParameter("goodsId");
			String supplierId = mreq.getParameter("goodsSupplier");
			String typeId = mreq.getParameter("goodsType");
			String goodsCode = mreq.getParameter("goodsCode");
			String goodsName = mreq.getParameter("goodsName");
			String goodsPrice = mreq.getParameter("goodsPrice");
			String goodsCount = mreq.getParameter("goodsCount");

			System.out.println(goodsId);

			// 参数写文件域的名�?
			String oldFileName = mreq.getFilesystemName("goodsImg");

			// 得到文件的新名称
			Date d = new Date(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String dateStr = sdf.format(d);
			Random random = new Random();
			int rn = random.nextInt(10000);// [)
			// 得到源文件的后缀
			String ext = oldFileName.substring(oldFileName.indexOf("."));
			// 得到新文件名�?
			String newFileName = dateStr + rn + ext;
			// 创建�?个针对原文件的文件对�?
			File oldFile = new File(dirPath + File.separator + oldFileName);
			// 更改文件名称
			oldFile.renameTo(new File(dirPath + File.separator + newFileName));
			// 存放数据�?
			String goodsImg = "front" + File.separator + "upload" + File.separator + newFileName;

			Goods goods = new Goods(Integer.parseInt(goodsId), Integer.parseInt(supplierId), Integer.parseInt(typeId),
					goodsCode, goodsName, Float.parseFloat(goodsPrice), goodsImg);

			gd.UpdGoods(goods);

			response.sendRedirect("goods.do");
		}

	}

}
