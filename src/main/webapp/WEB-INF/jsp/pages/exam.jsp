<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>体检记录</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
    <!--validate验证表单插件-->
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <script src="js/lTable.js" type="text/javascript"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
    <!-- 时间选择器 -->
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
        rel="stylesheet">
    <script src="https://cdn.bootcss.com/moment.js/2.22.0/moment-with-locales.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>


    <style>
        .divcss5-left {
            float: right;
            width: 350px;
            height: 50px;
        }

        .myrow {
            display: flex;
            flex-direction: row;
            /*margin-left:1em;*/
        }
    </style>
</head>
<script>

    //定义一个变量用于存储添加和修改时不同的URL
    var myUrl;
    //传入点击的用户id，获取该用户信息并放入表单中
    function update(id, a) {
        //将提交表单的URL变为update
        myUrl = 'exam/edit';
        $("#userID").attr("value", id);
        if (!id) {
            alert('id错误');
            return false;
        }
        //获取当前控件的父控件 tr
        var temp = $(a).parent().parent();
        //获取当前行tr下的所有td
        var t = temp[0].cells;
        //模态框赋值
        $('#oldNumb').val(t[1].title);
        $('#level').val(t[4].innerHTML);
        $('#time_1').val(t[5].innerHTML.trim());
        //给姓名框设置只读
        //$('#username').attr("readonly", "readonly");
        //下面是使用ajax动态的放数据
        /*  $.ajax(
             {
                 url: "/toUpdateUser",
                 data: { "id": id },
                 type: "post",
                 //解决编码问题
                 scriptCharset: 'utf-8',
                 beforeSend: function () {
                     return true;
                 },
                 success: function (data) {
                     if (data) {
                         //解析json数据
                         var data = data;
                         var user = eval("(" + data + ")");
 
                         //赋值
                         $('#userID').val(user.userID);
                         $('#username').val(user.username);
                         $('#password').val(user.password);
                         $('#phone').val(user.phone);
                         $('#email').val(user.email);
 
                         //在修改用户信息时，username不可修改
                         $('#username').attr("readonly", "readonly");
                     }
                 }
             }); */
    }

    //表单字段验证
    //如果按照一般验证的写法，只能调用整个表单的validate函数，而不能调用自定义的username验证，所以把两个函数封装成为一个，在点击按钮时调用
    function vali() {
        //form-data表单验证。
        $("#form-data").validate({
            onfocusout: function (element) { $(element).valid(); },
            onblur: function (element) { $(element).valid(); },    //鼠标移开验证。这里写onblue:true没有效果
            onsubmit: true,      //提交时验证（有效）
            onkeyup: false,
            rules: {
                password: {
                    required: true,
                    rangelength: [5, 20]
                },
                phone: {
                    required: true,
                    digits: true,
                    rangelength: [11, 11]
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                password: {
                    required: "请填写密码",
                    rangelength: "密码长度不符合规范"
                },
                phone: {
                    required: "请填写手机号",
                    digits: "请填写正确的手机号",
                    rangelength: "请填写正确的手机号"
                },
                email: {
                    required: "请填写邮箱",
                    email: "请填写正确的邮箱"
                }
            },
            submitHandler: function (form) {
                checkForm();
            }
        });
        //自定义动态username验证
        //username的校验只在添加操作时才需要
        //通过对username的readonly属性验证来判断是添加还是更新
        //
        if ($('#username').attr("readonly") == undefined) {
            $('#username').rules("add", {
                required: true,
                rangelength: [2, 18],
                /* remote: {
                    type: "POST",
                    url: "/checkUsername",
                    data: {
                        username: function () {
                            return $("#username").val();
                        }
                    },
                    dataType: "html",
                    dataFilter: function (data) {
                        if (data == "true")
                            return true;
                        else
                            return false;
                    }
                }, */
                messages: {
                    required: "请填写用户名",
                    /*  remote: "用户名已存在", */
                    rangelength: "用户名长度不符合规范"
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
        myUrl = 'exam/add';
        $('#form-data input').val("");
    }
    //提交表单
    function checkForm() {
        var formData;
        //将表单内容序列化，即可得到相应对象，直接传到后台
        // ！！！！！
        //userid为空时，即当前操作为添加用户操作，此时只序列化除id之外四个属性，添加用户时id自增长。如果id为空也被序列化会报错！！！
        // ！！！！！
        // 此处绑定表单数据
        formData = $('#time_1,#userLog,#userId,#oldNumb,#level').serializeArray();


        $.ajax({
            url: myUrl,      //根据操作传入不同的URL
            data: formData,  //传入序列化的表单对象
            type: "post",
            datatype: 'text',
            async: false,    //异步传输
            timeout: 50000,
            //设置编码
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            beforeSend: function () {
                $('#tip').html('<span style="color: cornflowerblue">正在处理...</span>');
                return true;
            },
            success: function (data) {
                if (data === 'ok') {
                    $('#tip').html('<span style="color: green">操作成功！</span>');
                    location.reload();
                } else {
                    $('#tip').html('<span style="color: red">操作失败，请重试</span>');
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                // alert(XMLHttpRequest.status);//状态码
                // alert(XMLHttpRequest.readyState);//状态
                // alert(textStatus);//错误信息
                alert("出错了");

            },
            complete: function () {
            }
        });
    }
</script>

<body>
    <div class="container-fluid">
        <div class="tool">
            <div class="row">
                <br />
                <form action="exam/getBySource/1" class="form-horizontal">
                    <div class="col-sm-3">
                        <input name="source" type="text" id="search" class="form-control">
                    </div>
                    <div class="col-sm-1">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </form>
                <div style="float: right;margin-right: 15px;">
                    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#updateModal"
                        onclick="setUrl()">添加体检记录</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal"
                        th:onclick="">批量删除</button>
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
                    <th>性别</th>
                    <th>项目</th>
                    <th>体检时间</th>
                    <th>体检报告</th>
                    <th>登记时间</th>
                    <th>操作人</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${monitorPages.list}" var="exam">
                    <tr">
                        <td><input type="checkbox" value="${exam.id}"></td>
                        <td title="${exam.oldman.oldNumber}">${exam.id}</td>
                        <td>${exam.oldman.oldmanName}</td>
                        <td>${exam.oldman.gender}</td>
                        <td>${exam.level}</td>
                        <td>
                            <fmt:formatDate value="${exam.examTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td><a href="exam/download/${exam.oldman.id}">下载</a></td>
                        <td>
                            <fmt:formatDate value="${exam.time}" pattern="yyyy年MM月dd日" />
                        </td>
                        <td>${exam.user.userName}</td>
                        <td>
                            <!--传入当前用户id-->
                            <button type="button" class="btn btn-info btn-sm" data-toggle="modal"
                                data-target="#updateModal" onclick="update(${exam.id},this)">编辑</button>
                            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                data-target="#deleteModal" data-orderId="${exam.id}">删除</button>
                        </td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- 分页开始 -->
        <div class="divcss5-left">
            <table width="461" height="24" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="120">当前为第${monitorPages.pageNum}页,共${monitorPages.pages}页</td>
                    <!-- <td width="199">
                    <c:forEach items="${monitorPages.navigatepageNums}" var="p">
                        <a>${p }</a>
                    </c:forEach>
                </td> -->
                    <td width="256">
                        <c:choose>
                            <c:when test="${monitorPages.hasPreviousPage}">
                                <a href="exam/get/1">首页</a> |
                                <a href="exam/get/${monitorPages.pageNum -1 }">上一页</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${monitorPages.hasNextPage}">
                                <a href="exam/get/${monitorPages.pageNum + 1 }">下一页</a> |
                                <a href="exam/get/${monitorPages.pages }">尾页</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </div>
        <!-- 分页结束 -->
        <!--模态框-->
        <form method="post" name="user" class="form-horizontal" role="form" id="form-data" style="margin: 20px;">
            <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="updateModalLabel">
                                添加体检信息
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form action="" class="form-horizontal">
                                <!--userid为隐藏的input，便于update时的传值-->
                                <input type="text" id="userId" name="userId" value="${login.id}" hidden>
                                <div class="form-group">
                                    <label for="oldNumb" class="col-sm-3 control-label">老人编号</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="oldNumb" name="oldNumb"
                                            placeholder="编号为两位字母六位数字">
                                    </div>
                                </div>
                                <!--这个地方可能需要一个选择框-->
                                <div class="form-group">
                                    <label for="level" class="col-sm-3 control-label">体检项目</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="level" name="level"
                                            placeholder="请输入体检项目">
                                    </div>
                                </div>
                                <!--这个地方需要一个时间控件，就一个-->
                                <div class="form-group">
                                    <label for="examTime" class="col-sm-3 control-label">体检时间</label>
                                    <div class="col-sm-9">
                                        <!-- <input type="text" class="form-control" id="examTime" name="examTime"
                                            placeholder="请输入体检时间"> -->
                                        <div class="myrow">
                                            <div class='input-group date' style="width: 14em;" id='datetimepicker1'>
                                                <input id="time_1" name="time_1" type='text'
                                                    class="timeInput form-control" />
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
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

        <!--删除模态框-->
        <form method="get" name="user" class="form-horizontal" role="form" id="form-data1" style="margin: 20px;">
            <div class="modal fade bs-example-modal-sm" id="deleteModal" tabindex="-1" role="dialog"
                aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="">
                                警告：确认删除？
                            </h4>
                        </div>
                        <div class="modal-footer">
                            <!--  onclick="deletebyId()" -->
                            <button id="tijiao" type="input" class="btn btn-danger">确定</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <!--type为submit时，会自动调用该表单的验证，但是不会调用自己定义的动态的username的验证，
                      所以把按钮类型改为input，再手动调用封装好的验证函数-->
                            <span id="tip"></span>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- 删除模态框结束 -->
    </div>
</body>
<script type="text/javascript">
    //删除
    $("#deleteModal").on("shown.bs.modal", function (e) {
        $("#tijiao").on("click", function () {
            //定义url
            var idval = "";
            //判断checkbox是否勾选
            var arr = $("input:checked");
            if (arr.length !== 0) {
                //批量删除
                for (var i = 0; i < arr.length; i++) {
                    if (i == arr.length - 1) {
                        idval = idval + arr[i].value;
                    } else {
                        idval = idval + arr[i].value + ","
                    }
                }
            } else {
                //根据id删除
                idval = $(e.relatedTarget).data('orderid');
            }
            //发送请求
            var myUrl = '<%=basePath%>exam/remove?id=' + idval;
            var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
            httpRequest.open('GET', myUrl, true);//第二步：打开连接  将请求参数写在url中  ps:"./Ptest.php?name=test&nameone=testone"
            httpRequest.send();//第三步：发送请求  将请求参数写在URL中
            //结果处理
            httpRequest.onreadystatechange = function () {
                if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                    var str = httpRequest.responseText;
                    alert(str);
                }
            };
        });
    })
    // 上传图片
    $(".updatepanel").height($(".panel-info").height());
    // document.getElementById('file').onchange = function () {
    //     add();
    //     var imgFile = this.files[0];
    //     var fr = new FileReader();
    //     fr.onload = function () {
    //         var imgs = document.getElementsByClassName('updateimg');
    //         imgs[imgs.length - 1].src = fr.result;
    //     };
    //     fr.readAsDataURL(imgFile);
    // };
    function add() {
        var html = "<div class='col-sm-4'><div class='panel panel-info'><div class='panel-heading'><i class='fa fa-times'></i></div><div class='panel-body' style='text-align: center;'><div class='row'><div class='col-sm-12 col-md-12'><img class='updateimg img-responsive' src='img/p_big3.jpg' style='width: inherit;height: 210px;'/></div></div></div></div></div>";
        $("#updatebox").before(html);
    }
    $(".fa-times").click(function () {
        $(this).parent().parent().parent().remove();
    });
    //  日期选择框相关代码
    $(function () {
        $('#form1').hide();
        var picker1 = $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
            minDate: '2016-7-1'//可选择的最小日期
        });
    });
    //  日期选择框相关代码结束
</script>

</html>