<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<%
   if(session.getAttribute("usersName")==null){
	   response.sendRedirect("/TangShopping/Jsps/landing.jsp");
   }
%>

<div class="container-fluid">
	<div class="row" style="background-color:ghostwhite">
			<div class="col-md-12" style="height: 100px">
			  <h1 align="center">仓储管理系统</h1>
			
			</div>
			<div  style="text-align: right">
				<%=session.getAttribute("usersName")%>：已经登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/exit.do">退出登录</a>
			</div>
	</div>
	<div class="row" style="height:600px">
		<div class="col-md-3" >
				<div class="panel-group" id="accordion">
							  <div class="panel panel-default">
							    <div class="panel-heading">
							      <h4 class="panel-title">
							        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
							          	客户管理
							        </a>
							      </h4>
							    </div>
							    <div id="collapseOne" class="panel-collapse collapse in">
							      <div class="panel-body">
							      		<ul>
							      			<li><a href="../showUsers.do" target="goodsFrame">用户管理</a></li>
							      			
							      			<li><a href="/ShoppingProject/Jsps/UpdPwd.jsp" target="goodsFrame">修改密码</a></li>
							      			
							      			<li><a href="../customer.do" target="goodsFrame">客户管理</a></li>
							      		</ul>
							      </div>
							    </div>
							  </div>
							  
							  <div class="panel panel-default">
							    <div class="panel-heading">
							      <h4 class="panel-title">
							        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
							          	基础数据管理
							        </a>
							      </h4>
							    </div>
							    <div id="collapseTwo" class="panel-collapse collapse in">
							      <div class="panel-body">
							      		<ul>
							      			<li><a href="../goods.do" target="goodsFrame">商品管理</a></li>
							      			
							      			<li><a href="../productClass.do" target="goodsFrame">商品类型管理</a></li>
							      			
							      			<li><a href="../product.do" target="goodsFrame">供应商管理</a></li>
							      		</ul>
							      </div>
							    </div>
							  </div>
							  
							    <div class="panel panel-default">
							    <div class="panel-heading">
							      <h4 class="panel-title">
							        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
							          	进货管理
							        </a>
							      </h4>
							    </div>
							    <div id="collapseOne" class="panel-collapse collapse in">
							      <div class="panel-body">
							      		<ul>
							      			<li><a href="#">进货管理</a></li>
							      			
							      			<li><a href="#">今日库存</a></li>
							      			
							      			<li><a href="#">权限管理</a></li>
							      		</ul>
							      </div>
							    </div>
							  </div>
							  
							    <div class="panel panel-default">
							    <div class="panel-heading">
							      <h4 class="panel-title">
							        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
							          	出货管理
							        </a>
							      </h4>
							    </div>
							    <div id="collapseOne" class="panel-collapse collapse in">
							      <div class="panel-body">
							      		<ul>
							      			<li><a href="../outStock.do" target="goodsFrame">出货管理</a></li>
							      			
							      			<li><a href="#">今日出货</a></li>
							      			
							      			<li><a href="#">权限管理</a></li>
							      		</ul>
							      </div>
							    </div>
							  </div>
							  
					</div>
		
		</div>
		<div class="col-md-9" style="height: 600px;">
			<iframe name="goodsFrame" width="100%" height="100%"></iframe>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12" style="text-align: center;height: 50px;line-height: 50px;background-color:ghostwhite">
		当前在线人数为：<%=application.getAttribute("online") %>
				&copy;版权信息。。。。。。。
		
		</div>
	</div>

</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>