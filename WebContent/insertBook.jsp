<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert book information</title>
<script>
function add(){
	$.ajax({
		  type: 'POST',
		  url: url,
		  data: $("#form").serialize(),
		  success: function(result){
			  //result
		  },
		  dataType: "json"
		});
}
function check(form){
	   if(form.bookname.value==""){
		   alert("请输入图书名称！");
		   form.bookname.focus();
		   return false;
	   }
	   if(form.price.value==""){
		   alert("请输入价格！");
		   form.price.focus();
		   return false;      
	   }
}


</script>
</head>
<body>
   <%@ include file="banner.jsp" %>
   <%@ include file="navigationlogin.jsp" %>
   <form action="insertBook.action" method="post" name="insertform" >
                
     <table align="center" height="400" cellpadding="0" cellspacing="0">     
        <tr> 
           <td >     
                                         图书名称：<input type="text" name="bookname" /> *<br>
           </td>
        </tr>
        <tr> 
           <td > 
                                         图书类型 ：<select name="typeid" >
             <option value="1">编程</option>
             <option value="2">文学</option>
              </select>
            </td>
        </tr>
        <tr> 
           <td >  
                                         作者：<input type="text" name="author"/> 
            </td>
        </tr>
        <tr> 
           <td >
                                           译者：<input type="text" name="translator"/>
           </td>
        </tr>
        <tr> 
           <td >
                                            出版社：<select name="ISBN" >
                    <option value="1">人民邮电出版社</option>
                    <option value="2">中南出版社</option>
                    </select>
           </td>
        </tr>
          <tr> 
           <td > 
                                             价格：<input type="text" name="price"/> *
            </td>
        </tr>
          <tr> 
           <td >
                                           页码：<input type="text" name="bookpage"/>
           </td>
        </tr>
        <tr> 
           <td >
                                           书架： <select name="bookcase" >
                   <option value="左A-1">左A-1</option>
                   <option value="右A-1">右A-1</option>
                   <option value="左B-1">左B-1</option>
                   <option value="右B-1">右B-1</option>
                   </select>
           </td>
        </tr>
        <tr> 
           <td align="center">
                    <input type="submit" value="保存" onclick="return check(insertform)"/><br>
           </td>
        </tr >        
      </table>
   </form>
   <center>
    <form action="BookPage.action?currentPage=1" method="post" >
      <input type="submit" value="返回"/><br>
   </form>
   </center>
   <%@ include file="copyright.jsp" %>
</body>
</html>