<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书续借</title>
<script>
function check(form){
	   if(form.readerBarcode.value==""){
		   alert("请输入读者条形码！");
		   form.readerBarcode.focus();
		   return false;
	   }
	   
}
</script>
</head>
<body>
    <%@ include file="banner.jsp" %>
    <%@ include file="navigationlogin.jsp" %>
      
     <center>图书续借</center>
     <table align="center" height="200" cellpadding="0" cellspacing="0">
       <tr>
          <td>
                      <form action="BorrowPage.action" method="post" name="searchBorrowByReader">
                                                           读者验证        读者条形码：<input type = "text" name="context">  
                            <input type = "submit" value="确定" onclick="return check(searchBorrowByReader)">                 
                      </form>
          </td>
       </tr>
       
       <tr>
          <td>姓名：<input type = "text" name="readername">  </td>
          <td>性别：<input type = "text" name="sex">  </td>
          <td>读者类型：<input type = "text" name="readertype">  </td>
       </tr>
       <tr>
          <td>证件类型：<input type = "text" name="paperType">  </td>
          <td>证件号码：<input type = "text" name="paperNO">  </td>
          <td>可借数量：<input type = "text" name="number">  </td>
       </tr>
       
        </table>
        
          
    <%@ include file="copyright.jsp" %>
</body>
</html>