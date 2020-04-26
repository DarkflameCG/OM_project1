<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>">
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
	<link href="html/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="html/assets/css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
	<link rel="stylesheet" href="html/iconfont/iconfont.css">
	<script src="js/lTable.js" type="text/javascript"></script>
	
	
</head>
<div class="ownersettings" style="padding-top: 1em">
	<div class="table_content" >
	  			<div style="position: relative;bottom: .5em;">
		  				<div style="position: absolute;">
							<input id="queryInput1" type="text" placeholder="请输入查询内容" style="margin-top: -1em">
							
							<button class="btn btn-info btn-sm" id="btn_query1" style="margin-top: -.4em">确认</button>
						</div>
						<div class="btns" style="float: right;">
							
							<button class="btn btn-info btn-sm" id="btn_add_users">添加</button>
							<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">批量删除</button>
						</div>
		  		</div>
				<table class="table table-sm table-bordered table-hover text-center">
				  <thead>
				    <tr>
				      <th scope="col"><input type="checkbox"></th>
				      <th scope="col">用户</th>
				      <th scope="col">金额</th>
				      <th scope="col">时间</th>
				      <th scope="col">操作</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${users.list}" var="user">
				    <tr>
						      <td><input type="checkbox" value="${user.id}"></td>
						      <td>${user.userName}</td>
						      <td>${user.salary}</td>
						      <td>${user.workTime}</td>
						      <td>
 						<!--传入当前用户id-->
                            <button type="button" class="btn btn-info btn-sm" data-toggle="modal"
                                data-target="#updateModal" onclick="update(${user.id},this)">编辑</button>
                            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal"
                                data-target="#deleteModal" data-orderId="${user.id}">删除</button>
						      </td>
				    </tr>
				      </c:forEach>
				  </tbody>
				</table>
				<!-- 分页 -->
				
			</div>
			 <!-- 分页开始 -->
        <div class="divcss5-left">
            <table width="461" height="24" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="120">当前为第${users.pageNum}页,共${users.pages}页</td>
                    <!-- <td width="199">
                    <c:forEach items="${oldPages.navigatepageNums}" var="p">
                        <a>${p }</a>
                    </c:forEach>
                </td> -->
                    <td width="256">
                        <c:choose>
                            <c:when test="${users.hasPreviousPage}">
                                <a href="user/user/1">首页</a> |
                                <a href="user/user/${users.pageNum -1 }">上一页</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${users.hasNextPage}">
                                <a href="user/user/${users.pageNum + 1 }">下一页</a> |
                                <a href="user/user/${users.pages }">尾页</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </div>
        <!-- 分页结束 -->
        
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
                            <button id="tijiao" type="button"  class="btn btn-danger">确定</button>
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
        
		<!-- 模态框 -->
	<div class="modal fade" id="waiterModal">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">添加员工</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form>
			  <div class="form-group" id="name_err">
			    <label for="input_realname">姓名<span class="name_err" style="color: red;">请输入至少一位字母</span></label>
			    <input type="text" class="form-control" id="input_realname" placeholder="请输入姓名">
			  </div>
			  <div class="form-group" id="telephone_err">
			    <label for="input_telephone">电话<span class="telephone_err" style="color: red;">请输入9-11位数字</span></label>
			    <input type="text" class="form-control" id="input_telephone" placeholder="请输入电话">
			  </div>
			  <div class="form-group" id="password_err">
			    <label for="input_password">密码<span class="password_err" style="color: red;">请输入至少一位数字</span></label>
			    <input type="password" class="form-control" id="input_password" placeholder="请输入密码">
			  </div>
			 
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" id="btn_none">取消</button>
	        <button type="button" class="btn btn-primary" id="addWaiter">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
</div>
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
             var myUrl = 'user/deleteUser?id=' + idval;
            $.ajax({
				type : "GET",
				url : myUrl,
				data : "null",
				dataType : "text",
				success : function(obj) {
					window.location.href="user/user/1";
				}
			}); 
           
        });
    })
	</script>

