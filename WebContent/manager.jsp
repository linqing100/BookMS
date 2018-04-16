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
<title>图书管理员页面</title>
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
   <h2>=======================Manager Table=====================</h2>
    <a href="insert.jsp">新增</a> &nbsp;&nbsp;&nbsp;
    <input type="checkbox" id="all" onclick="changebox('c')"/>全选
     &nbsp;&nbsp;&nbsp;<a onclick="dele('c')">删除</a><br/><br/>
  

    <form action="searchManager.action" method="post">
      id:<input type="text" name="context"/>
      <input type="submit" value="搜索"/>
    </form>
  
   <table border="1" cellpadding="0,cellspacing=0" width="100%" height="80%">
         <tr>
             <td> id</td>
             <td>name</td>
             <td>pwd</td>
             <td>sysset</td>
             <td>readerset</td>
             <td>bookset</td>
             <td>borrowback</td>
             <td>操作</td>
         </tr>
         <c:forEach items="${currentList}" var="res">
            <tr>
             <td><input name="c" type="checkbox" value="${res.id}"/>${res.id}</td>
              <td>${res.name}</td>
               <td>******</td>
                <td>${res.sysset}</td>
                 <td>${res.readerset}</td>
                 <td>${res.bookset}</td>
                 <td>${res.borrowback}</td>
                <td>
                    <table>
                       <tr>
                           <td><a href="deleteManager.action?id=${res.id}">删除</a></td>
                           <td><a href="editManager.action?id=${res.id}">编辑</a></td>
                           <td><a href="lookManager.action?id=${res.id}" >查看</a></td>
                       </tr>
                    </table> 
                 </td>
            </tr>
         </c:forEach>
        
    </table>
  
	
  
	
</body>
</html>