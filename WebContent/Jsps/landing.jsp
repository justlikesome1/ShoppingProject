<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
		<style type="text/css">
			#form-info{
				width: 400px;
				margin:150px 0px 0px 700px;
			}
			
		</style>
	</head>
	<body>
	
	<%
	Cookie ck[] = request.getCookies();
	String userName ="";
	
	if(ck != null){
		for(Cookie c : ck){
			
			if(c.getName().equals("uName")){
				userName = c.getValue();
			}
		}
	}
	%>
	
		<div class="container-fluid">
		<div class="row" style="background-color:gainsboro; color:black; height: 100px; line-height: 3;">
		 		<div  class="col-md-12">
		 			<h1 align="center">电商管理系统</h1>
		 		</div> 
				
		</div>
		<div class="row" style="height:440px;">
		 		<div  class="col-md-12">
		 			    <form class="form-horizontal" action="<%=request.getContextPath() %>/londing.do" method="post" id="form-info"> 
							<div class="form-group">
								<label class="col-md-4 col-sm-4 control-label">用户名：</label>
								<div class="col-md-6 ">
									<input type="text" class="form-control"  required="required" name="usersName">
								
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 col-sm-4 control-label">密码：</label>
								<div class="col-md-6 ">
									<input type="password" class="form-control"  required="required" name="usersPwd">
								
								
								</div>
							</div>
							<div class="form-group col-sm-4 control-label">
								<label class="col-md-4 col-sm-4 control-label">验证码：</label>
								<div class="col-md-4">
									<input type="text" class="form-control"  required="required" name="checkCode">
								   <img alt="" src="../checkCode.do" onclick="this.src='../checkCode.do?t='+Math.random()">
								     
								</div>
							</div>
							
							
					
							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-6">
								    
									     	<input type="submit" class="btn btn-info" value="登录"/>
									    	<input type="reset" class="btn btn-info" value="取消"/>
								
								</div> 
							</div>
						</form>
		 		</div> 
				 
		</div>
		<div class="row" style="background-color: #eee;height: 70px">
		 		<div  class="col-md-12" style="text-align: center;line-height: 70px">
		 		
		 			&copy;版权信息。。。。。。。
		 		</div>
				
		</div>		

</div>
  


<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
		
</body>
</html>