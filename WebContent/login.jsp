
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="javabean.Page" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到图书管理系统</title>
<script language="javascript">
   function check(form){
	   if(form.managername.value==""){
		   alert("请输入管理员名称！");
		   form.managername.focus();
		   return false;
	   }
	   if(form.pwd.value==""){
		   alert("请输入密码！");
		   form.pwd.focus();
		   return false;      
	   }
   }
   var msg="${msg}";
   if(msg!=null&&msg!=""&&msg!=undefined){
  	 alert(msg);
   }
   
  
</script>
</head>
<body>
   <%@ include file="banner.jsp" %>
   <%@ include file="navigation.jsp" %>
   
   <form action="checkManager.action" method="post" name="form1">
   <p align="center">图书管理员登入</p>
       <table align="center" height="300" cellpadding="0" cellspacing="0">
           <tr>
             <td align="center">
                                              管理员名称：<input name="managername" type="text">
             </td>
           </tr>
           <tr>
             <td align="center">
                                               管理员密码：    <input name="pwd" type="password">
             </td>
           </tr>
           <tr>
             <td align="center" >
               <input name="Submit" type="submit" value="确定" onclick="return check(form1)" > 
            
               <input name="Submit2" type="reset" value="重置">
             
               <input name="Submit3" type="button" value="关闭" onclick="window.close()">
             </td>
           </tr>
              
       </table>
   </form>
  
     <%@ include file="copyright.jsp" %>
   
</body>
</html>