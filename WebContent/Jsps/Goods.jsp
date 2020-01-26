<%@page import="com.woniuxy.entitys.PageBean"%>
<%@page import="com.woniuxy.entitys.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<form action="<%=request.getContextPath()%>/goods.do" method="post" name="form1">

	
	 <div style="width: 700px;margin: 20px auto;">
     <!-- 判断是否要显示 -->
		商品编号：<input type="text" name="goodsCode"   value="${requestScope.queryMap.goodCode}"/>
     <!-- 判断是否要显示 -->
      	  商品名称：<input type="text" name="goodsName"  value="${requestScope.queryMap.goodsName}"/>
       <input type="submit" value="查询" class="btn btn-info"/>
       
   </div>
	
<table class="table table-bordered table-striped table-hover table-condensed" style="width:900px;margin: 20px auto">
	 	
	 	<div style="text-align: right;width:700px;margin: 20px auto ">
			<a class="btn btn-success" href="<%=request.getContextPath()%>/Jsps/goodsAdd.jsp">增加</a>
		</div>

    <thead>
		 <tr>
		 	<th>商品编号</th>
		 	<th>商品名称</th>
		 	<th>商品价格</th>
		 	<th>商品数量</th>
		 	<th>类型名称</th>
		 	<th>生产商</th>
		 	<th>商品图片</th>
		 	<th>操作栏</th>
		 	
		 </tr>
	 </thead>
	 <tbody>
	     <%
	//     List<Goods> list =(List<Goods>)request.getAttribute("Goods");
	     PageBean<Goods> pageBean = (PageBean<Goods>)request.getAttribute("pageBean");
	 	
	       for(Goods g:pageBean.getData())
	       {	   
	     
	     %>
	 	  <tr>
	 	  	<td><%=g.getGoodsCode()%></td>
	 	  	<td><%=g.getGoodsName()%></td>
	 	  	<td><%=g.getGoodsPrice()%></td>
	 	  	<td><%=g.getGoodsCount()%></td>
	 	  	<td><%=g.getTypeName()%></td>
	 	  	<td><%=g.getSupplierName()%></td>
	 	  	<td><%=g.getGoodsImg()%></td>
	 	  	<td>
		 	  	<a href="<%=request.getContextPath()%>/delGoods.do?goodsId=<%=g.getGoodsId()%>" class="btn btn-danger btn-xs">删除</a>
	          	<a href="<%=request.getContextPath()%>/UpdGoods.do?goodsId=<%=g.getGoodsId()%>" class="btn btn-success btn-xs">修改</a>
	 	  	</td>
	 	  </tr>
	     
	     <%
	       }
	     %>
	     
	      <tr>
          	<td colspan="8">
          	 <a href="javascript:goPage(1)">首页</a>
          	 <a href="javascript:goPage(<%=pageBean.getCurrentPage()-1%>)">上一页</a>
          	 <%
          	   for(int i=1;i<=pageBean.getPages();i++)
          	   {
          		   if(pageBean.getCurrentPage()==i)
          		   {
          	 %>
          	         <%=i%>
          	     <%
          		   }
          		   else
          		   {
          	     %>
          	 		<a href="javascript:goPage(<%=i%>)"><%=i%></a>
          	 
          	 <%
          		   }
          	   }
          	 %>
          	 
          	 <a href="javascript:goPage(<%=pageBean.getCurrentPage()+1%>)">下一页</a>
          	 <a href="javascript:goPage(<%=pageBean.getPages()%>)">尾页</a>
          	 
          	  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          	      <select name="pageSize" onchange="goPage(1)">
          	      	<option value="3">3</option>
          	      	<option value="5">5</option>
          	      	<option value="10">10</option>
          	      	<option value="15">15</option>
          	      </select>
          			 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          	  共<%=pageBean.getPages()%>页，共<%=pageBean.getTotalCount()%>条
          	  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          	  当前页是<%=pageBean.getCurrentPage()%>
          	</td>
          </tr>
	 </tbody>
	 
  
</table>
    <input type="hidden" name="cutPage" value="1" />
 </form>   
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript">
function goPage(cutPageParam){
	form1.cutPage.value = cutPageParam;
	form1.submit();
}

	$("[name=pageSize] option[value=<%=pageBean.getPageSize()%>]").attr("selected","selected");
</script>
</body>
</html>