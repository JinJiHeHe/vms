<%--
  Created by IntelliJ IDEA.
  User: gaop
  Date: 2017/8/7
  Time: 11:55
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
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <script type="text/javascript" src="../js/index.js"></script>
    <title>布局</title>
</head>

<body class="easyui-layout">
<div data-options="region:'east',title:'车辆列表',split:true" style="width:250px;">

    <div id="aa" class="easyui-accordion" data-options="fit:true">
        <div title="实时监控"  >
           <input type="radio" name="state" checked="checked">所有
           <input type="radio" name="state">在线
            <input type="radio" name="state">行驶
            <div id="search">
                <select  class="easyui-combobox"  data-options="fit:true"  placeholder="请输入车牌号"></select>
            </div>

            <ul id="groupTree"></ul>
        </div>
        <div title="Title2"  style="padding:10px;">
            content2
        </div>
        <div title="Title3">
            content3
        </div>
    </div>

</div>
<div data-options="region:'center',title:'地图监控'"  >
    <div class="easyui-layout" data-options="fit:true" >
        <div data-options="region:'center'," id="baidumap" ></div>

    <div data-options="region:'south',title:'监控列表',split:true" style="height:200px;">

        <div id="tt" class="easyui-tabs" data-options="fit:true">
            <div title="实时监控" style="padding:20px;display:none;">
                <div id="queryOptions">
               单位: <input class="easyui-textbox" data-options="type:'text'" style="height: 17px;width:100px;" />
                车牌号:<input class="easyui-textbox" data-options="type:'text'" style="height:17px;width:100px;" />
                SIM卡号:<input class="easyui-textbox" data-options="type:'text'" style="height:17px;width:100px;" />
                终端号:<input class="easyui-textbox" data-options="type:'text'" style="height:17px;width:100px;" />
                终端类型:<select id="terminalType" class="easyui-combobox"  style="width:100px">
                <option>部标</option>
                <option>欧亚</option>
                <option>易特</option>
            </select>
                在线状态:<select id="state" class="easyui-combobox"  style="width:200px;;width:100px;">
                <option>全部</option>
                <option>行驶中</option>
                <option>离线</option>
                <option>停车</option>
                <option>未曾上线</option>
            </select>
                    <a  href="#" class="easyui-linkbutton">查询</a>
                    <a  href="#" class="easyui-linkbutton">清空</a>
                </div>
                <div id="datagrid" >
                    <table class="easyui-datagrid"
                           data-options="url:'',singleSelect:true" >
                        <thead>
                        <tr>
                            <th field="ck" checkbox="true"></th>
                            <th data-options="field:'orgid',width:100">所属单位</th>
                            <th data-options="field:'vehicleNo',width:100">车号</th>
                            <th data-options="field:'color',width:100">车牌颜色</th>
                            <th data-options="field:'time',width:100">时间</th>
                            <th data-options="field:'warnSpeed',width:100">预警速度</th>
                            <th data-options="field:'speed',width:100">速度</th>
                            <th data-options="field:'limitSpeed',width:100">限速(Km/h)</th>
                            <th data-options="field:'state',width:100">车辆状态</th>
                            <th data-options="field:'direction',width:100">方向</th>
                            <th data-options="field:'mileage',width:100">当日里程</th>
                            <th data-options="field:'totalMileage',width:100">累计里程</th>
                            <th data-options="field:'lon',width:100">经度</th>
                            <th data-options="field:'lat',width:100">纬度</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div title="实时报警"  style="overflow:auto;padding:20px;display:none;">

            </div>
            <div title="巡查督办"  style="padding:20px;display:none;">

            </div>
        </div>

    </div>
    </div>
</div>
<script type="text/javascript">
    var map = new BMap.Map("baidumap");          // 创建地图实例
    var point = new BMap.Point(116.404, 39.915);  // 创建点坐标
    map.centerAndZoom(point, 12);               // 初始化地图，设置中心点坐标和地图级别
    map.addControl(new BMap.NavigationControl());
    map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
    map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
    jQuery(document).ready(function() {
        groupTree.init();
    },100);

</script>
</body>
</html>
