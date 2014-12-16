<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/14
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title></title>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="Css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="Css/style.css"/>
  <script type="text/javascript" src="Js/jquery.js"></script>
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
<form action="add.do" method="post" class="definewidth m20">
  <table class="table table-bordered table-hover definewidth m10">
    <tr>
      <td width="10%" class="tableleft">姓名</td>
      <td><input type="text" name="name"/></td>
    </tr>
    <tr>
      <td class="tableleft">薪水</td>
      <td><input type="text" name="salary"/></td>
    </tr>
    <tr>
      <td class="tableleft">年龄</td>
      <td><input type="text" name="age"/></td>
    </tr>
    <tr>
      <td class="tableleft">状态</td>
      <td>
        <input type="radio" name="status" value="1" checked/> 启用
        <input type="radio" name="status" value="0"/> 禁用
      </td>
    </tr>
    <tr>
      <td class="tableleft"></td>
      <td>
        <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;

      </td>
    </tr>
  </table>
</form>
</body>
</html>
