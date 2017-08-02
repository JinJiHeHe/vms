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
    <style type="text/css">
        .BMap_cpyCtrl
        {
            display:none;
        }
        .anchorBL{
            display:none;
        }
    </style>
    <script src="http://api.map.baidu.com/api?v=2.0&ak=3ifW06URXxsYvbA9btjujrG8OoIb0fPQ" type="text/javascript"></script>
    <script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <title>布局</title>
</head>

<body class="easyui-layout">
<div data-options="region:'east',iconCls:'icon-reload',title:'车辆列表',split:true" style="width:250px;"></div>
<div data-options="region:'center',title:'地图监控'"  >
    <div class="easyui-layout" data-options="fit:true" >
        <div data-options="region:'center'," id="baidumap" ></div>
    <div data-options="region:'south',title:'监控列表',split:true" style="height:100px;"></div>
    </div>
</div>
<script type="text/javascript">
    var map = new BMap.Map("baidumap");          // 创建地图实例
    var point = new BMap.Point(116.404, 39.915);  // 创建点坐标
    map.centerAndZoom(point, 12);               // 初始化地图，设置中心点坐标和地图级别
    map.addControl(new BMap.NavigationControl());
    //map.setCurrentCity("南京");
</script>
</body>
</html>
