<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.*" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn=ConnectionDB.getConnection();
if(conn==null){
	System.out.print("连接失败");
}else
{System.out.print("success");}
%>
  <input name="check" type="checkbox" checked="checked">旅游
  <%System.out.println(); %>
</body>
</html>