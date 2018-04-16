<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博阅图书管理系统</title>
</head>
<body>
   <%@ include file="banner.jsp" %>
   <%@ include file="navigation.jsp" %>
   <!-- 显示图书借阅排行榜 -->
   <table width="1000" height="400" border="0" align="center" cellpadding="0" cellspacing="0">
     <tr>
       <td  valign="top" style="padding:5px;">

                               <!--此处省略了显示图书借阅排行的代码-->
       <%@ include file="main.jsp" %> 
       </td>
      </tr>
   </table>
   <%@ include file="copyright.jsp" %>
	
</body>
</html>