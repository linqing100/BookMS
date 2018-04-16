<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javabean.Book" %>
    <%@page import="javabean.Borrow" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
        Book book = (Book)request.getAttribute("book");
        Borrow borrow = (Borrow)request.getAttribute("borrow");
        %>
          <table align="center" height="150" width="70%" cellpadding="0" cellspacing="0" border="1">
            <tr>
              <td width="100">图书名称</td>
              <td width="100">借阅时间</td>
              <td width="100">应还时间</td>
              <td width="100">出版社</td>
              <td width="100">书架</td>
              <td width="100">定价（元）</td>
            </tr>
            <tr>
              <td width="100"><%=book.getBookname() %></td>
              <td width="100"><%=borrow.getBorrowTime() %></td>
              <td width="100"><%=borrow.getBackTime() %></td>
              <td width="100"><%=book.getISBN() %></td>
              <td width="100"><%=book.getBookcase() %></td>
              <td width="100"><%=book.getPrice() %></td>
            </tr>
          
          
         <tr>
         <td align="center">
          <form action="borrowBook.action" method="post">
             <input type = "submit" value="完成借阅" >
          </form>
          </td>
         </tr>
       </table>
</body>
</html>