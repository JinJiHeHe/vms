<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/27
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史轨迹</title>
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

    <script src="http://api.map.baidu.com/api?v=2.0&ak=3ifW06URXxsYvbA9btjujrG8OoIb0fPQ" type="text/javascript"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/LuShu/1.2/src/LuShu_min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript" src="../js/history.js"></script>
</head>
<body >
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center',border:false">
        <div >
            车牌号:<input id="id_num" type="text" style="width:100px">
        开始时间:<input id="start_time" type="text" class="easyui-datetimebox"  style="width: 170px">
                          &nbsp;-&nbsp;
        结束时间:<input id="end_time" type="text" class="easyui-datetimebox" style="width: 170px">
            <input  type="button" value="查询" onclick="baiduMap.queryHistory()">
            <input type="button" value="轨迹回放" onclick="baiduMap.onStart()">
            <input type="button" value="暂停" onclick="baiduMap.onPause()">
        <%--播放速度: <div id="velocity" class="easyui-slider"  data-options="showTip:true,rule:[0,'|',25,'|',50,'|',75,'|',100]" style="width:150px;">--%>
        <%--</div>--%>
        </div>

        <div id="baidumap" class="baidumap">

        </div>
    </div>
<div data-options="region:'south'" style="height:200px;">
    <table id="historyDataGrid" class="easyui-datagrid" >
        <thead>
        <tr>
            <th data-options="field:'gTime',width:'11.1%'">时间</th>
            <th data-options="field:'speed',width:'11.1%'">速度(Km/h)</th>
            <th data-options="field:'direction',width:'11.1%'">方向</th>
            <th data-options="field:'mileage',width:'11.1%'">里程(Km)</th>
            <th data-options="field:'alarmType',width:'11.1%'">报警类型</th>
            <th data-options="field:'locationName',width:'11.1%'">位置</th>
            <th data-options="field:'lon',width:'11.1%'">经度</th>
            <th data-options="field:'lat',width:'11.1%'">纬度</th>
            <th data-options="field:'uploadType',width:'11.1%'">数据点类型</th>
        </tr>
        </thead>
    </table>
</div>
</div>

<script type="text/javascript">
    jQuery(document).ready(function() {
        initDate();
        initTabs();
        historyGrid.init();
        baiduMap.init();
      //baiduMap.loadTrackByTime();

    },100);

</script>
</body>
</html>
