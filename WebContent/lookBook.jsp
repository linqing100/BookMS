<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看图书信息</title>
</head>
<body>
<% Book book = (Book)request.getAttribute("book");
   String bookname = book.getBookname();
   String author = book.getAuthor();
   String translator = book.getTranslator();
   String ISBN = book.getISBN();
   int typeid = book.getTypeid();
   Float price = book.getPrice();
   String bookpage = book.getBookpage();
   //String inTime = book.getInTime();
   //String operator = book.getOperator();
   String bookcase = book.getBookcase();
   int id = book.getId();
   
%>
<center>
   <table  border="1" cellpadding="0,cellspacing=0" width="80%" height="80%">
      <tr  >
             <td>图书ID</td>
             <td>图书名称</td>
             <td>图书类型</td>
             <td>作者</td>
             <td>译者</td>
             <td>出版社</td>
             <td>价格</td>
             <td>页码</td>
             <td>书架</td>
             
     </tr>
     <tr>
              <td><%=id %></td>
             <td><%=bookname %></td>
              <td><%=typeid %></td>
              <td><%=author %></td>
              <td><%=translator %></td>
              <td><%=ISBN %></td>
              <td><%=price %></td>
              <td><%=bookpage %></td>
              <td><%=bookcase %></td>
     </tr> 
   </table>
   <br>
   <form action="BookPage.action" method="post">
   <input type="submit" value="返回"/>
   </form>
   </center>
</body>
</html>