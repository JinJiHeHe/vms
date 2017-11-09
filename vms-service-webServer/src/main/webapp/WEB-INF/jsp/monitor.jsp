<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/26
  Time: 9:38
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
    <script src="http://api.map.baidu.com/api?v=2.0&ak=3ifW06URXxsYvbA9btjujrG8OoIb0fPQ" type="text/javascript"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <script type="text/javascript" src="../js/monitor.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'center'"  >
    <div class="easyui-layout" data-options="fit:true" >
        <div data-options="region:'center',fit:true" >

            <div id="maintab" class="easyui-tabs" data-options="fit:true">
                <div title="主页" style="padding: 0px;">

                    <div class="easyui-layout" data-options="fit:true">
                        <div data-options="region:'center',border:false">
                        <div id="baidumap" class="baidumap">
                        </div>

            </div>
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
                                    <div id="vehicleGrid" >
                                    </div>


                                    <div id="menu" class="easyui-menu" style="width: 50px; display: none;">
                                        <!--放置一个隐藏的菜单Div-->
                                        <div onclick="addTab('历史轨迹','history.jsp')">历史轨迹</div>
                                        <div onclick="">删除</div>
                                        <!--具体的菜单事件请自行添加，跟toolbar的方法是基本一样的-->
                                        <div onclick="">修改</div>
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
                </div>
        </div>


    </div>
</div>
<script type="text/javascript">
    jQuery(document).ready(function() {
        baiduMap.init();
        datagrid.init();
    },100);




</script>
</body>

</html>
