<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <base href="http://localhost:2333/">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>老人信息列表</title>
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
    <script src="js/lTable.js" type="text/javascript"></script>
    <!-- 下拉选择框相关 CSS -->
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
    <!-- 下拉选择框相关 JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
    <style>
        .divcss5-left {
            float: right;
            width: 350px;
            height: 50px;
        }

        .warp {
            display: inline-block;
            vertical-align: bottom;
            position: relative;
        }
    </style>
</head>
<script>
    //定义一个变量用于存储添加和修改时不同的URL
    var myUrl;
    //传入点击的用户id，获取该用户信息并放入表单中
    function update(id, a) {
        //将提交表单的URL变为update
        myUrl = 'oldmsg/edit';
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
        $('#username').val(t[2].innerHTML);
        $('#age').val(t[4].innerHTML);
        $('#gender').val(t[5].innerHTML);
        $('#telphone').val(t[9].innerHTML);
        $('#health').val(t[7].innerHTML);
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
                age: {
                    digits: true,//数字
                    required: true,
                    rangelength: [1, 3]
                },
                health: {
                    required: true,
                },
                telphone: {
                    required: true,
                    digits: true,//数字
                    rangelength: [11, 11]

                }
            },
            messages: {
                age: {
                    required: "请填写年龄",
                    digits: "请填写正确的年龄",
                    rangelength: "年龄长度不符合规范"
                },
                telphone: {
                    required: "请填写手机号",
                    digits: "请填写正确的手机号",
                    rangelength: "请填写正确的手机号"
                },
                health: {
                    required: "请填写健康状态",
                }
            },
            submitHandler: function (form) {
                alert('checkForm')
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
        myUrl = 'oldmsg/addOldmanMsg';
        $('#form-data input').val("");
        // 打开模态框禁用提交按钮
        $('#modal_button').attr('disabled', true)
    }
    // 点击入住
    function ruzhu(id, a) {
        $('#outroom').attr('hidden', true);
        $('#hugong').attr('hidden', false);
        myUrl = 'oldmsg/checkin';
        //将提交表单的URL变为update
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
        $('#oldmanId').val(t[1].innerHTML);

    }
    // 点击转房
    function zhuanfang(id, a) {
        $('#hugong').attr('hidden', true);
        $('#outroom').attr('hidden', false);
        $('#outRoomName').attr('readonly', true);
        myUrl = 'oldmsg/transfer';
        //将提交表单的URL变为update
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
        $('#oldmanId').val(t[1].innerHTML);
        $('#outRoomName').val(t[10].innerHTML);
        //隐藏组件传值
        $('#outRoomId').val(t[10].title);

    }
    //提交表单
    function checkForm() {
        alert(1)
        var formData;
        //将表单内容序列化，即可得到相应对象，直接传到后台
        //userid为空时，即当前操作为添加用户操作，此时只序列化除id之外四个属性，添加用户时id自增长。如果id为空也被序列化会报错！！！
        // 此处绑定表单数据
        if ($('#userID').val() == null || $('#userID').val() == undefined || $('#userID').val().length == 0) {
            alert('tijiao')
            formData = $('#oldmanId,#username,#age,#gender,#health,#familyMembersId,#telphone,#oldmanImg,#inRoomId,#outRoomId,#inhugongName,#backup').serializeArray();
        }
        //否则为更新操作，userid为隐藏input，并且已经被赋值，序列化整个表单即可
        else {
            alert('gengxin')
            formData = $('#form-data').serializeArray();
        }
        $.ajax({
            url: myUrl,      //根据操作传入不同的URL
            data: formData,  //传入序列化的表单对象
            cache: false,
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
                <form action="oldmsg/getMsgBySource/1" class="form-horizontal">
                    <div class="col-sm-3">
                        <input name="source" type="text" id="search" class="form-control">
                    </div>
                    <div class="col-sm-1">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </form>
                <div style="float: right;margin-right: 15px;">
                    <c:if test="${login.role.id == 1}">
                        <button type="button" class="btn btn-info" data-toggle="modal"
                            onclick="window.location='oldmsg/exportExcel'">一键导出</button>
                    </c:if>
                    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#updateModal"
                        onclick="setUrl()">添加老人信息</button>
                    <c:if test="${login.role.id == 1}">
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal"
                            th:onclick="">批量删除</button>
                    </c:if>
                </div>
            </div>
        </div>
        <br>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th></th>
                    <th>序号</th>
                    <th>唯一编号</th>
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
            <tbody>
                <c:forEach items="${oldPages.list}" var="old">
                    <tr>
                        <td><input type="checkbox" value="${old.id}"></td>
                        <td>${old.id}</td>
                        <td>${old.oldNumber}</td>
                        <td>${old.oldmanName}</td>
                        <td><img style="width: 50px;" src="${old.oldmanImg}" alt="没有图片"></td>
                        <td>${old.age}</td>
                        <td>${old.gender}</td>
                        <td>
                            <%-- ${old.checkintime} --%>
                            <fmt:formatDate value="${old.checkintime}" pattern="yyyy年MM月dd日" />
                        </td>
                        <td>${old.health}</td>
                        <td>${old.familyMembersId}</td>
                        <td>${old.telphone}</td>
                        <td title="${old.room.id}">${old.room.roomNumb}</td>
                        <td>${old.hugong.userName}</td>
                        <td>
                            <!--传入当前用户id-->
                            <c:if test="${login.role.id==1}">
                            <button type="button" class="btn btn-warning btn-sm" data-toggle="modal"
                                data-target="#updateModal" onclick="update(${old.id},this)">编辑</button>
                            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                data-target="#deleteModal" data-orderId="${old.id}">删除</button>
                            </c:if>
                            <c:if test="${login.role.id==2}">
                            <c:set var="flag" scope="session" value="${old.room.roomNumb}" />
                            <c:if test="${empty flag}">
                                <button type="button" class="btn btn-info btn-sm" data-toggle="modal"
                                        data-target="#udroomModal" onclick="ruzhu(${old.id},this)">入住</button>
                                </c:if>
                                <c:if test="${not empty flag}">
                                    <button type="button" class="btn btn-info btn-sm" data-toggle="modal"
                                        data-target="#udroomModal" onclick="zhuanfang(${old.id},this)">转房</button>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- 分页开始 -->
        <div class="divcss5-left">
            <table width="461" height="24" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="120">当前为第${oldPages.pageNum}页,共${oldPages.pages}页</td>
                    <!-- <td width="199">
                    <c:forEach items="${oldPages.navigatepageNums}" var="p">
                        <a>${p }</a>
                    </c:forEach>
                </td> -->
                    <td width="256">
                        <c:choose>
                            <c:when test="${oldPages.hasPreviousPage}">
                                <a href="oldmsg/getmsg/1">首页</a> |
                                <a href="oldmsg/getmsg/${oldPages.pageNum -1 }">上一页</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${oldPages.hasNextPage}">
                                <a href="oldmsg/getmsg/${oldPages.pageNum + 1 }">下一页</a> |
                                <a href="oldmsg/getmsg/${oldPages.pages }">尾页</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </div>
        <!-- 分页结束 -->
        <!--添加模态框-->
        <form method="post" name="user" enctype="form-data" class="form-horizontal" role="form" id="form-data"
            style="margin: 20px;">
            <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="updateModalLabel">
                                老人信息
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form action="" class="form-horizontal">
                                <!--userid为隐藏的input，便于update时的传值-->
                                <input type="text" id="userID" name="id" hidden>
                                <div class="form-group">
                                    <label for="username" class="col-sm-3 control-label">用户名</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="username" name="oldmanName"
                                            placeholder="用户名长度在2-18字符之间">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="age" class="col-sm-3 control-label">年龄</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="gender" class="col-sm-3 control-label">性别</label>
                                    <div class="col-sm-9">
                                        <select id="gender" name="gender" class="selectpicker show-tick form-control"
                                            data-live-search="false">
                                            <option value="男">男</option>
                                            <option value="女">女</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="health" class="col-sm-3 control-label">健康状况</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="health" name="health"
                                            placeholder="请输入老人的健康状况">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="telphone" class="col-sm-3 control-label">手机号</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="telphone" name="telphone"
                                            placeholder="请输入手机号">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="photo" class="col-sm-3 control-label">照片</label>
                                    <div class="col-sm-9">
                                        <label for="file">
                                            <div class="fileBox">
                                                <div class="warp">
                                                    <input type="file" id="file" />
                                                </div>
                                                <img src="" />
                                            </div>
                                        </label>
                                    </div>
                                    <input type="text" id="oldmanImg" name="oldmanImg" hidden>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <!--type为submit时，会自动调用该表单的验证，但是不会调用自己定义的动态的username的验证，
                    所以把按钮类型改为input，再手动调用封装好的验证函数-->
                            <button id="modal_button" type="input" class="btn btn-primary" onclick="vali();">提交</button>
                            <span id="tip"></span>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!--添加模态框结束-->
        <!--入住/转房模态框-->
        <form method="post" name="user" class="form-horizontal" role="form" id="form-data" style="margin: 20px;">
            <div class="modal fade" id="udroomModal" tabindex="-1" role="dialog" aria-labelledby="udroomModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="udroomModalLabel">
                                房间信息
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form action="" class="form-horizontal">
                                <!--userid为隐藏的input，便于update时的传值-->
                                <input type="text" id="oldmanId" name="oldmanId" hidden>
                                <input type="text" id="logName" name="userLog" value="${login.userName}" hidden>
                                <div class="form-group" id="outroom">
                                    <label for="outRoomId" class="col-sm-3 control-label">转出房间号</label>
                                    <div class="col-sm-9">
                                        <input type="text" id="outRoomId" name="outRoomId" hidden>
                                        <input type="text" class="form-control" id="outRoomName">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inRoomId" class="col-sm-3 control-label">转入房间号</label>
                                    <div class="col-sm-9">
                                        <select id="inRoomId" name="inRoomId"
                                            class="selectpicker show-tick form-control" data-live-search="false">
                                            <c:forEach items="${emptyRooms}" var="room">
                                                <option value="${room.id}">${room.roomNumb}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group" id="hugong">
                                    <label for="inhugongName" class="col-sm-3 control-label">护工</label>
                                    <div class="col-sm-9">
                                        <select id="inhugongName" name="inhugongName"
                                            class="selectpicker show-tick form-control" data-live-search="false">
                                            <c:forEach items="${nurseList}" var="nurse">
                                                <option value="${nurse.id}">${nurse.userName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="backup" class="col-sm-3 control-label">备注</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="backup" name="backup"
                                            placeholder="请输入备注">
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
        <!-- 入住/转房模态框结束 -->
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
                            <button id="tijiao" type="button" class="btn btn-danger">确定</button>
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
            var myUrl = 'http://localhost:2333/oldmsg/remove?id=' + idval;
            var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
            httpRequest.open('GET', myUrl, true);//第二步：打开连接  将请求参数写在url中  ps:"./Ptest.php?name=test&nameone=testone"
            httpRequest.send();//第三步：发送请求  将请求参数写在URL中
            //结果处理
            httpRequest.onreadystatechange = function () {
                if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                    var str = httpRequest.responseText;
                }
            };
            // 删除后关闭模态框
            $("#deleteModal").modal('hide');
            $(".modal-backdrop").remove();
            // 删除后刷新页面
            location.reload(true);
        });
    })
    // 上传图片
    var file = document.getElementById('file');
    var image = document.querySelector("img");
    var that = this;
    file.onchange = function () {
        var fileData = this.files[0];//获取到一个FileList对象中的第一个文件( File 对象),是我们上传的文件
        var pettern = /^image/;
        console.info(fileData.type)
        if (!pettern.test(fileData.type)) {
            alert("图片格式不正确");
            return;
        }
        that.upload(fileData);
    }
    function upload(img) {
        // 表单数据对象
        var formData = new FormData();
        // 将文件数据添加到表单数据中
        formData.append("file", img);
        var myUrl = 'http://localhost:2333/commonJson/upload';
        var request = createCORSRequest('post', myUrl);
        if (request) {
            request.onload = function () {
                if (request.status == 200) {
                    // 通过截取字符串获得图片路径
                    img_url = request.response.toString().split('url":')[1].slice(1, -2)
                    $('#oldmanImg').val(img_url)
                    // 图片上传成功后启用提交按钮
                    $('#modal_button').attr('disabled', false)

                } else {
                    alert("图片上传失败！");
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

    //入住和转房的逻辑重新在这个页面里调用





</script>

</html>