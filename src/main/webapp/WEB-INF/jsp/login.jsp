<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>老人管理系统登录</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/static/assets1/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/static/assets1/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/static/assets1/css/form-elements.css">
        <link rel="stylesheet" href="/static/assets1/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="/static/assets1/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/static/assets1/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/static/assets1/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/static/assets1/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/static/assets1/ico/apple-touch-icon-57-precomposed.png">
<c:if test="${msg!=null }">
 <script type="text/javascript">
	alert("${msg}");
 </script>
 </c:if>
    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>老人信息管理</strong>登录</h1>
                            <div class="description">
                            	<p>
	                            	登录前请选择角色
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登录系统</h3>
                            		<p>确认你的用户名和密码</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="user/login" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
			                        </div>
                                     <div class="form-group">
                                        <select id="roles" defaultValue="" class="form-username form-control" name="roleId">
                                            <option value="">请选择角色</option>
                                            <c:forEach items="${powers}" var="p">
                                            <option value="${p.id}">${p.power}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
			                        <input type="submit" class="btn" value="Sign in">
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>...or login with:</h3>
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-1 btn-link-1-facebook" href="#">
	                        		<i class="fa fa-facebook"></i> Facebook
	                        	</a>
	                        	<a class="btn btn-link-1 btn-link-1-twitter" href="#">
	                        		<i class="fa fa-twitter"></i> Twitter
	                        	</a>
	                        	<a class="btn btn-link-1 btn-link-1-google-plus" href="#">
	                        		<i class="fa fa-google-plus"></i> Google Plus
	                        	</a>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        

        <!-- Javascript -->
        <script src="/static/assets1/js/jquery-1.11.1.min.js"></script>
        <script src="/static/assets1/bootstrap/js/bootstrap.min.js"></script>
        <script src="/static/assets1/js/jquery.backstretch.min.js"></script>
        <script src="/static/assets1/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>
    <script>
        function handleLogin(e){
            e.preventDefault();
            console.log($('#form-username')[0].value,$('#form-password')[0].value,$('#roles')[0].value)
            console.log("11111111")
        }
    </script>
</html>