<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
    <base href="<%=basePath%>">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <link href="html/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="html/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="html/assets/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css"
        href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" />
    <link rel="stylesheet" href="html/iconfont/iconfont.css">
    <style>
        .warp {
            display: inline-block;
            vertical-align: bottom;
            position: relative;
        }
    </style>
</head>
<div id="setting" style="padding-top: 1em">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <div class="card mb-3">
                    <div class="card-header">
                        <h3><i class="fa fa-user"></i>详细设置</h3>
                    </div>
                    <div class="card-body">
                        <form action="user/updateUser" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-lg-9">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>头像</label><br/>
                                                <img id="img" src="${login.userImg}" alt="图片丢失了"
                                                    style="border-radius: 50%;width: 200px;height: 200px; margin-bottom: 7px;">
                                                <div class="fileBox">
                                                    <div class="warp">
                                                        <input type="file" id="file" />
                                                    </div>
                                                    <img src="" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>用户名</label>
                                                <input name="id" type="hidden" value="${login.id }">
                                                <input class="form-control" name="userName" type="text"
                                                    value="${login.userName }" required />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>密码</label>
                                                <input class="form-control" name="password" type="password"
                                                    value="${login.password }" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>手机号</label>
                                                <input class="form-control" name="password" type="password"
                                                    value="${login.password }" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>邮箱</label>
                                                <input class="form-control" name="password" type="password"
                                                    value="${login.password }" />
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <button type="submit" class="btn btn-primary">修改信息</button>
                                        </div>
                                    </div>
                                </div>
                                <!-- <div class="col-lg-3 col-xl-3 border-left">
                                    <b>Latest activity</b>: Dec 06 2017, 22:23
                                    <br />
                                    <b>Register date: </b>: Nov 24 2017, 20:32
                                    <br />
                                    <b>Register IP: </b>: 123.456.789
                                    <div class="m-b-10"></div>
                                    <div id="avatar_image">
                                        <img alt="image" style="max-width:100px; height:auto;"
                                            src="assets/images/avatars/admin.png" />
                                        <br />
                                        <i class="fa fa-trash-o fa-fw"></i> <a class="delete_image" href="#">Remove
                                            avatar</a>
                                    </div>
                                    <div id="image_deleted_text"></div>
                                    <div class="m-b-10"></div>
                                    <div class="form-group">
                                        <label>Change avatar</label>
                                        <input type="file" name="image" class="form-control">
                                    </div>
                                </div> -->
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    // 上传图片
    var file = document.getElementById('file');
    var image = document.querySelector("img");
    var that = this;
    file.onchange = function () {
        var fileData = this.files[0];//获取到一个FileList对象中的第一个文件( File 对象),是我们上传的文件
        console.log(this.value)
        var pettern = /^image/;
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
                    document.getElementById('img').src = img_url
                    $('#oldmanImg').val(img_url)
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

</script>