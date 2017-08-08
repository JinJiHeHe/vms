<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/4
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登入界面</title>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=3ifW06URXxsYvbA9btjujrG8OoIb0fPQ" type="text/javascript"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
</head>
<body class="easyui-layout">
    <div data-options="region:'center'">
        <form id="loginform" method="post" action="../user/login.do">
            <input id="username" type="text" style="width:200px" name="username"></br></br>
            <input id="password" type="text" style="width:200px" name="password"></br>
            <input type="submit" value="登入">
        </form>
    </div>

<script type="text/javascript">
    $('#username').textbox({
        iconCls:'icon-man',
        iconAlign:'left'
    })
    $('#password').textbox({
        iconCls:'icon-lock',
        iconAlign:'left'
    })
</script>
</body>
</html>
