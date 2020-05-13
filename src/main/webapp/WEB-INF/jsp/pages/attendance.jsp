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
    <title>护工考勤</title>
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

        .dates {
            height: 2px;
            background: #999999;
            margin-top: 16px;
            width: 2em;
            margin-left: 1em;
            margin-right: 1em;
        }
    </style>
</head>
<script>
    //定义一个变量用于存储添加和修改时不同的URL
    var myUrl;
    //传入点击的用户id，获取该用户信息并放入表单中
    function update(id, a) {
        //将提交表单的URL变为update
        myUrl = 'nursworker/updateAttend';
        $("#userID").attr("value", id);
        ;
        if (!id) {
            alert('id错误');
            return false;
        }
        //获取当前控件的父控件 tr
        var temp = $(a).parent().parent();
        //获取当前行tr下的所有td
        var t = temp[0].cells;
        //模态框赋值
        $('#userId').val(t[3].innerHTML);
        $('#reson').val(t[4].innerHTML);
        $('#time1').val(t[5].innerHTML.trim());
        $('#time2').val(t[6].innerHTML.trim());
        $('#backup').val(t[9].innerHTML);
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
                userId: {
                    required: true,
                    rangelength: [1, 20]
                },
                reson: {
                    required: true,
                    rangelength: [1, 99]
                },
                // time1: {
                //     required: true,
                //     rangelength: [1, 99]
                // },
                // time2: {
                //     required: true,
                //     rangelength: [1, 99]
                // },
                state: {
                    required: true,
                    rangelength: [1, 99]
                },
                backup: {
                    required: true,
                    rangelength: [1, 99]
                },
            },
            messages: {
                userId: {
                    required: "请填写编号",
                    rangelength: "编号长度不符合规范"
                },
                reson: {
                    required: "请填写原因",
                    rangelength: "请填写正确的原因"
                },
                // time1: {
                //     required: "请填写时间",
                //     rangelength: "请填写正确的时间"
                // },
                // time2: {
                //     required: "请填写时间",
                //     rangelength: "请填写正确的时间"
                // },
                state: {
                    required: "请填写状态",
                    rangelength: "请填写正确的状态"
                },
                backup: {
                    required: "请填写备注",
                    rangelength: "请填写正确的备注"
                },

               
            },
            submitHandler: function (form) {
                checkForm();
            }
        });
        //自定义动态username验证
        //username的校验只在添加操作时才需要
        //通过对username的readonly属性验证来判断是添加还是更新
        //
        /*  if ($('#username').attr("readonly") == undefined) {
             $('#username').rules("add", {
                 required: true,
                 rangelength: [5, 20],
                 messages: {
                     required: "请填写用户名",
                     rangelength: "用户名长度不符合规范"
                 }
             });
         } */
    }
    /*
    点击添加用户时需要做的操作：
        1.修改提交表单的URL
        2.将username的readonly属性移除
        3.清空表单数据
     */
    function setUrl() {
        myUrl = 'nursworker/addAttend';
        $('#form-data input').val("");
    }
    //提交表单
    function checkForm() {
        var formData;
        // 此处绑定表单数据
        if ($('#userID').val() == null || $('#userID').val() == undefined || $('#userID').val().length == 0) {
            formData = $('#userId,#reson,#time1,#time2,#state,#backup').serializeArray();
        }
        //否则为更新操作，userid为隐藏input，并且已经被赋值，序列化整个表单即可
        else {
            formData = $('#form-data').serializeArray();
        }
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
                <form action="nursworker/searchAttend/1" class="form-horizontal">
                    <div class="col-sm-3">
                        <input name="source" type="text" id="search" class="form-control">
                    </div>
                    <div class="col-sm-1">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </form>
                <div style="float: right;padding-right: 15px;">
                    <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#updateModal"
                        onclick="setUrl()">添加考勤记录</button>
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
                    <th>姓名</th>
                    <th>原因</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>状态</th>
                    <th>审核人</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userLeaves.list}" var="userLeave">
                    <tr>
                        <td><input type="checkbox" value="${userLeave.id}"></td>
                        <td>${userLeave.id}</td>
                        <td>${userLeave.baseUser.userName}</td>
                        <td style="display: none;">${userLeave.baseUser.id}</td>
                        <td>${userLeave.reson}</td>
                        <td>
                            <fmt:formatDate value="${userLeave.startTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td>
                            <fmt:formatDate value="${userLeave.endTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <c:if test="${userLeave.state==0}">
                            <td>未审核</td>
                        </c:if>
                        <c:if test="${userLeave.state==1}">
                            <td>审核通过</td>
                        </c:if>
                        <c:if test="${userLeave.state==2}">
                            <td>审核不通过</td>
                        </c:if>
                        <td>${userLeave.userManager}</td>
                        <td>${userLeave.backup}</td>
                        <td>
                            <!--传入当前用户id-->
                            <c:if test="${userLeave.state==0}">
                                <button type="button" class="btn btn-info btn-sm" data-toggle="modal"
                                    data-target="#updateModal" onclick="update(${userLeave.id},this)">编辑</button>
                            </c:if>
                            <c:if test="${login.role.id == 1}">
                                <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                    data-target="#deleteModal" data-orderId="${userLeave.id}">删除</button>
                            </c:if>
                            <c:if test="${userLeave.state==0}">
                                <c:if test="${login.role.id == 1}">
                                    <button type="button" class="btn btn-info btn-sm" data-toggle="modal"
                                        data-target="#okModal" data-orderId="${userLeave.id}">通过</button>
                                    <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                        data-target="#noOkModal" data-orderId="${userLeave.id}">拒绝</button>
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
                    <td width="120">当前为第${userLeaves.pageNum}页,共${userLeaves.pages}页</td>
                    <!-- <td width="199">
                    <c:forEach items="${oldPages.navigatepageNums}" var="p">
                        <a>${p }</a>
                    </c:forEach>
                </td> -->
                    <td width="256">
                        <c:choose>
                            <c:when test="${userLeaves.hasPreviousPage}">
                                <a href="nursworker/attendance/1">首页</a> |
                                <a href="nursworker/attendance/${userLeaves.pageNum -1 }">上一页</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${userLeaves.hasNextPage}">
                                <a href="nursworker/attendance/${userLeaves.pageNum + 1 }">下一页</a> |
                                <a href="nursworker/attendance/${userLeaves.pages }">尾页</a>
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
                                护工请假
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form action="" class="form-horizontal">
                                <!--userid为隐藏的input，便于update时的传值-->
                                <input type="text" id="userID" name="id" hidden>
                                <div class="form-group">
                                    <label for="userName" class="col-sm-3 control-label">护工编号</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="userId" name="userId"
                                            placeholder="编号为id" value="${login.id}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="reson" class="col-sm-3 control-label">原因</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="reson" name="reson"
                                            placeholder="请输入请假原因">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="time" class="col-sm-3 control-label">请假时间</label>
                                    <div class="col-sm-9">
                                        <div class="myrow">
                                            <div class='input-group date' style="width: 14em;" id='datetimepicker1'>
                                                <input id="time1" name="time1" type='text'
                                                    class="timeInput form-control" />
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                            <div class="dates">
                                            </div>
                                            <div class='input-group date' style="width: 14em;" id='datetimepicker2'>
                                                <input id="time2" name="time2" type='text'
                                                    class="timeInput form-control" />
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="health" class="col-sm-3 control-label">状态</label>
                                    <div class="col-sm-9">
                                        <select id="state" name="state" class="selectpicker show-tick form-control"
                                            data-live-search="false" disabled="disabled">
                                            <option value="0">未审核</option>
                                            <option value="1">审核通过</option>
                                            <option value="2">审核不通过</option>
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
        <!--通过模态框-->
        <form method="get" name="user" class="form-horizontal" role="form" id="form-data1" style="margin: 20px;">
            <div class="modal fade bs-example-modal-sm" id="okModal" tabindex="-1" role="dialog"
                aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="">
                                提示：确认通过？
                            </h4>
                        </div>
                        <div class="modal-footer">
                            <!--  onclick="deletebyId()" -->
                            <button id="tongguo" type="button" class="btn btn-danger">确定</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <!--type为submit时，会自动调用该表单的验证，但是不会调用自己定义的动态的username的验证，
                  所以把按钮类型改为input，再手动调用封装好的验证函数-->
                            <span id="tip"></span>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- 通过模态框结束 -->
        <!--拒绝模态框-->
        <form method="get" name="user" class="form-horizontal" role="form" id="form-data1" style="margin: 20px;">
            <div class="modal fade bs-example-modal-sm" id="noOkModal" tabindex="-1" role="dialog"
                aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="">
                                提示：确认通过？
                            </h4>
                        </div>
                        <div class="modal-footer">
                            <!--  onclick="deletebyId()" -->
                            <button id="jujue" type="button" class="btn btn-danger">确定</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <!--type为submit时，会自动调用该表单的验证，但是不会调用自己定义的动态的username的验证，
                  所以把按钮类型改为input，再手动调用封装好的验证函数-->
                            <span id="tip"></span>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- 拒绝模态框结束 -->
    </div>
</body>
<script type="text/javascript">
    $("#okModal").on("shown.bs.modal", function (e) {
        $("#tongguo").on("click", function () {
            //定义url
            var idval = "";
            idval = $(e.relatedTarget).data('orderid');

            //发送请求
            var myUrl = 'nursworker/updateAttend2?state=1&id=' + idval;
            $.ajax({
                type: "GET",
                url: myUrl,
                data: "null",
                dataType: "text",
                success: function (obj) {
                    window.location.href = "nursworker/attendance/1";
                }
            });

        });
    })
    $("#noOkModal").on("shown.bs.modal", function (e) {
        $("#jujue").on("click", function () {
            //定义url
            var idval = "";
            idval = $(e.relatedTarget).data('orderid');

            //发送请求
            var myUrl = 'nursworker/updateAttend2?state=2&id=' + idval;
            $.ajax({
                type: "GET",
                url: myUrl,
                data: "null",
                dataType: "text",
                success: function (obj) {
                    window.location.href = "nursworker/attendance/1";
                }
            });

        });
    })
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
            var myUrl = 'nursworker/removeAttendance?id=' + idval;
            $.ajax({
                type: "GET",
                url: myUrl,
                data: "null",
                dataType: "text",
                success: function (obj) {
                    window.location.href = "nursworker/attendance/1";
                }
            });

        });
    })
    // 上传图片
    $(".updatepanel").height($(".panel-info").height());
    // 5月1号被cc注释
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
        var picker2 = $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD',
            // locale: moment.locale('zh-cn')
        });
        //动态设置最小值
        picker1.on('dp.change', function (e) {
            picker2.data('DateTimePicker').minDate(e.date);
        });
        //动态设置最大值
        picker2.on('dp.change', function (e) {
            // picker1.data('DateTimePicker').maxDate(e.date);
        });
    });
    //  日期选择框相关代码结束
</script>

</html>