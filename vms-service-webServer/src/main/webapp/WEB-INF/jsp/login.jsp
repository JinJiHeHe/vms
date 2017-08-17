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
<style type="text/css">

    *{
        margin: 0;
        padding: 0;
    }
    body{
        font-family: "微软雅黑";
        font-size: 14px;
        background: url("/vms/image/1.jpg") fixed center center;
    }
    .login_box{
        width: 280px;
        height: 400px;
        padding: 35px;
        color: #EEE;
        position: absolute;
        left: 50%;
        top: 100px;
        margin-left: -175px;
    }
    .input_outer {
        height: 46px;
        padding: 0 5px;
        margin-bottom: 20px;
        border-radius: 50px;
        position: relative;
        border: rgba(255,255,255,0.2) 2px solid !important;
    }
    .text{
        width: 220px;
        height: 46px;
        outline: none;
        display: inline-block;
        font: 14px "microsoft yahei",Helvetica,Tahoma,Arial,"Microsoft jhengHei";
        margin-left: 50px;
        border: none;
        background: none;
        line-height: 46px;
    }
    .btn {
        margin-bottom: 20px;
    }
    .act-but {
        height: 20px;
        line-height: 20px;
        text-align: center;
        font-size: 20px;
        border-radius: 50px;
        background: #0096e6;
    }
    .submit {
        padding: 15px;
        margin-top: 20px;
        display: block;
    }
    .u_user {
        width: 25px;
        height: 25px;
        background: url(/vms/image/login_ico.png);
        background-position-x: 0%;
        background-position-y: 0%;
        background-position: -125px 0;
        position: absolute;
        margin: 12px 13px;
    }
    .u_psw{
        width: 25px;
        height: 25px;
        background-image: url(/vms/image/login_ico.png);
        background-position: -125px -34px;
        position: absolute;
        margin:12px 13px;
    }
    .l-login {
        position: absolute;
        z-index: 1;
        left: 50px;
        top: 0;
        height: 46px;
        font: 14px "microsoft yahei",Helvetica,Tahoma,Arial,"Microsoft jhengHei";
        line-height: normal;
        line-height: 46px;
    }
    a{text-decoration : none}
</style>
</head>
<body >
    <div class="login_box" >
        <form id="loginform" method="post" action="../user/login.do">
            <div class="input_outer">
                <span class="u_user"></span>
                <input id="username" class="text"  onfocus=" if(this.value=='输入用户名') this.value=''" onblur="if(this.value=='') this.value='输入用户名'" value="输入用户名" style="color: #FFFFFF !important" name="username" autocomplete="off">
            </div>
            <div class="input_outer">
                <span class="u_psw"></span>
                <label class="l-login login_password" style="color: rgb(255, 255, 255);display: block;">输入密码</label>
                <input id="password"name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" onfocus="$('.login_password').hide()" onblur="if(this.value=='')  $('.login_password').show()" value="" type="password">
            </div>
            <div class="btn">
                <a id="act-a" class="act-but submit" onclick="javascript:login();" style="color: #FFFFFF">登录</a>
            </div>

        </form>
    </div>

<script type="text/javascript">
function login() {
    var usernmae=$('#username').val();
    var password=$('#password').val();
document.getElementById("act-a").href="../user/login.do?username="+usernmae+"&password="+password;
}
</script>
</body>
</html>
