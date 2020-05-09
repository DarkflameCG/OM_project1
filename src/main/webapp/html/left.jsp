<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <title>老人信息管理系统</title>
    <!-- Favicon -->
    <!--    <link rel="shortcut icon" href="assets/images/favicon.ico">-->
    <!--    <link href="https://at.alicdn.com/t/font_1411447_zhf55y3egs.css" rel="stylesheet">-->
    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    <!-- Font Awesome图标库 CSS -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet" type="text/css" />

    <!-- BEGIN CSS for this page -->
    <!--    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>-->
    <!--    <link rel="stylesheet" href="./iconfont/iconfont.css">-->
    <!-- END CSS for this page -->
    <!--    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>-->


    <script type="text/javascript">
        //点击跳转
        function forward(url) {
            parent.frames["mainFrame"].location.href = url;
        }
    </script>
    <!--</head>-->
    <!-- top bar navigation -->
    <!--    <div id="">-->
    <!--    <div class="headerbar">-->

    <!--        &lt;!&ndash; LOGO &ndash;&gt;-->
    <!--        <div class="headerbar-left">-->
    <!--            <a href="pages/home.html" target="mainFrame"class="logo"><img alt="Logo" src="assets/images/logo.png" /> <span>老人信息</span></a>-->
    <!--        </div>-->

    <!--    </div></div>-->
    <!-- End Navigation -->

    <!-- Left Sidebar -->
    <div class="left main-sidebar">
        <!--        <div class="left">-->
        <div class="sidebar-inner leftscroll">
            <div id="sidebar-menu">
                <ul>
                    <li class="submenu">
                        <a href="pages/home.jsp" target="mainFrame"><i class="fa fa-fw fa-bars"></i><span>首页</span>
                        </a>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fa fa-address-book-o fa-fw"></i> <span>老人信息管理</span> <span
                                class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li class="submenu">
                                <a href="/oldmsg/getmsg/1" target="mainFrame">
                                    <span>老人信息</span> </a>
                            </li>
                            <li class="submenu">
                                <a href="/room/get/1" target="mainFrame">
                                    <span>床位管理</span></a>
                            </li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fa fa-grav fa-fw"></i> <span>老人活动</span> <span class="menu-arrow"></span></a>
                        <ul class="list-unstyled">

                            <li><a href="/activity/ruzhu/1" target="mainFrame">入住</a></li>
                            <li><a href="/zf/get/1" target="mainFrame">转房</a></li>

                            <li><a href="/wc/get/1" target="mainFrame">外出</a></li>
                            <li><a href="/qj/get/1" target="mainFrame">请假</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-medkit"></i> <span>医疗健康</span> <span
                                class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="/exam/get/1" target="mainFrame">体检管理</a></li>
                            <li><a href="/seek/get/1" target="mainFrame">外出就医</a></li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-bar-chart"></i> <span>财务管理</span> <span
                                class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="/index/finance/1" target="mainFrame">收费设置</a></li>
                            <li><a href="/index/cost/1" target="mainFrame">缴费记录</a></li>
                            <li><a href="/index/account/1" target="mainFrame">会员卡充值</a></li>
                        </ul>
                    </li>
                    <c:if test="${login.role.id == 1}">
                    <li class="submenu">
                        <a href="#"><i class="fa fa-fw fa-table"></i> <span>护工管理</span> <span
                                class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li>
                                <a href="/nursworker/selectnursworker/1" target="mainFrame"><span>护工信息</span> </a>
                            </li>
                            <li>
                                <a href="/nursworker/attendance/1" target="mainFrame">
                                    <span>护工考勤</span></a>
                            </li>
                        </ul>
                    </li>
                    </c:if>
                    <li class="submenu">
                        <a href="#"><i class="fa fa-cog fa-fw"></i> <span>基本设置</span> <span
                                class="menu-arrow"></span></a>
                        <ul class="list-unstyled">
                            <li><a href="/user/me" target="mainFrame">个人设置</a></li>
                            <c:if test="${login.role.id == 1}">
                            <li><a href="/user/user/1" target="mainFrame">用户管理</a></>li>
                            <li><a href="/powers/power/1" target="mainFrame">角色管理</a></li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- End Sidebar -->
    <script src="assets/js/modernizr.min.js"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/moment.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/detect.js"></script>
    <script src="assets/js/fastclick.js"></script>
    <script src="assets/js/jquery.blockUI.js"></script>
    <script src="assets/js/jquery.nicescroll.js"></script>
    <!-- App js -->
    <script src="assets/js/pikeadmin.js"></script>
    <!-- BEGIN Java Script for this page -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
    <!-- Counter-Up-->
    <script src="assets/plugins/waypoints/lib/jquery.waypoints.min.js"></script>
    <script src="assets/plugins/counterup/jquery.counterup.min.js"></script>
    <script>
        $(document).ready(function () {
            // data-tables
            $('.content').load('./pages/home.html');
            $('#example1').DataTable();
            // counter-up
            $('.counter').counterUp({
                delay: 10,
                time: 600
            });
        });
    </script>
</html></html>