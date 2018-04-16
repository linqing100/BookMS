<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.Reader" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索读者信息</title>
</head>
<body>
<% Reader reader = (Reader)request.getAttribute("reader");
int id = reader.getId();
String name = reader.getName();
String sex = reader.getSex();
String barcode = reader.getBarcode();
String paperType = reader.getPaperType();
String paperNO = reader.getPaperNO();
String tel = reader.getTel();
String email = reader.getEmail();
String readerType = reader.getReaderType();
   
%>
<center>
   <table  border="1" cellpadding="0,cellspacing=0" width="100%" height="80%">
      <tr align="center" >
             <td>读者ID</td>
             <td>姓名</td>
             <td>性别</td>
             <td>读者编号</td>
             <td>证件类型</td>
             <td>证件号</td>
             <td>联系电话</td>
             <td>邮箱</td>
             <td>读者类型</td>
             <td>操作</td>
             
     </tr>
    <tr align="center">
           
             <td><input name="c" type="checkbox" value="c"/><%=id%></td>
                <td><%=name%></td>
                <td><%=sex%></td>
                <td><%=barcode%></td>
                <td><%=paperType%></td>
                <td><%=paperNO%></td>
                <td><%=tel%></td>
                <td><%=email%></td>
                <td><%=readerType%></td>
                <td>
                    <a href="editReader.action?barcode=<%=barcode%>">编辑</a>
                   
                    <a href="deleteReader.action?id=<%=id%>">删除</a>
                 </td>
            </tr>
   </table>
   <br>
   <form action="ReaderPage.action" method="post">
   <input type="submit" value="返回"/>
   </form>
   </center>
</body>
</html>