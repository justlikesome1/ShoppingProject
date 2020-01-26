<%@page import="com.woniuxy.entitys.Users"%>
<%@page import="com.woniuxy.entitys.PageBean"%>
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
			<a class="btn btn-success" href="<%=request.getContextPath()%>/Jsps/usersAdd.jsp">增加</a>
		</div>

    <thead>
		 <tr>
		 	<th>员工ID</th>
		 	<th>员工名称</th>
		 	<th>员工密码</th>
		 	<th>员工职位</th>
		 	<th>客户状态</th>
		 	<th>操作栏</th>
		 	
		 </tr>
	 </thead>
	 <tbody>
	     <%
	     List<Users> list =(List<Users>)request.getAttribute("users");
	 	
	       for(Users u:list)
	       {	   
	     
	     %>
	 	  <tr>
	 	  	<td><%=u.getUserId()%></td>
	 	  	<td><%=u.getUserName()%></td>
	 	  	<td><%=u.getUserPwd()%></td>
	 	  	<td><%=u.getUserRole()%></td>
	 	  	<td><%=u.getUserStatus()%></td>
	 	  	<td>
		 	  	<a href="<%=request.getContextPath()%>/delUser.do?uId=<%=u.getUserId()%>" class="btn btn-danger btn-xs">删除</a>
	          	<a href="<%=request.getContextPath()%>/offUser.do?uId=<%=u.getUserId()%>" class="btn btn-success btn-xs">启用</a>
	          	<a href="<%=request.getContextPath()%>/onUser.do?uId=<%=u.getUserId()%>" class="btn btn-success btn-xs">停用</a>
	          	<a href="<%=request.getContextPath()%>/resetPwd.do?uId=<%=u.getUserId()%>" class="btn btn-success btn-xs">重置密码</a>
	 	  	</td>
	 	  </tr>
	     
	     <%
	       }
	     %>
	     

	 </tbody>
	 
  
</table>

</body>
</html>