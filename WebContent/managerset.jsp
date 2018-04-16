<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javabean.Page" %>
<%@ page import="javabean.Manager" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员设置</title>
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
      
       <a href="insert.jsp">添加管理员信息</a> &nbsp;&nbsp;&nbsp;
    <input type="checkbox" id="all" onclick="changebox('c')"/>全选
     &nbsp;&nbsp;&nbsp;<a onclick="dele('c')">删除</a><br/><br/>
  

    <form action="searchManager.action" method="post">
      id:<input type="text" name="context"/>
      <input type="submit" value="搜索"/>
    </form>
   
   <table border="1" cellpadding="0,cellspacing=0" width="100%" height="80%">
         <tr align="center">
             <td>管理员ID</td>
             <td>管理员名称</td>
             <td>系统设置</td>
             <td>读者管理</td>
             <td>图书管理</td>
             <td>图书借还</td>
             <td>权限设置</td>
             <td>删除</td>
         </tr>
         <%List<Manager> currentList = (List<Manager>)request.getAttribute("currentList");
           for(int i=0;i<currentList.size();i++){ 
        	   Manager manager = currentList.get(i);
        	   int id = manager.getId();
        	   String name = manager.getName();
        	   int sysset = manager.getSysset();
        	   int readerset = manager.getReaderset();
        	   int bookset = manager.getBookset();
        	   int borrowback = manager.getBorrowback();
        	   %> <tr align="center">
           
             <td><input name="c" type="checkbox" value="c"/><%=id%></td>
              <td><%=name%></td>
           
                <td><input name = "sysset" type="checkbox" value="1" disabled="disabled" <%if(sysset==1){out.println("checked");} %>></td>
                 <td><input name = "readerset" type="checkbox"  value="1" disabled="disabled" <%if(readerset==1){out.println("checked");} %> ></td>
                 <td><input name = "bookset" type="checkbox"  value="1" disabled="disabled" <%if(bookset==1){out.println("checked");} %> ></td>
                 <td><input name = "borrowback" type="checkbox"  value="1" disabled="disabled" <%if(borrowback==1){out.println("checked");} %> ></td>
               
                <td>
       
                           <a href="editManager.action?id=<%=id%>">权限设置</a>
                 <td>
                    <a href="deleteManager.action?id=<%=id%>">删除</a>
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
		<a href="ManagerPage.action?currentPage=<%=i%>"><%=i %></a>
		<%
	}
	
	%> 

    
    
      <%@ include file="copyright.jsp" %>
</body>
</html>