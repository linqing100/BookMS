<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javabean.Reader" %>
    <%@page import="javabean.Book" %>
    <%@page import="javabean.Borrow" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅</title>
<script >

function showCustomer(str)
{
  var xmlhttp;    
  if (str=="")
  {
    document.getElementById("txtHint").innerHTML="";
    return;
  }
  if (window.XMLHttpRequest)
  {
    // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp=new XMLHttpRequest();
  }
  else
  {
    // IE6, IE5 浏览器执行代码
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function()
  {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
      document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
  xmlhttp.open("GET","/php/borrow.php?q="+str,true);
  xmlhttp.send();
}

	 
function checkbook(form){
	if(form.context.value==""){
		 alert("请输入查询关键字！");
		 form.context.focus();
		 return false;
	 }
}
function checknumber(form){
	 if(form.number.value-form.borrowNumber.value<=0){
		 alert("您不能再借阅其他图书了！");
		 return false;
	 }
	 form.submit;
}


</script>
</head>
<body>
    <%@ include file="banner.jsp" %>
    <%@ include file="navigationlogin.jsp" %>
    
   
      
     <center>图书借阅</center>
     
     <table align="center" height="150" cellpadding="0" cellspacing="0" >
       <tr>
          <td>
                      <form name="checkform">
                                                           读者验证        读者条形码：<input type = "text" name="readerBarcode" >  
                            <input type = "submit" value="确定" onchange="checkreader(checkform) ">                 
                      </form>
          </td>
       </tr>
     </table>
<form action=""> 
<select name="customers" onchange="showCustomer(this.value)" style="font-family:Verdana, Arial, Helvetica, sans-serif;">
<option value="1">Apple Computer, Inc.</option>
<option value="2 ">BAIDU, Inc</option>
<option value="3">Canon USA, Inc.</option>

</select>
</form>
<br>
<div id="txtHint">读者信息将显示在这...</div> 

     <p>
      <div id="txtHint"><b>User info will be listed here.</b></div>
     
     
     <table align="center" height="50" cellpadding="0" cellspacing="0" >
         <tr>
          <td>
          <form action="searchBorrowByBook.action" method="post" name="checkbook">
                            图书条形码：<input type = "text" name="context">
          <input type = "submit" value="确定" onclick="return checkbook(checkbook)">
          </form>
          </td>
        </tr>
     </table>
     
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
              <td width="100"></td>
              <td width="100"></td>
              <td width="100"></td>
              <td width="100"></td>
              <td width="100"></td>
              <td width="100"></td>
            </tr>
          
          
         <tr>
         <td align="center">
          <form action="borrowBook.action" method="post" name="checknumber">
             <input type = "submit" value="完成借阅" >
          </form>
          </td>
         </tr>
       </table>
    
    <%@ include file="copyright.jsp" %>
</body>
</html>