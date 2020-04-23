<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
	<link rel="stylesheet" href="html/iconfont/iconfont.css">
	<script src="html/js/lTable.js" type="text/javascript"></script>
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
							<button class="btn btn-danger btn-sm" id="btn_batchDel">批量删除</button>
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
			 <!--  <div class="form-group" id="role_err">
			    <label for="input_password">角色<span class="password_err" style="color: red;">请输入至少一位数字</span></label>
			    <input type="password" class="form-control" id="input_password" placeholder="请输入角色">
			  </div> -->
			 
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

<script>
	$('#myTab a').on('click', function (e) {
	  e.preventDefault()
	  console.log(e,"aaa")
	  // $(this).tab('show')
	})
	var baseURL = 'http://134.175.100.63:6677';
	// 该id是点击修改按钮时获取的id，设置为全局变量
	var EditId;
	// 查询所有数据
	function loadData(){
		// 在每次追加数据之前，先清空table
		$('.table tbody').empty();
		var url_findAll = baseURL+'/waiter/findAll';
		$.get(url_findAll,function(result){
			result.data.forEach(function(item){
				var newTr = $(`
					<tr>
				      <td><input type="checkbox" value="`+item.id+`"></td>
				      <td>`+item.realname+`</td>
				      <td>`+item.password+`</td>
				      <td>`+item.telephone+`</td>
				      <td>
						<i class='iconfont icon-edit' id='edit'></i>
						<i class='iconfont icon-shanchu' id='del'></i>
				      </td>
				    </tr>
				`);
				// 将生成的newTr追加到tbody上
				$('.table tbody').append(newTr);
			})
		});
	}
	// 关闭提示框，在点击提示框中的x才调用该函数
	function closeAlert(){
		$(this).parents('.alert').remove();
	}
	// 分页函数
	function pageChange(e){
		console.log(e.target.innerText,"ssss")
	}
	$(function(){
		// 加载所有数据
		// loadData();

		// 批量删除
		$('#btn_batchDel').click(function(){
			var url_batchDel = baseURL+'/waiter/batchDelete';
			var ids = $(':checkbox:checked').map(function(index,item){
				return $(item).val();
			}).toArray();
			var data = '';
			for(index in ids){
				if(index == 0){
					data += 'ids='+ids[index]
				}else{
					data +='&ids='+ids[index]
				}
			}
			$.post(url_batchDel,data,function(result){
				console.log(result);
				loadData();
			})
		})

		// 添加或修改数据
		$('#addWaiter').click(function(){
			var name = $('#input_realname').val();
			var phone = $('#input_telephone').val();
			var password = $('#input_password').val();
			var pattern_name = /^[a-z]{1,}$/ig;
			var pattern_phone = /^\d{9,11}$/ig;
			var pattern_password = /^\d{1,}$/ig;
			var name_res = pattern_name.test(name);
			var phone_res = pattern_phone.test(phone);
			var password_res = pattern_password.test(password);
			if(name_res && phone_res && password_res){
				if(EditId){
					// id存在，即修改
					var data = {
						id:EditId,
						realname:name,
						telephone:phone,
						password:password
					}
					var url_editCustomer = baseURL+'/waiter/saveOrUpdate';
					$.post(url_editCustomer,data,function(result){
						console.log(result,'修改');
						loadData();
					});
					// 将id置为空，否则点击修改后再次点击添加，还是修改
					EditId = '';
					$('#waiterModal').modal('hide');	
				}else{
					// id不存在，即添加
					var data = {
						realname:name,
						telephone:phone,
						password:password
					}
					var url_addCustomer = baseURL+'/waiter/saveOrUpdate';
					$.post(url_addCustomer,data,function(result){
						console.log(result);
						loadData();
					});
					$('#waiterModal').modal('hide');	
				}
			}else{
				// 表单验证
				if(!name_res && !phone_res && !password_res){
					$('#name_err span').removeClass('name_err');
					$('#telephone_err span').removeClass('telephone_err');
					$('#password_err span').removeClass('password_err');
				}
				if(!phone_res && !password_res){
					$('#telephone_err span').removeClass('telephone_err');
					$('#password_err span').removeClass('password_err');
				}
				if(!name_res && !phone_res){
					$('#name_err span').removeClass('name_err');
					$('#telephone_err span').removeClass('telephone_err');
				}
				if(!name_res && !password_res){
					$('#name_err span').removeClass('name_err');
					$('#password_err span').removeClass('password_err');
				}
				if(!name_res){
					$('#name_err span').removeClass('name_err');
				}
				if(!phone_res){
					$('#telephone_err span').removeClass('telephone_err');	
				}
				if(!password_res){
					$('#password_err span').removeClass('password_err');	
				}
			}

			
		})
		
		// 显示模态框，用户添加
		$('#btn_add_users').click(function(){
			$('#waiterModal').modal('show');
			$('#name_err span').addClass('name_err');
			$('#telephone_err span').addClass('telephone_err');
			$('#password_err span').addClass('password_err');
		})
		
		
		
		// 关闭模态框
		$('#btn_none').click(function(){
			$('#waiterModal').modal('hide');
		})

		// 监听模态框的关闭，清空模态框内容
		$('#waiterModal').on('hidden.bs.modal', function(e){
		  $(this).find('form')[0].reset();
		})
		$('#btn_query1').click(function(event){
			console.log($('#queryInput1')[0].value)
			alert(JSON.stringify(event))
		})
		$('#btn_query2').click(function(event){
			console.log($('#queryInput2')[0].value)
			alert(JSON.stringify(event))
		})
		$('#btn_query3').click(function(event){
			console.log($('#queryInput3')[0].value)
			alert(JSON.stringify(event))
		})
		// 删除与修改按钮
		$('.table tbody').on('click','i',function(){
			switch(this.id){
				// 修改
				case 'edit':
					// 打开模态框
				 	$('#waiterModal').modal('show');
				 	// 获取当前行的值并放入模态框（不能在此处就发送请求）
					EditId = $(this).parents('tr').find('td').find('input').val();
				 	var name = $(this).parents('tr').find('td:nth-child(2)').text();
				 	var telephone = $(this).parents('tr').find('td:nth-child(3)').text();
				 	var password = $(this).parents('tr').find('td:nth-child(4)').text();
				 	$('#input_realname').val(name);
				 	$('#input_telephone').val(telephone);
				 	$('#input_password').val(password);
					break;
				// 删除
				case 'del':
				 	var url_del = baseURL+'/waiter/deleteById';
					var id = $(this).parents('tr').find('input[type=checkbox]').val();
					var data = {
						id:id
					}
					$.get(url_del,data,function(result){
						if(result.status === 200){
							loadData();
							// 删除并刷新数据后，追加提示框
							$(`
								<div class="alert alert-info alert-dismissible" id='mySuccessAlert'>
									<div>
										删除成功
									</div>
									<button class="close" onclick="closeAlert.call(this)" id='btn_success'>
										~
									</button>
								</div>
							`).prependTo($('body'));
							// 延时调用，2s后模拟点击提示框的关闭按钮
							setTimeout(function(){
								$('#btn_success').trigger('click');
							},2000);
						}else{
							$(`
								<div class="alert alert-info alert-dismissible" id='myWarnAlert'>
									<div>
										删除失败，接口异常
									</div>
									<button class="close" onclick="closeAlert.call(this)" id='btn_warn'>
										！
									</button>
								</div>
							`).prependTo($('body'));
							setTimeout(function(){
								$('#btn_warn').trigger('click')
							},2000);
						}
					});
					break;
			}	
		})	
	});
</script>

