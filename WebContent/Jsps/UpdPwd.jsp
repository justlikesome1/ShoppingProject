
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/bootstrap.min.css">

</head>
<body>
     <form class="form-horizontal" action="../updPwd.do" method="post" style="width:80%;margin: 80px auto"> 
     
     	<div class="form-group">
			<label class="col-md-5 col-sm-5 control-label">原密码：</label>
			<div class="col-md-4 ">
				<input type="password" class="form-control"  required="required" name="userOldPwd">
			</div>
			<div class="clo-md-3" id="showPwd"></div>
			
		</div><br>
		<div class="form-group">
			<label class="col-md-5 col-sm-5 control-label">请输入新密码：</label>
			<div class="col-md-4 " >
			
			   <input type="password" class="form-control" required="required" name="userNewPwd">
			   
			</div>
		</div><br>
		<div class="form-group">
			<label class="col-md-5 col-sm-5 control-label">请重新输入新密码：</label>
			<div class="col-md-4">
				
			   <input type="password" class="form-control" required="required" name="userNewPwd1">
			</div>
		</div><br>
	
            
           
		<div class="form-group">
			<label class="col-md-5 col-sm-5"></label>
			<div class="col-md-4" >
				<input type="submit" class="btn btn-info btn-block" value="保存">
				
			</div>
			
		</div>
     </form>
     
<script type="text/javascript"  src="../js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"  src="../js/bootstrap.min.js"></script>
<script type="text/javascript">

var tag = true;
$("[name = userOldPwd]").change(function(){
	$.ajax({
		cache:false,
		type:"POST",
		url:"../checkPwd.do",
		data:{"oldPwd":$("[name=userOldPwd]").val()},
		async:false,
		error:function(){
			alert("error");
		},
		success:function(data){
			if (data == "true") {
				tag = true;
				$("#showPwd").html(" ");
			}else{
				tag = false;
				$("#showPwd").html("原密码不正确");
			}
			
		}
		
	});
});

$(":submit").click(function(){
	if (tag = false) {
		alert("原密码不正确");
		return false;
	}
	if ($("[name = userNewPwd]").val() != $("[name = userNewPwd1]").val()) {
		alert("密码和确认密码不一致");
		return false;
	}
	
})


</script>

</body>
</html>