<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/10/30
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .BMap_cpyCtrl
        {
            display:none;
        }
        .anchorBL{
            display:none;
        }
        .baidumap{
            width:100%;height:100%;margin:auto;font-family:"微软雅黑";position:absolute;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <script type="text/javascript" src="../js/index.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'east',title:'车辆列表',split:false" style="width:250px;">

    <div id="aa" class="easyui-accordion" data-options="fit:true">
        <div title="实时监控"  >
            <input type="radio" name="state" checked="checked">所有
            <input type="radio" name="state">在线
            <input type="radio" name="state">行驶
            <div id="search">
                <select id="searchBox"   data-options="fit:true" ></select>
            </div>

            <ul id="groupTree"></ul>
        </div>
        <div title=""  style="padding:10px;">
            content2
        </div>
        <div title="Title3">
            content3
        </div>
    </div>

</div>

<div id="mainCenter" data-options="region:'center',split:false">
    <iframe id="monitor" width="100%" height="99%" frameborder="0"
            src="monitor.jsp" framespacing="0"
            noresize="noresize" border="0" class="model_iframe"
            name="monitor"></iframe>
</div>



<script type="text/javascript">
    jQuery(document).ready(function() {
        searchBox.init();
        groupTree.init();
        websockethandler.init();

    },100);

</script>
</body>
</html>
