<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javabean.Page" %>
<%@ page import="javabean.Reader" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者管理</title>
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
      
       <a href="insertReader.jsp">添加读者信息</a> &nbsp;&nbsp;&nbsp;
  
  

    <form action="searchReader.action" method="post">
                     读者编号:<input type="text" name="context"/>
      <input type="submit" value="搜索"/>
    </form>
  
   <table border="1" cellpadding="0,cellspacing=0" width="100%" height="80%">
         <tr align="center">
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
        
         <%List<Reader> currentList = (List<Reader>)request.getAttribute("currentList");
           for(int i=0;i<currentList.size();i++){ 
        	   Reader reader = currentList.get(i);
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
         <% 
           }
         
%>
         
                    
           
        
    </table>
   <%
	Page pa = (Page)request.getAttribute("page");
	int pageconut = pa.getPageCount();
	
	for(int i=1;i<=pageconut;i++){
		%>
		<a href="ReaderPage.action?currentPage=<%=i%>"><%=i %></a>
		<%
	}
	
	%> 

    
    
      <%@ include file="copyright.jsp" %>
</body>
</html>