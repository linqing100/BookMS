<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javabean.Reader" %>
    <%@page import="javabean.Book" %>
    <%@page import="javabean.BorrowBack" %>
    <%@page import="javabean.Page" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书归还</title>
<script>
function check(form){
	   if(form.readerBarcode.value==""){
		   alert("请输入读者条形码！");
		   form.readerBarcode.focus();
		   return false;
	   }
	   
}
var msg="${msg}";
if(msg!=null&&msg!=""&&msg!=undefined){
	 alert(msg);
}
</script>
</head>
<body>
    <%@ include file="banner.jsp" %>
    <%@ include file="navigationlogin.jsp" %>
      
      <%
       Reader reader = (Reader)request.getAttribute("reader");
      
      %>
     
     <center>图书归还</center>
     <table align="center" height="200" cellpadding="0" cellspacing="0">
       <tr>
          <td>
                      
                                                           读者验证        读者条形码：<input type = "text" name="context" value=<%=reader.getBarcode() %>>  
                            <input type = "submit" value="确定">                 
                      
          </td>
          <td>
          <form action="bookback.jsp" method="post">
                         <input type="submit" value="重新输入">                                               
                      </form>
          </td>
       </tr>
       
       <tr>
          <td>姓名：<input type = "text" name="readername" value=<%=reader.getName() %> >  </td>
          <td>性别：<input type = "text" name="sex" value=<%=reader.getSex() %> > </td>
          <td>读者类型：<input type = "text" name="readertype" value=<%=reader.getReaderType() %>> </td>
       </tr>
       <tr>
          <td>证件类型：<input type = "text" name="paperType" value=<%=reader.getPaperType() %>>  </td>
          <td>证件号码：<input type = "text" name="paperNO" value=<%=reader.getPaperNO() %>>  </td>
          <td>可借数量：<input type = "text" name="number" value=<%=reader.getNumber() %>> </td>
       </tr>
       
        </table>
        
          <table align="center" height="100" width="70%" cellpadding="0" cellspacing="0" border="1">
            <tr>
              <td width="100">图书名称</td>
              <td width="100">借阅时间</td>
              <td width="100">应还时间</td>
              <td width="100">出版社</td>
              <td width="100">书架</td>
              <td width="100">定价（元）</td>
              <td width="100">操作</td>
            </tr>
            <% List<BorrowBack> currentList = (List<BorrowBack>)request.getAttribute("currentList");
               
           for(int i=0;i<currentList.size();i++){ 
        	   BorrowBack borrowback = currentList.get(i);
        	   String borrowTime = borrowback.getBorrowTime();
        	   String backTime = borrowback.getBackTime();
        	   String bookname = borrowback.getBookname();
        	   String price = borrowback.getPrice();
        	   String ISBN = borrowback.getISBN();
        	   String bookcase = borrowback.getBookcase();
        	   String bookid = borrowback.getBookid();
        	   String readerid = borrowback.getReaderid();
           %>
        	   <tr>
              <td width="100"><%=bookname %></td>
              <td width="100"><%=borrowTime %></td>
              <td width="100"><%=backTime %></td>
              <td width="100"><%=ISBN %></td>
              <td width="100"><%=bookcase %></td>
              <td width="100"><%=price %></td>
              <td width="100">
                  <form action="deleteBorrow.action?bookid=<%=bookid%>&&readerid=<%=readerid %>" method="post">
                       <input type = "submit" value="归还">
                  </form>
              </td>
              
            </tr>
            <%} 
              %>
          
        
       </table>
        <%
	Page pa = (Page)request.getAttribute("page");
	int pageconut = pa.getPageCount();
	
	for(int i=1;i<=pageconut;i++){
		%>
		<a href="BorrowPage.action?currentPage=<%=i%>"><%=i %></a>
		<%
	}
	
	%> 
       
    
    <%@ include file="copyright.jsp" %>
</body>
</html>