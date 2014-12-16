<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/15
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title></title>
</head>
<body>
<%
  String ms =request.getAttribute("msg").toString();
%>
<h1><%=ms%></h1>
</body>
</html>
