<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.Manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑管理员信息</title>
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
         
          
     
     <p> 管理员信息：
     <form action="updateManager.action" method="post" id="form">
           <input type="hidden" name="id" value=<%=id%> ><br>      
               
         管理员名称：<input type="text" name="name" value=<%=name%>><br>
                
               
         拥有的权限：<br>
               
         系统设置 <input type="checkbox"  name="sysset" value="1" <%if(sysset==1){out.println("checked");} %> ><br>
         读者管理<input type="checkbox" name="readerset"  value="1" <%if(readerset==1){out.println("checked");} %> ><br>
         图书管理<input type="checkbox" name="bookset" value="1" <%if(bookset==1){out.println("checked");} %> ><br>
         图书借还<input type="checkbox" name="borrowback" value="1" <%if(borrowback==1){out.println("checked");} %> ><br>
              
               <input type="submit"  value="修改">
     </form>
     <form action="ManagerPage.action?currentPage=1" method="post">
               <input type="submit"  value="返回">
     </form>
                
        
          
</body>
</html>