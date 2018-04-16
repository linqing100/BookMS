<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javabean.Reader" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑读者信息</title>
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
   
   <% 
   Reader reader = (Reader)request.getAttribute("reader");
   int id = reader.getId();
   String name = reader.getName();
   String sex = reader.getSex();
   String barcode = reader.getBarcode();
   String paperType = reader.getPaperType();
   String paperNO = reader.getPaperNO();
   String tel = reader.getTel();
   String email = reader.getEmail();
   String readerType = reader.getReaderType();
   String birthday = reader.getBirthday();
   String remark = reader.getRemark();
%>

    <form action="updateReader.action" method="post" name="updateform" >
                 <input type="hidden" name="id" value=<%=id%> ><br> 
     <table align="center" height="400" cellpadding="0" cellspacing="0">     
        <tr> 
           <td >     
                                         姓名：<input type="text" name="readername" value=<%=name %>> *<br>
           </td>
        </tr>
        <tr>
           <td > 
                                         性别 ：
              <input type="radio" name="sex" value="male" <%if(sex=="male"){out.println("checked");} %>>男
              <input type="radio" name="sex" value="female" <%if(sex=="female"){out.println("checked");} %>>女
            </td>
        </tr>
        <tr> 
           <td >
                                         证件类型：<select name="paperType" value=<%=paperType %>>
                    <option value="身份证">身份证</option>
                    <option value="护照">护照</option>
                    </select>
           </td>
        </tr>
        <tr> 
           <td >
                                           证件号码：<input type="text" name="paperNO" value=<%=paperNO %>>*
           </td>
        </tr>
        <tr> 
           <td >
                                           出生日期：<input type="text" name="birthday" value=<%=birthday %>>(格式：1990-09-09)
           </td>
        </tr>
          <tr> 
           <td > 
                                            联系电话：<input type="text" name="tel" value=<%=tel %>> *
            </td>
        </tr>
          <tr> 
           <td >
                                           邮箱：<input type="text" name="email" value=<%=email %>>
           </td>
        </tr>
        <tr> 
           <td >
                                           读者编号：<input type="text" name="barcode" value=<%=barcode %>>
           </td>
        </tr>
        <tr> 
           <td >
                                           读者类型： <select name="readerType" value=<%=readerType %> >
                   <option value="student">学生</option>
                   <option value="working">在职人员</option>
                   <option value="self-employed">自由职业者</option>
                   </select>
           </td>
        </tr>
        <tr> 
           <td >
                                           备注：<input type="text" name="remark" value=<%=remark %>>
           </td>
        </tr>
        <tr> 
           <td align="center">
                    <input type="submit" value="保存" onclick="return check(updateform)"/><br>
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
</html>s