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
        .baidumap{
            width:100%;height:100%;margin:auto;font-family:"微软雅黑";position:absolute;
        }


        /*公共头部样式*/
        .navheader{
            height:82px;
            overflow: hidden;
        }
        .headerinner{
            overflow: hidden;
            height:78px;
            box-sizing:border-box;
            position: relative;
            background: #333333;
            font-size: 14px;
            font-family: "微软雅黑";

        }
        /* 导航部分 */
        .headernav{
            overflow: hidden;
        }
        .headernav ul{
            list-style: none;
        }
        .headernav li{
            float: left;
            line-height: 50px;
            list-style: none;
        }
        .headernav li a{
            color: #fff;
            margin:0 12px;
            transition: 0.6s;
            -webkit-transition: 0.6s;
            -o-transition: 0.6s;
            -ms-transition: 0.6s;
            -moz-transition: 0.6s;
            cursor: pointer;
            text-decoration: none;

        }

        .headernav li a:hover{
            color: #747474;
        }

    </style>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <script type="text/javascript" src="../js/index.js"></script>
    <title>布局</title>
</head>

<body class="easyui-layout">
<div data-options="region:'north',split:false" class="navheader">
    <div class="headerinner" >
        <ul class="headernav">
            <li><a href="#">车俩监控</a></li>
            <li><a href="#" >车俩调度</a></li>
            <li><a href="#">视频监控</a></li>
            <li><a href="#" >报表分析</a></li>
            <li><a href="#" >信息管理</a></li>
            <li><a href="#" >系统管理</a></li>
        </ul>

    </div>
</div>


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

<div id="mainCenter" data-options="region:'center'">
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
