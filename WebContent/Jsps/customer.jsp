<%@page import="com.woniuxy.entitys.Customer"%>
<%@page import="com.woniuxy.entitys.PageBean"%>
<%@page import="com.woniuxy.entitys.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<table class="table table-bordered table-striped table-hover table-condensed" style="width:900px;margin: 20px auto">
	 	
	 	<div style="text-align: right;width:700px;margin: 20px auto ">
			<a class="btn btn-success" href="<%=request.getContextPath()%>/Jsps/customerAdd.jsp">增加</a>
		</div>

    <thead>
		 <tr>
		 	<th>客户ID</th>
		 	<th>客户名称</th>
		 	<th>客户密码</th>
		 	<th>客户电话</th>
		 	<th>客户地址</th>
		 	<th>客户状态</th>
		 	<th>操作栏</th>
		 	
		 </tr>
	 </thead>
	 <tbody>
	     <%
	     List<Customer> list =(List<Customer>)request.getAttribute("customer");
	 	
	       for(Customer cus:list)
	       {	   
	     
	     %>
	 	  <tr>
	 	  	<td><%=cus.getCusId()%></td>
	 	  	<td><%=cus.getCusName()%></td>
	 	  	<td><%=cus.getCusPwd()%></td>
	 	  	<td><%=cus.getCusPhone()%></td>
	 	  	<td><%=cus.getCusAdd()%></td>
	 	  	<td><%=cus.getCusStaus()%></td>
	 	  	<td>
		 	  	<a href="<%=request.getContextPath()%>/delCustomer.do?cusId=<%=cus.getCusId()%>" class="btn btn-danger btn-xs">删除</a>
	          	<a href="<%=request.getContextPath()%>/offCustomer.do?cusId=<%=cus.getCusId()%>" class="btn btn-success btn-xs">启用</a>
	          	<a href="<%=request.getContextPath()%>/onCustomer.do?cusId=<%=cus.getCusId()%>" class="btn btn-success btn-xs">停用</a>
	 	  	</td>
	 	  </tr>
	     
	     <%
	       }
	     %>
	     

	 </tbody>
	 
  
</table>

</body>
</html>