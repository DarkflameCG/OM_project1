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
            /* background-image: url(../images/menu/welcome.png); */
            background-color: #347754;
            background-size: 100%;
        }

        #msg {
            width: 100%;
            line-height: 40px;
            font-size: 14px;
            text-align: center;
        }
    </style>
    <script>
        function queding() {
            // 验证验证码是否正确
            var input_code = $('#input_code').val();
            // 从sessionStorage获取验证码
            var code = sessionStorage.getItem('code');
            // 从sessionStorage删除保存的验证码
            sessionStorage.removeItem('code');
            if (input_code === code) {
                // 验证码正确
               // var url ='http://localhost:2333/family/modifyPassword';
               // var formData = new FormData();
                // 将文件数据添加到表单数据中
               // formData.append("telphone","1345666");
                // formData.append("telphone", $('#telphone').val());
               // formData.append("familyPassword", $('#familyPassword').val());
               /*  var request = createCORSRequest('post', url);
                if (request) {
                    request.onload = function () {
                        if (request.status == 200) {
                            console.log('密码修改成功！')
                        } else {
                            console.log("密码修改失败！");
                        }
                    };
                    // 上传表单数据
                    request.send(formData);
                } */
            	 var obj = {};
                 obj.telphone = $('#telphone').val();
                 obj.familyPassword = $('#familyPassword').val();
                 var jsonStr = JSON.stringify(obj);
                 $.ajax({
                     //请求方式
                     type: "POST",
                     //请求的媒体类型
                     contentType: "application/json;charset=UTF-8",
                     //请求地址
                     url: "family/modifyPassword",
                     //数据，json字符串
                     data: jsonStr,
                     dataType: "text",
                     //请求成功
                     success: function (result) {
                         console.log(result);
                         if (result == "error") {
                             alert("手机号或密码错误，请重新输入!");
                             // 刷新页面来重置登录滑块
                             location.reload()
                         } else {
                             // 登录成功跳转到首页
                             window.location.href = "login_user"
                         }
                     },
                     //请求失败，包含具体的错误信息
                     error: function (e) {
                         console.log(e.status);
                         console.log(e.responseText);
                     }
                 });
            } else {
                // 验证码错误
                alert(444)

            }
        }
    </script>

</head>

<body>

    <div style="padding-top:10%">
        <div class="login-wrap">
            <div class="login-html" style="padding-top: 55px;">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked>
                <label for="tab-1" class="tab"></label>
                <input id="tab-2" type="radio" name="tab" class="sign-up">
                <label for="tab-2" class="tab"></label>
                <div class="login-form">
                    <form>
                        <div class="sign-in-htm">
                            <label class="tab">登录</label>

                            <!-- <div class="group">
                                <label for="user" class="label">老人编号</label>
                                <input id="username" name="username" value="admin" type="text" class="input">
                            </div> -->
                            <div class="group">
                                <label for="user" class="label">手机号</label>
                                <input id="username" name="username" value="admin" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">密码</label>
                                <input id="password" type="password" value="123456" class="input" data-type="password">
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
                                <input style="background: #347754;" type="button" class="button" value="登录" onclick="sub()">
                            </div>
                            <div class="hr"></div>
                            <div class="foot-lnk">
                                <!-- <input id="tab-2" type="radio" name="tab" class="sign-up"> -->
                                <!-- <a href="#forgot">忘记密码?</a> -->
                                <label for="tab-2" ">忘记密码？</label>
                            </div>
                        </div>
                    </form>
                    <form>
                        <div class=" sign-up-htm">
                                    <label for="tab-1" class="tab">修改密码</label>
                                    <!-- <div class="group">
                                        <label for="user" class="label">用户名</label>
                                        <input id="users" type="text" class="input">
                                    </div> -->
                                    <div class="group">
                                        <label for="pass" class="label">手机号</label>
                                        <input id="telphone" type="text" class="input" data-type="text" name="telphone">
                                    </div>
                                    <div class="group" style="white-space: nowrap;">
                                        <label for="pass" class="label">验证码</label>
                                        <input id="input_code" type="text" class="input" data-type="text"
                                            style="width: 70%;display: inline;">
                                        <button id="button_code" type="button" class="button"
                                            style="width: 29%;display: inline;text-align: center;background: #347754;">获取验证码</button>
                                    </div>
                                    <div class="group">
                                        <label for="pass" class="label">设置新密码</label>
                                        <input id="familyPassword" type="text" class="input" name="familyPassword">
                                    </div>
                                    <div class="group">
                                        <!-- <a href="register.html"> -->
                                        <input style="background: #347754;"  type="button" onclick="queding()" class="button" value="确定">
                                        <!-- </a> -->
                                    </div>
                                    <div class="hr"></div>
                                    <div class="foot-lnk">
                                        <label for="tab-1">使用账号?直接登录</a>
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
            obj.telphone = name;
            obj.familyPassword = pwd;
            var jsonStr = JSON.stringify(obj);
            $.ajax({
                //请求方式
                type: "POST",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url: "family/login",
                //数据，json字符串
                data: jsonStr,
                dataType: "text",
                //请求成功
                success: function (result) {
                    console.log(result);
                    if (result == "login") {
                        alert("电话号或密码错误，请重新输入!");
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
        // 获取短信验证码相关方法
        var input = document.querySelector('#input_code');
        var button = document.querySelector('#button_code');
        var count = 1;
        var that = this;
        button.onclick = function () {

            // 发送短信验证码业务逻辑
            // 获取手机号
            var phoneNum = $('#telphone').val();
            // alert('手机号：'+phoneNum);
            // 生成随机数字验证码
            var code = Math.floor(Math.random() * 10000);
            // 将验证码储存到session中
            sessionStorage.setItem('code', code);
            // 生成短信文本
            var text = '您好，您的验证码是：' + code + '，请不要告诉其他人，防止账号被盗。'
           console.log(text);
            // alert(text)
            // 调用后台发送短信接口
            that.sendMsg(phoneNum, text)
            // 发送短信验证码业务结束
            var This = this;
            // 禁用获取验证码button
             this.disabled = true;
            this.innerHTML = count + 's后重发';
            var timer = setInterval(function () {
                count--;
                if (count === -1) {
                    clearInterval(timer);
                    This.disabled = false;
                    This.innerHTML = '发送验证码';
                    count = 1;
                }
                else {
                    This.innerHTML = count + 's后重发';
                }
            }, 1000); 
        };
        function sendMsg(phoneNum, text) {
            // 表单数据对象
            var formData = new FormData();
            // 将文件数据添加到表单数据中
            formData.append("phoneNum", phoneNum);
            formData.append("text", text);
            var url = 'https://203.195.246.58:8890/User/getSmsCode';
            var request = createCORSRequest('post', url);
            if (request) {
                request.onload = function () {
                    if (request.status == 200) {
                        console.log('短信发送成功！')
                    } else {
                        console.log("短信发送失败！");
                    }
                };
                // 上传表单数据
                request.send(formData);
            }
        }
        function createCORSRequest(method, url) {
            var xhr = new XMLHttpRequest();
            if ("withCredentials" in xhr) {
                xhr.open(method, url, true);
            } else if (typeof XDmainRequest != "undefined") { //兼容IE
                xhr = new XDmainRequest();
                xhr.open(method, url, true);
            } else {
                xhr = null;
            }
            return xhr;
        }
    </script>
</body>

</html>