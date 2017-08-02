<%--
  Created by IntelliJ IDEA.
  User: jakiro
  Date: 2017/3/26
  Time: 下午1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <title>布局</title>
</head>
<
<body class="easyui-layout">
<div data-options="region:'north',title:'North Title',split:true" style="height:100px;">1</div>
<div data-options="region:'south',title:'South Title',split:true" style="height:100px;">2</div>
<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;">3</div>
<div data-options="region:'west',title:'West',split:true" style="width:100px;">4</div>
<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">5</div>
</body>
</html>
