<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert</title>
<script>
function add(){
	$.ajax({
		  type: 'POST',
		  url: url,
		  data: $("#form").serialize(),
		  success: function(result){
			  //result
		  },
		  dataType: "json"
		});
}


</script>
</head>
<body>
   <form action="insertManager.action" method="post" >
                
          管理员名称：<input type="text" name="name" /><br>
          管理员密码：<input type="text" name="pwd" /><br>
        系统设置权限 <input type="checkbox"  name="sysset" value="1"  /><br>
        读者管理权限：<input type="checkbox" name="readerset" value="1"  /> <br> 
        图书管理权限：<input type="checkbox" name="bookset" value="1"  /><br>
        图书借还权限：<input type="checkbox" name="borrowback" value="1"  /><br>
      <input type="submit" value="新增"/><br>
   </form>
    <form action="ManagerPage.action?currentPage=1" method="post" >
      <input type="submit" value="返回"/><br>
   </form>
   
</body>
</html>