<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en"  xmlns:th="http://www.thymeleaf.org">
<head>
	<base href="http://localhost:2333/">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--validate验证表单插件-->
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
</head>
<script>
    //定义一个变量用于存储添加和修改时不同的URL
    var myUrl;
    //传入点击的用户id，获取该用户信息并放入表单中
    function update(id) {
        //将提交表单的URL变为update
        myUrl = '/updateUser';
        if(!id){
            alert('id错误');
            return false;
        }

        $.ajax(
                {
                    url:"/toUpdateUser",
                    data:{"id":id},
                    type:"post",
                    //解决编码问题
                    scriptCharset: 'utf-8',
                    beforeSend:function () {
                        return true;
                    },
                    success:function (data) {
                        if(data){
                            //解析json数据
                            var data = data;
                            var user = eval("("+data + ")");

                            //赋值
                            $('#userID').val(user.userID);
                            $('#username').val(user.username);
                            $('#password').val(user.password);
                            $('#phone').val(user.phone);
                            $('#email').val(user.email);

                            //在修改用户信息时，username不可修改
                            $('#username').attr("readonly","readonly");
                        }
                    }
        });
    }

    //表单字段验证
    //如果按照一般验证的写法，只能调用整个表单的validate函数，而不能调用自定义的username验证，所以把两个函数封装成为一个，在点击按钮时调用
    function vali() {
        //form-data表单验证。
        $("#form-data").validate({
            onfocusout:function(element) { $(element).valid(); },
            onblur: function(element) { $(element).valid(); },    //鼠标移开验证。这里写onblue:true没有效果
            onsubmit:true,      //提交时验证（有效）
            onkeyup:false,

            rules:{
                password:{
                    required:true,
                    rangelength:[5,20]
                },
                phone:{
                    required:true,
                    digits:true,
                    rangelength:[11,11]
                },
                email:{
                    required:true,
                    email:true
                }
            },
            messages:{
                password:{
                    required:"请填写密码",
                    rangelength:"密码长度不符合规范"
                },
                phone:{
                    required:"请填写手机号",
                    digits:"请填写正确的手机号",
                    rangelength:"请填写正确的手机号"
                },
                email:{
                    required:"请填写邮箱",
                    email:"请填写正确的邮箱"
                }
            },
            submitHandler:function (form) {
                checkForm();
            }
        });

        //自定义动态username验证
        //username的校验只在添加操作时才需要
        //通过对username的readonly属性验证来判断是添加还是更新
        if($('#username').attr("readonly")==undefined){
            $('#username').rules("add",{
                required:true,
                rangelength:[5,20],
                remote: {
                    type: "POST",
                    url: "/checkUsername",
                    data: {
                        username: function () {
                            return $("#username").val();
                        }
                    },
                    dataType: "html",
                    dataFilter: function(data) {
                        if (data == "true")
                            return true;
                        else
                            return false;
                    }
                }, 
                messages:{
                    required:"请填写用户名",
                    remote:"用户名已存在",
                    rangelength:"用户名长度不符合规范"
                }
            });
        }
    }


    /*
    点击添加用户时需要做的操作：
        1.修改提交表单的URL
        2.将username的readonly属性移除
        3.清空表单数据
     */
    function setUrl() {
        myUrl='oldmsg/addOldmanMsg';
        $('#username').removeAttr("readonly");
        $('#form-data input').val(" ");
    }


    //提交表单
    function checkForm() {

        var formData;
        //将表单内容序列化，即可得到相应对象，直接传到后台
        //userid为空时，即当前操作为添加用户操作，此时只序列化除id之外四个属性，添加用户时id自增长。如果id为空也被序列化会报错
        if($('#userID').val()==null||$('#userID').val()==undefined||$('#userID').val().length==0){
            formData = $('#username,#password,#email,#phone').serializeArray();
        }
        //否则为更新操作，userid为隐藏input，并且已经被赋值，序列化整个表单即可
        else{
            formData = $('#form-data').serializeArray();
        }

        $.ajax({
                url:myUrl,      //根据操作传入不同的URL
                data:formData,  //传入序列化的表单对象
                type:"post",
                datatype:'text',
                async:false,    //异步传输
                timeout:50000,
                //设置编码
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                beforeSend:function () {
                    $('#tip').html('<span style="color: cornflowerblue">正在处理...</span>');
                    return true;
                },
                success:function (data) {
                    if(data==='ok'){
                        $('#tip').html('<span style="color: green">操作成功！</span>');
                        location.reload();
                    }else{
                        $('#tip').html('<span style="color: red">操作失败，请重试</span>');
                    }
                },
                error:function(XMLHttpRequest, textStatus, errorThrown) {
                    // alert(XMLHttpRequest.status);//状态码
                    // alert(XMLHttpRequest.readyState);//状态
                    // alert(textStatus);//错误信息
                    alert("出错了");

                },
                complete:function () {

                }
                });
    }

</script>
<body>
<div class="container-fluid">
    <div class="tool">
        <div class="row">
			<br/>
            <form action="oldmsg/getMsgBySource" class="form-horizontal">

            <div class="col-sm-3">
                <input name="source" type="text" id="search" class="form-control">
            </div>
            <div class="col-sm-1">
                <button type="submit" class="btn btn-primary">搜索</button>
            </div>
            </form>
            <div class="col-sm-4">

            </div>
            <div class="col-sm-2">
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#updateModal" onclick="setUrl()">添加用户</button>
                <button type="button" class="btn btn-danger"  th:onclick="'javascript:deleteUser('+${user.userID}+')' ">批量删除</button>
  
            </div>
        </div>
    </div>
    <br>
    <table class="table table-bordered table-hover">
        <thead>
            <tr>
            	<th></th>
                <th>序号</th>
                <th>姓名</th>
                <th>照片</th>
                <th>年龄</th>
                <th>性别</th>
                <th>入住时间</th>
                <th>健康状况</th>
                <th>老人家属</th>
                <th>电话</th>
                <th>房间号</th>
                <th>护工姓名</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody >
        	<c:forEach items="${oldlist}" var="old">
            <tr th:each="user : ${userlist}">
            	<th ><input type="checkbox"></th>
                <td th:text="${user.username}">${old.id}</td>
                <td th:text="${user.password}">${old.oldmanName}</td>
                <td th:text="${user.phone}"><img src="./" alt="没有图片"></td>
                <td th:text="${user.email}">${old.age}</td>
                <td th:text="${user.email}">${old.gender}</td>
                <td th:text="${user.email}">${old.checkintime}</td>
                <td th:text="${user.email}">${old.health}</td>
                <td th:text="${user.email}">${old.familyMembersId}</td>
                <td th:text="${user.email}">${old.telphone}</td>
                <td th:text="${user.email}">${old.roomId}</td>
                <td th:text="${user.email}">${old.userId}</td>
                <td>
                    <!--传入当前用户id-->
                    <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#updateModal" th:onclick="'javascript: update('+${user.userID}+')' ">编辑</button>
                    <button type="button" class="btn btn-danger btn-sm"  th:onclick="'javascript:deleteUser('+${user.userID}+')' ">删除</button>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
          <li>
            <a href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li>
            <a href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
    <!--模态框-->
    <form method="post" name="user" class="form-horizontal" role="form" id="form-data"  style="margin: 20px;" >
    <div class="modal fade" id="updateModal"   tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="updateModalLabel">
                        用户信息
                    </h4>
                </div>
                <div class="modal-body">
                    <form action="" class="form-horizontal">
                        <!--userid为隐藏的input，便于update时的传值-->
                        <input type="text" id="userID" name="userID" hidden>
                        <div class="form-group">
                            <label for="username" class="col-sm-3 control-label">用户名</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="username" name="oldmanName" placeholder="用户名长度在5-18字符之间">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">密码</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="password" name="password" placeholder="密码长度在5-20字符之间">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-3 control-label">手机号</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">邮箱</label>
                            <div class="col-sm-9">
                                <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱地址">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <!--type为submit时，会自动调用该表单的验证，但是不会调用自己定义的动态的username的验证，
                    所以把按钮类型改为input，再手动调用封装好的验证函数-->
                    <button type="input" class="btn btn-primary" onclick="vali();">提交</button>
                    <span id="tip"></span>
                </div>
            </div>
        </div>
    </div>
    </form>
</div>
<div th:insert="template/footer :: copyright"></div>
</body>
</html>

		<!-- <table class="table table-sm table-bordered table-hover text-center">
		  <thead>
		    <tr>
		      <th scope="col"><input type="checkbox"></th>
		      <th scope="col">照片</th>
		      <th scope="col">姓名</th>
		      <th scope="col">性别</th>
		      <th scope="col">身份证号</th>
		      <th scope="col">联系方式</th>
		      <th scope="col">紧急联系人</th>
		      <th scope="col">操作</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
				      <td><input type="checkbox" value="`+item.id+`"></td>
				      <td><img src="./" alt="没有图片"></td>
				      <td>张三</td>
				      <td>男</td>
				      <td>156226262848511</td>
				      <td>151848484</td>
				      <td>151848484</td>
				      <td>
						<i class='iconfont icon-edit' id='edit'>qq</i>
						<i class='iconfont icon-shanchu' id='del'></i>
						
				      </td>
		    </tr>
		  </tbody>
		</table>
		
	</div>
	<div style="position: relative;display: flex;justify-content: flex-end;">
		<nav aria-label="Page navigation example" >
			
			  <ul class="pagination" onclick="pageChange(event)">

			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
	  			</ul>
	  			
			</nav>
	</div>
		-->




