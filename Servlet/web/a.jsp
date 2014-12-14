<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/9
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>测试转发</title>
</head>
<body>
<%
//在jsp頁面中包含隱藏對象的,request,response直接使用
 String s= request.getAttribute("msg").toString();
%>
<p>
         <h2><%=s%></h2>
</p>
</body>
</html>
