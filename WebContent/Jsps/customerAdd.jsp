<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户增加</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

</head>
<body>

	<form class="form-horizontal" role="form" style="width: 550px;margin: 150px auto;" action="../addCustomer.do" method="post" >
					   <div class="form-group">
		    <label for="goodsCode" class="col-sm-3 control-label">昵称:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="goodsCode" placeholder="请输入昵称" name="cusName">
			    </div>
 		    </div><br>
 					   
 		    <div class="form-group">
			   <label for="goodsPrice" class="col-sm-3 control-label">联系方式:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="goodsPrice" placeholder="请输入联系方式" name="cusPhone">
			    </div>
 		    </div><br>
 					   
 		   <div class="form-group">
		    <label for="goodsType" class="col-sm-3 control-label">地址:</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="goodsType" placeholder="请输入地址" name="cusAdd">
			    </div>
 		  </div><br>
 					   
 			   
 		   <div class="form-group">
			    <label for="inputEmail3" class="col-sm-3 control-label"></label>
			    <div class="col-sm-9">
			       <input type="submit" class="btn btn-info col-sm-12" value="保存" />
			    </div>
 		   </div>
 	</form>
 					
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>