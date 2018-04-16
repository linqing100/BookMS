<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅</title>
<script>
function check(form){
	   if(form.barcode.value==""){
		   alert("请输入读者条形码！");
		   form.barcode.focus();
		   return false;
	   }
	   
}
</script>
</head>
<body>
    <%@ include file="banner.jsp" %>
    <%@ include file="navigationlogin.jsp" %>
      
     <center>图书借阅查询</center><br>
     
     <center>
  <form action="BorrowSearch.action" method="post">
     <input type = "checkbox">请选择查询依据：
     <select>
         <option value="bookBarcode">图书条形码</option>
         <option value="readerBarcode">读者条形码</option>
     </select>
     
     <input type = "text" name="barcode"><br><br>
          <input type = "checkbox">借阅时间：
     从<input type = "text" name = "sdate">
     到<input type = "text" name = "edate">（日期格式为2017-09-09）
     <input type = "submit" value="查询">
  </form>
  </center>
     <table align="center" height="100" width="80%" border="1" cellpadding="0" cellspacing="0">
       
            <tr>
              <td width="100">图书条形码</td>
              <td width="100">图书名称</td>
              <td width="100">读者条形码</td>
              <td width="100">读者名称</td>
              <td width="100">借阅时间</td>
              <td width="100">应还时间</td>
              <td width="100">是否归还</td>
            </tr>
            <tr>
              <td width="100">图书名称</td>
              <td width="100">借阅时间</td>
              <td width="100">应还时间</td>
              <td width="100">出版社</td>
              <td width="100">书架</td>
              <td width="100">定价（元）</td>
             
                  
            </tr>
          
        
       </table>
    
    <%@ include file="copyright.jsp" %>
</body>
</html>