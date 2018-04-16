<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javabean.Page" %>
<%@ page import="javabean.Book" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>
<script type="text/javascript">
 
 
 var msg="${msg}";
 if(msg!=null&&msg!=""&&msg!=undefined){
	 alert(msg);
 }
 


 
 function changebox(obj){
	var choose=document.getElementById("all");
	var echoose=document.getElementsByName(obj)
	if(choose.checked){
		for(var i=0;i<echoose.length;i++)
			echoose[i].checked=true;
	}else{
		for(var i=0;i<echoose.length;i++)
			echoose[i].checked=false;
	}
 }
 
 function dele(obj){
	 var choose=document.getElementsByName(obj);
	 var idAll="";
	 for(var i=0;i<choose.length;i++){
		 if(choose[i].checked){
			 idAll+=choose[i].value+","
		 } 
	 }
	if(idAll==""){
		alert("no select....");
		return false;
	}else{
		document.location.href="deleteServal.action?idAll="+idAll;
	}
 }
 
 
 </script>
</head>
<body>

<%@ include file="banner.jsp" %>
      <%@ include file="navigationlogin.jsp" %>
      
       <a href="insertBook.jsp">添加图书信息</a> &nbsp;&nbsp;&nbsp;
    <input type="checkbox" id="all" onclick="changebox('c')"/>全选
     &nbsp;&nbsp;&nbsp;<a onclick="dele('c')">删除</a><br/><br/>
  

    <form action="searchBook.action" method="post">
      id:<input type="text" name="context"/>
      <input type="submit" value="搜索"/>
    </form>
  
   <table border="1" cellpadding="0,cellspacing=0" width="100%" height="80%">
         <tr align="center">
             <td>图书ID</td>
             <td>图书名称</td>
             <td>图书类型</td>
             <td>出版社</td>
             <td>书架</td>
             <td>操作</td>
             
             
         </tr>
        
         <%List<Book> currentList = (List<Book>)request.getAttribute("currentList");
           for(int i=0;i<currentList.size();i++){ 
        	   Book book = currentList.get(i);
        	   String bookname = book.getBookname();
        	   //String author = book.getAuthor();
        	  // String translator = book.getTranslator();
        	   String ISBN = book.getISBN();
        	   int typeid = book.getTypeid();
        	   //Float price = book.getPrice();
        	  // String bookpage = book.getBookpage();
        	   //String inTime = book.getInTime();
        	   //String operator = book.getOperator();
        	   String bookcase = book.getBookcase();
        	   int id = book.getId();
        	   %> <tr align="center">
           
             <td><input name="c" type="checkbox" value="c"/><%=id%></td>
              <td><%=bookname%></td>
           
                <td><%=typeid%></td>
                <td><%=ISBN%></td>
                <td><%=bookcase%></td>
                
                <td>
       
                    <a href="editBook.action?id=<%=id%>">编辑</a>
                    <a href="lookBook.action?id=<%=id%>">查看</a>
                    <a href="deleteBook.action?id=<%=id%>">删除</a>
                 </td>
            </tr>
         <% 
           }
         
%>
         
                    
           
        
    </table>
   <%
	Page pa = (Page)request.getAttribute("page");
	int pageconut = pa.getPageCount();
	
	for(int i=1;i<=pageconut;i++){
		%>
		<a href="BookPage.action?currentPage=<%=i%>"><%=i %></a>
		<%
	}
	
	%> 

    
    
      <%@ include file="copyright.jsp" %>
</body>
</html>