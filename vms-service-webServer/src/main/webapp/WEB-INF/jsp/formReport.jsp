<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/11/6
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        html{
            font-size:62.5%; /* 10÷16=62.5% */}
        body{
            font-size:12px;
            font-size:1.2rem;
            background:#F8F8F8;
            font-family:"宋体";}
        ul{
            width:180px;
            margin:0 auto;
            background:#fff;
            position:relative;
            z-index:0;
            padding:60px 20px 70px;}
        ul li{
            height:40px;
            line-height:40px;
            text-align:center;
            border-bottom:1px solid #F8F8F8;}
        .mainlist ul li a{
            color:#666;
            display:block;}
        ul li a:hover{
            color:#FF5F3E;
            text-decoration:none;}
        ul li a.hover{color:#FF5F3E;}
    </style>
    <title>报表分析</title>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <script type="text/javascript" src="../js/echarts.min.js"></script>
    <link href="../css/basic.css" rel="stylesheet" type="text/css">
    <script src="../js/formReport.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'east',split:false" style="width:15%" class="mainlist">
    <ul>
        <li><a href="">里程统计</a></li>
        <li><a href="">报警统计</a></li>
        <li><a href="">车辆分布统计</a></li>
        <li><a href="">终端统计</a></li>
    </ul>
</div>
<div data-options="region:'center',split:false" >
    <div>ahha
    </div>
</div>

</body>
</html>
