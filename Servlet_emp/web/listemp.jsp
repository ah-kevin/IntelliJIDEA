<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/14
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="entity.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="Css/style.css"/>
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>


    <style type="text/css">
        body {
            padding-bottom: 40px;
        }

        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">
    用户名称：
    <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
    &nbsp;&nbsp;
    <button type="button" class="btn btn-success" id="addnew" onclick="location='addEmp.jsp'">新增用户</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>薪水</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    </thead>
    <%
        //重request中取绑定的数据
        List<Employee> emps=(List<Employee>)request.getAttribute("allEmp");
        //显示数据
        for (int i=0;i<emps.size();i++){
            Employee e =emps.get(i);

    %>
    <tr>
        <td>
            <%=e.getId()%>
        </td>
        <td>
            <%=e.getName()%>
        </td>
        <td><%=e.getSalary()%></td>
        <td><%=e.getAge()%></td>
        <td>
            <a href="load.do?id=<%=e.getId()%>">编辑</a>&nbsp;&nbsp;
            <a href="del.do?id=<%=e.getId()%>" onclick="return confirm('确认删除<%=e.getName()%>吗?')">删除</a>
        </td>
    </tr>
    <% }%>
</table>
</body>
</html>
<script>
    $(function () {


        $('#addnew').click(function () {

            window.location.href = "addEmp.jsp";
        });


    });

    function del(id) {


        if (confirm("确定要删除吗？")) {

            var url = "index.html";

            window.location.href = url;

        }


    }
</script>