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
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<!--validate验证表单插件-->
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
	<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
	<script src="../js/lTable.js" type="text/javascript"></script>

	<!-- 下拉选择框相关 CSS -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
	<!-- 下拉选择框相关 JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

	<base href="http://localhost:2333/">
	<!-- Custom CSS -->
	<link href="html/assets/css/style.css" rel="stylesheet" type="text/css" />
	<meta charset="UTF-8">
	<script type="text/javascript">
		window.onload = function () {
			//定时器每秒调用一次fnDate()
			setInterval(function () {
				fnDate();
			}, 1000);
		}
		//js 获取当前时间
		function fnDate() {
			var oDiv = document.getElementById("div");
			var date = new Date();
			var year = date.getFullYear();//当前年份
			var month = date.getMonth();//当前月份
			var data = date.getDate();//天
			var hours = date.getHours();//小时
			var minute = date.getMinutes();//分
			var second = date.getSeconds();//秒
			var time = year + "-" + fnW((month + 1)) + "-" + fnW(data) + " "
				+ fnW(hours) + ":" + fnW(minute) + ":" + fnW(second);
			oDiv.innerHTML = time;
		}
		//补位 当某个字段不是两位数时补0
		function fnW(str) {
			var num;
			str >= 10 ? num = str : num = "0" + str;
			return num;
		}
		function quit() {
			var r = confirm("您确定要退出登录吗？")
			if (r == true) {
				top.location.href = "http://localhost:2333/login";
			}
		}
		function index() {
			top.location.href = 'http://localhost:2333/html/main.html'
		}
	</script>
	<style>
		.hidden_exit {
			position: absolute;
			top: 0px;
			background-color: #ffffff;
			border-radius: 50%;
			display: none;
			z-index: 1000;
			text-align: center;
		}

		.exit {
			display: inline-block;
			padding-left: 5px;
		}

		.exit:hover .hidden_exit {
			display: block;
			border: 1px solid #dedede;
		}
	</style>
</head>

<body>
	<div id="main">
		<!-- top bar navigation -->
		<div class="headerbar">
			<!-- LOGO -->
			<div class="headerbar-left">
				<a href="javascript:index()" class="logo"><img alt="Logo" src="html/assets/images/logo.png" />
					<span>老人信息</span></a>
			</div>
			<nav class="navbar-custom">
				<ul class="list-inline float-right mb-0" style="float: right;">
					<li class="list-inline-item dropdown notif">
						<div id="div" class="nav-link"></div>
					</li>

					<li class="list-inline-item dropdown notif">
						<div class="dropdown">
							<div class="exit">
								<a href="javascript:void(0)" data-toggle="dropdown">
									<img src="${login.userImg}" alt="图片丢失了"
										style="border-radius: 50%;width: 36px;height: 36px; margin-bottom: 7px;">
								</a>
								<div class="hidden_exit">
									<div class="text_title"><a href="javascript:quit()">退出登录</a></div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</nav>

		</div>
		<!-- End Navigation -->
	</div>
</body>

</html>