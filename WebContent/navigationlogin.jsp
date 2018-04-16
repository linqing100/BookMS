<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javabean.Manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login navigation</title>
 <style type="text/css">
           
             * {
                margin: 0px auto;
                padding: 0px;
            }
            
            #nav {
                width: 100px;
                background-color: blue;
                height: 40px;
                /*border-radius: 10px;*/
                position: relative;
                margin: 0px;
                top: 0px;
            }
            
            .nav-container {
                width: 100px;
                height: 40px;
                position: absolute;
            }
            
            .banner {
                
                text-align:top ;
                height: 40px;
                width: 80px;
                
            }
            
            .banner:hover {
                background-color: red;
                cursor: pointer;
            }
            
            div ul {
                list-style: none;
                /*display: none;*/
                background-color: white;
                overflow: hidden;
                /*模拟height:auto时候的情况*/                
                max-height: 0px;
                transition: max-height 0.3s;
                /*多浏览器支持*/
                -moz-transition: height 1s;
                -webkit-transition: height 1s;
                -o-transition: height 1s;
            }
            
            .banner:hover ul {
                /*display: block;*/
                width: 100%;
                max-height: 160px;
            }
            
            div ul li {
                overflow: hidden;
            }
            
            div ul li:hover {
                background-color: yellow;
            }
        </style>
</head>
<body>
   <table width="1000" height="40" border="0" align="center" cellpadding="0" cellspacing="0">
     <tr>
       <td width="64"><a href="index.jsp">首页|</a></td>
       <td width="64"><a href="ManagerPage.action">管理员设置|</a></td>
       <td width="64"><a href="ReaderPage.action">读者管理|</a></td>
       <td width="64"><a href="BookPage.action">图书管理|</a></td>
       <td width="64">
           <div class="nav-container">
            <div id="nav">
                <div id="nav-button-1" class="banner">图书借还|
                    <ul>
                        <li><a href="borrow.jsp">图书借阅</li>
                        <li><a href="renew.jsp">图书续借</li>
                        <li><a href="bookback.jsp">图书归还</li>
                        <li>4</li>
                    </ul>
                </div>
               
            </div>
        </div>
       </td>
       <td width="64"><a href="login.jsp">系统查询|</a></td>
       <td width="64"><a href="login.jsp">更改口令|</a></td>
       <td width="64">退出系统</td>
       <td align="right" width="74" name = "managername" value="${manager.name}">当前登录用户：${manager.name}</td>
     </tr>
    
   </table>
   
</body>
</html> 