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
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<base href="<%=basePath%>">
		<title>老人信息管理系统</title>
		<meta name="description" content="老人管理系统">
		

		<!-- Favicon -->
		<link rel="shortcut icon" href="/static/assets/images/favicon.ico">
        <link href="https://at.alicdn.com/t/font_1411447_zhf55y3egs.css" rel="stylesheet">
		<!-- Bootstrap CSS -->
		<link href="/static/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Font Awesome CSS -->
		<link href="/static/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		
		<!-- Custom CSS -->
		<link href="/static/assets/css/style.css" rel="stylesheet" type="text/css" />
		
		<!-- BEGIN CSS for this page -->
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
        <link rel="stylesheet" href="/static/iconfont/iconfont.css">
		<!-- END CSS for this page -->
		<script src="/static/js/index.js"></script>
        <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</head>

<body class="adminbody">

<div id="main">

	<!-- top bar navigation -->
	<div class="headerbar">

		<!-- LOGO -->
        <div class="headerbar-left">
			<a href="index.jsp" class="logo"><img alt="Logo" src="/static/assets/images/logo.png" /> <span>老人信息</span></a>
        </div>

        <nav class="navbar-custom">

                    <ul class="list-inline float-right mb-0">
                        <li class="list-inline-item dropdown notif">
                            <a class="nav-link dropdown-toggle nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <img src="${login.userImg }" alt="图片迷路了。。。" class="avatar-rounded">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                                <!-- item-->
                                <div class="dropdown-item noti-title">
                                    <h5 class="text-overflow"><small>${login.userName }</small> </h5>
                                </div>
                                <!-- item-->
                                <a id="owner" href="" class="dropdown-item notify-item">
                                    <i class="fa fa-user"></i> <span>个人中心</span>
                                </a>
                                <!-- item-->
                                <a href="login.html" class="dropdown-item notify-item">
                                    <i class="fa fa-power-off"></i> <span>退出登录</span>
                                </a>
                            </div>
                        </li>

                    </ul>

                    <ul class="list-inline menu-left mb-0">
                        <li class="float-left">
                            <button class="button-menu-mobile open-left">
								<i class="fa fa-fw fa-bars"></i>
                            </button>
                        </li>                        
                    </ul>

        </nav>

	</div>
	<!-- End Navigation -->
	
 
	<!-- Left Sidebar -->
	<div class="left main-sidebar">
	
		<div class="sidebar-inner leftscroll">

			<div id="sidebar-menu">
        
			<ul>

					<li class="submenu">
						<a  href="#"><i class="fa fa-fw fa-bars"></i><span>首页</span> </a>
                    </li>

					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-area-chart"></i><span>员工信息</span> </a>
                    </li>
					
					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-table"></i> <span>员工考勤</span></a>
                    </li>
										
                    <li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-tv"></i> <span>老人信息</span> </a>
                    </li>

					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-file-text-o"></i> <span>老人事件</span> </a>
                    </li>
					
                    <li class="submenu">
						<a href="#"><i class="fa fa-fw fa-th"></i> <span>床位管理</span></a>
    
                    </li>

					<li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-image"></i> <span>财务管理</span> <span class="menu-arrow"></span></a>
							<ul class="list-unstyled">
								
								<li><a href="#">收费设置</a></li>
								<li><a href="#">账单记录</a></li>
								<li><a href="#">员工工资</a></li>
								
							</ul>
                    </li>
					
                    <li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-image"></i> <span>基本设置</span> <span class="menu-arrow"></span></a>
                            <ul class="list-unstyled">								
                                <li><a target="_blank" href="#">用户管理</a></li>								
                                <li><a href="#">角色管理</a></li>                        
								<li><a href="#">权限管理</a></li>								
                            </ul>
                    </li>
            </ul>

            <div class="clearfix"></div>

			</div>
        
			<div class="clearfix"></div>

		</div>

	</div>
	<!-- End Sidebar -->


    <div class="content-page">
	
		<!-- Start content -->
        <div class="content">
        </div>
    </div>
	<!-- END content-page -->
    
	<footer class="footer">
		<span class="text-right">
		Copyright <a target="_blank" href="#">hello</a>
		</span>
		<span class="float-right">
            老人的详细信息管理系统
		</span>
	</footer>

</div>
<!-- END main -->

<script src="/static/assets/js/modernizr.min.js"></script>
<script src="static/assets/js/jquery.min.js"></script>
<script src="/static/assets/js/moment.min.js"></script>
		
<script src="/static/assets/js/popper.min.js"></script>
<script src="/static/assets/js/bootstrap.min.js"></script>

<script src="/static/assets/js/detect.js"></script>
<script src="/static/assets/js/fastclick.js"></script>
<script src="/static/assets/js/jquery.blockUI.js"></script>
<script src="/static/assets/js/jquery.nicescroll.js"></script>

<!-- App js -->
<script src="/static/assets/js/pikeadmin.js"></script>

<!-- BEGIN Java Script for this page -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

	<!-- Counter-Up-->
	<script src="/static/assets/plugins/waypoints/lib/jquery.waypoints.min.js"></script>
	<script src="/static/assets/plugins/counterup/jquery.counterup.min.js"></script>			
	<script>
		$(document).ready(function() {
			// data-tables
			
			<c:if test="${index==null }">
			
            $('.content').load('/pages/home.html');
			</c:if>
			<c:if test="${index==1 }">
			<c:if test="${currpage==null }">
            $('.content').load('user/selectPower',{"currpage":1});
            </c:if>
			<c:if test="${currpage!=null }">
			<c:if test="${select==null }">
            $('.content').load('user/selectPower',{"currpage":${currpage}});
			</c:if>
			<c:if test="${select!=null }">
            $('.content').load('user/selectindex');
			</c:if>
            </c:if>
			</c:if>
			$('#example1').DataTable();
					
			// counter-up
			$('.counter').counterUp({
				delay: 10,
				time: 600
			});
           
            // $('#index').click(function(){
            //     $('.wrapper').load('./pages/waiter.html');
            // })
		} );		
        $(function(){
            $('#sidebar-menu>ul li>a').click(function(e){
                e.preventDefault();
                // $(e.target.offsetParent).addClass('active')
                // $(e.target.offsetParent.offsetParent).siblings().removeClass('active')
                if(e.target.innerText == '首页'){
                    //console.log("aaaaaaaaaaaaaaaaaaaaaa")
                    $('.content').load('/pages/home.html');
                }else if(e.target.innerText == '员工信息'){
                    $('.content').load('user/selectPower',{"currpage":1});
                }else if(e.target.innerText == '员工考勤'){
                    $('.content').load('/pages/attendance.html');
                }else if(e.target.innerText == '老人信息'){
                    $('.content').load('/pages/oldManInfo.html');
                }else if(e.target.innerText == '老人事件'){
                    $('.content').load('/pages/oldManBehavior.html');
                }else if(e.target.innerText == '床位管理'){
                	//console.log("aaaaaaaaaaaaaaaaaaaaaa")
                    $('.content').load('room/get/1');
                	//console.log("bbbbbb");
                }else if(e.target.innerText == '收费设置'){
                    $('.content').load('/pages/moneySetting.html');
                }else if(e.target.innerText == '账单记录'){
                    $('.content').load('/pages/moneyLog.html');
                }else if(e.target.innerText == '员工工资'){
                    $('.content').load('/pages/money.html');
                }else if(e.target.innerText == '个人设置'){
                    $('.content').load('/pages/setting.html');
                }else if(e.target.innerText == '用户管理'){
                    $('.content').load('/pages/usersmanager.html');
                }else if(e.target.innerText == '角色管理'){
                    $('.content').load('/pages/roles.html');
                }else if(e.target.innerText == '权限管理'){
                    $('.content').load('/pages/proivd.html');
                }
            })
            $('#owner').click(function(e){
            	e.preventDefault(e);
            	 $('.content').load('/pages/setting.html');
            })
            
        })
        
	</script>
	
	 <script>
	var ctx1 = document.getElementById("lineChart").getContext('2d');
	var lineChart = new Chart(ctx1, {
		type: 'bar',
		data: {
			labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
			datasets: [{
					label: 'Dataset 1',
					backgroundColor: '#3EB9DC',
					data: [10, 14, 6, 7, 13, 9, 13, 16, 11, 8, 12, 9] 
				}, {
					label: 'Dataset 2',
					backgroundColor: '#EBEFF3',
					data: [12, 14, 6, 7, 13, 6, 13, 16, 10, 8, 11, 12]
				}]
				
		},
		options: {
						tooltips: {
							mode: 'index',
							intersect: false
						},
						responsive: true,
						scales: {
							xAxes: [{
								stacked: true,
							}],
							yAxes: [{
								stacked: true
							}]
						}
					}
	});


	var ctx2 = document.getElementById("pieChart").getContext('2d');
	var pieChart = new Chart(ctx2, {
		type: 'pie',
		data: {
				datasets: [{
					data: [12, 19, 3, 5, 2, 3],
					backgroundColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
					label: 'Dataset 1'
				}],
				labels: [
					"Red",
					"Orange",
					"Yellow",
					"Green",
					"Blue"
				]
			},
			options: {
				responsive: true
			}
	 
	});


	var ctx3 = document.getElementById("doughnutChart").getContext('2d');
	var doughnutChart = new Chart(ctx3, {
		type: 'doughnut',
		data: {
				datasets: [{
					data: [12, 19, 3, 5, 2, 3],
					backgroundColor: [
						'rgba(255,99,132,1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)'
					],
					label: 'Dataset 1'
				}],
				labels: [
					"Red",
					"Orange",
					"Yellow",
					"Green",
					"Blue"
				]
			},
			options: {
				responsive: true
			}
	 
	});
	</script> 
<!-- END Java Script for this page -->

</body>
</html>