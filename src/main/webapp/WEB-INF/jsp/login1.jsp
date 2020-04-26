<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>老人信息管理系统登录</title>

    <link rel="stylesheet" type="text/css" href="html/JS-login/css/styles.css">
    <link rel="stylesheet" href="html/JS-login/css/jigsaw.css">
    <script src="html/JS-login/js/jquery-1.11.0.min.js"></script>
    <style>
        html,
        body {
            width: 100%;
            height: 100%
        }

        body {
            background-image: url(../images/menu/welcome.png);
            background-size: 100%;
        }

        #msg {
            width: 100%;
            line-height: 40px;
            font-size: 14px;
            text-align: center;
        }
    </style>

</head>

<body>

    <div style="padding-top:100px">
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1"
                    class="tab">登录</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">注册</label>
                <div class="login-form">
                    <form>
                        <div class="sign-in-htm">
                            <div class="group">
                                <label for="user" class="label">用户名</label>
                                <input id="username" name="username" value="admin" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">密码</label>
                                <input id="password" type="password" value="123321" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <div class="container">
                                    <div id="captcha" style="position: relative" data-type="password"></div>
                                    <div id="msg"></div>
                                </div>
                            </div>
                            <br />
                            <!-- <div class="group">
                                <input id="check" type="checkbox" class="check" checked>
                                <label for="check"><span class="icon"></span> 保持登录</label>
                            </div> -->
                            <div class="group">
                                <input type="button" class="button" value="登录" onclick="sub()">
                            </div>
                            <div class="hr"></div>
                            <div class="foot-lnk">
                                <a href="#forgot">忘记密码?</a>
                            </div>
                        </div>
                    </form>
                    <form>
                        <div class="sign-up-htm">
                            <div class="group">
                                <label for="user" class="label">用户名</label>
                                <input id="users" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">密码</label>
                                <input id="passs" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">重复密码</label>
                                <input id="passs" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">邮箱地址</label>
                                <input id="pass" type="text" class="input">
                            </div>
                            <div class="group">
                                <a href="register.html"><input type="submit" class="button" value="注册"></a>
                            </div>
                            <div class="hr"></div>
                            <div class="foot-lnk">
                                <label for="tab-1">已有账号?直接登录</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="html/JS-login/js/jigsaw.js"></script>
    <script>
        var flag = false;
        function sub() {
            var userName = document.getElementById('username').value;
            var password = document.getElementById('password').value;
            if (flag == false) {
                alert("请向右拖动滑块填充拼图!")
                return;
            } else {
                // 滑块验证成功
                this.login(userName, password);
                return;
            }
        }
        function login(name, pwd) {
            //请求参数
            var obj = {};
            obj.userName = name;
            obj.password = pwd;
            var jsonStr = JSON.stringify(obj);
            $.ajax({
                //请求方式
                type: "POST",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url: "user/login",
                //数据，json字符串
                data: jsonStr,
                dataType: "text",
                //请求成功
                success: function (result) {
                    console.log(result);
                    if (result == "login") {
                        alert("用户名或密码错误，请重新输入!");
                        // 刷新页面来重置登录滑块
                        location.reload()
                    } else {
                        // 登录成功跳转到首页
                        window.location.href = "html/main.html"
                    }
                },
                //请求失败，包含具体的错误信息
                error: function (e) {
                    console.log(e.status);
                    console.log(e.responseText);
                }
            });
        }
        jigsaw.init(document.getElementById('captcha'), function () {
            flag = true;
            document.getElementById('msg').innerHTML = '验证成功！'
        })
    </script>


</body>

</html>