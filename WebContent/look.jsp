<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.Manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看管理员信息</title>
</head>
<body>
<% Manager manager = (Manager)request.getAttribute("manager");
   int sysset = manager.getSysset();
   int readerset = manager.getReaderset();
   int bookset = manager.getBookset();
   int borrowback = manager.getBorrowback();
   
   int id = manager.getId();
   String name = manager.getName();
   //System.out.println(id);
%>
<center>
   <table  border="1" cellpadding="0,cellspacing=0" width="80%" height="80%">
      <tr  >
             <td>管理员ID</td>
             <td>管理员名称</td>
             <td>系统设置</td>
             <td>读者管理</td>
             <td>图书管理</td>
             <td>图书借还</td>
             
     </tr>
     <tr>
              <td><%=id %></td>
             <td><%=name %></td>
              <td><input type="checkbox"  name="sysset" value="1" disabled="disabled" <%if(sysset==1){out.println("checked");} %> ></td>
                <td><input type="checkbox" name="readerset"  value="1" disabled="disabled" <%if(readerset==1){out.println("checked");} %> ></td>
                 <td><input type="checkbox" name="bookset" value="1" disabled="disabled" <%if(bookset==1){out.println("checked");} %> ></td>
                 <td><input type="checkbox" name="borrowback" value="1" disabled="disabled" <%if(borrowback==1){out.println("checked");} %> ></td>
                 
     </tr> 
   </table>
   <br>
   <form action="ManagerPage.action" method="post">
   <input type="submit" value="返回"/>
   </form>
   </center>
</body>
</html>