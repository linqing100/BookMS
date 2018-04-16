<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Reader information</title>
<script>

function check(form){
	   if(form.readername.value==""){
		   alert("请输入姓名！");
		   form.readername.focus();
		   return false;
	   }
	   if(form.paperNO.value==""){
		   alert("请输入证件号码！");
		   form.paperNO.focus();
		   return false;      
	   }
	   if(form.tel.value==""){
		   alert("请输入联系电话！");
		   form.tel.focus();
		   return false;      
	   }
}


</script>
</head>
<body>
   <%@ include file="banner.jsp" %>
   <%@ include file="navigationlogin.jsp" %>
   <form action="insertReader.action" method="post" name="insertform" >
                
     <table align="center" height="400" cellpadding="0" cellspacing="0">     
        <tr> 
           <td >     
                                         姓名：<input type="text" name="readername" /> *<br>
           </td>
        </tr>
        <tr> 
           <td > 
                                         性别 ：
              <input type="radio" name="sex" value="male" >男
              <input type="radio" name="sex" value="female" >女
            </td>
        </tr>
        <tr> 
           <td >
                                         证件类型：<select name="paperType" >
                    <option value="身份证">身份证</option>
                    <option value="护照">护照</option>
                    </select>
           </td>
        </tr>
        <tr> 
           <td >
                                           证件号码：<input type="text" name="paperNO"/>*
           </td>
        </tr>
        <tr> 
           <td >
                                           出生日期：<input type="text" name="birthday"/>(格式：1990-09-09)
           </td>
        </tr>
          <tr> 
           <td > 
                                            联系电话：<input type="text" name="tel"/> *
            </td>
        </tr>
          <tr> 
           <td >
                                           邮箱：<input type="text" name="email"/>
           </td>
        </tr>
        <tr> 
           <td >
                                           读者编号：<input type="text" name="barcode"/>
           </td>
        </tr>
        <tr> 
           <td >
                                           读者类型： <select name="readerType" >
                   <option value="学生">学生</option>
                   <option value="在职人员">在职人员</option>
                   <option value="自由职业者">自由职业者</option>
                   </select>
           </td>
        </tr>
        <tr> 
           <td >
                                           备注：<input type="text" name="remark"/>
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
    <form action="ReaderPage.action?currentPage=1" method="post" >
      <input type="submit" value="返回"/><br>
   </form>
   </center>
   <%@ include file="copyright.jsp" %>
</body>
</html>