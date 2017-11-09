<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/10/30
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面框架</title>
    <style type="text/css">
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
        .userinfo{
            color: #fff;
            float: right !important;
            margin-right: 100px;
        }
  .mm{
      background: #333333;
      font-size: 14px;
      font-family: "微软雅黑";

  }
    .userImage{ margin:10px auto}
    .userImage img{ border-radius:50%}

    </style>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/icon.css" type="text/css">
    <link rel="stylesheet" href="../js/jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css">
    <script type="text/javascript" src="../js/index.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false" class="navheader">
    <div class="headerinner" >
        <ul class="headernav">
            <li><a onclick="changeJsp('monitor_main.jsp')">车俩监控</a></li>
            <li><a onclick="changeJsp('')" >车俩调度</a></li>
            <li><a onclick="changeJsp('')">视频监控</a></li>
            <li><a onclick="changeJsp('formReport.jsp')">报表分析</a></li>
            <li><a onclick="changeJsp('')">信息管理</a></li>
            <li><a onclick="changeJsp('')">系统管理</a></li>
            <li class="userinfo">
               <div class="userImage">
                   <img src="../image/5.png">
                    <a id="username" class="username">用户名</a>
                     <div class="mm" id="mm" style="width:150px;">
                       <div data-options="iconCls:'icon-undo'">Undo</div>
                       <div data-options="iconCls:'icon-redo'">Redo</div>
                       <div class="menu-sep"></div>
                       <div>Cut</div>
                       <div>Copy</div>
                       <div>Paste</div>
                       <div class="menu-sep"></div>
                       <div data-options="iconCls:'icon-remove'">Delete</div>
                       <div>Select All</div>
                   </div>
                   </div>



            </li>
        </ul>

    </div>
</div>
<div data-options="region:'center',split:false">
    <div data-options="fit:true">
    <iframe src="monitor_main.jsp" height="100%"  width="100%"  scrolling="no" frameborder="0"  marginheight="0" marginwidth="0"  ></iframe>
    </div>
</div>
<script type="text/javascript">
    function changeJsp(jsp){
        $('iframe').attr("src",jsp);
    }
    jQuery(document).ready(function() {
         $("#username").menubutton({
             menu:"#mm"
         })

    },100);
</script>
</body>
</html>
