<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${msg!=null }">
 <script type="text/javascript">
	alert("${msg}");
 </script>
</c:if>
<script>
function todelect(){
	    var Checkbox=false;//默认复选框为空
	     $("input[name='id']").each(function(){//获取复选框节点id
	      if (this.checked==true) {        
	        Checkbox=true;    //已勾选
	      }
	    });
	    if (Checkbox){//boolean值为true
	        var t=confirm("您确认要删除选中的内容吗？");//弹出对话进行警告
	        if (t==false) return false;    //不勾选不处理
	        obj = document.getElementsByName("id");//将复选框定义成一个jquery对象
	        check_val = [];//定义一个数组
	        for(k in obj){//k相当于i,往这个jquery对象添加勾选的id;
	            if(obj[k].checked)//选中的都放进 数组里
	                check_val.push(obj[k].value);
	        }
	   
	        $.ajax({//利用ajax发出请求
	            type:"POST",//post类型
	            url:"user/deleteAllUser?ids="+check_val, //向Controller里的deleteSelect传输ids
	            success:function(data){//删除成功后，deleteMany会返回一个"ok";
	            if(data=="ok"){
	                alert("删除成功！");//返回ok后弹出一个对话框。
	                location.href="user/pages?currpage=1";//相当于刷新界面
	            }else{
		 alert("删除失败！");
	}
	        } 
	});
	      
	    }
	    else{
	        alert("请选择您要删除的内容!");//不勾选不提交，弹出警告框。
	        return false;
	    }
	    
	    
	}
</script>
<div id="waiter" style="padding-top: 1em">
	
	<!-- 按钮 -->
	<div style="position: absolute;">
	<form action="user/selectName">
		<input id="queryInput" name="name" type="text" placeholder="请输入查询内容" style="margin-top: -1em">
		
		<input class="btn btn-info btn-sm" id="btn_query" style="margin-top: -.4em" type="submit" value="搜索">
		</form>
	</div>
	<div class="btns" style="float: right;">
		
		<button class="btn btn-info btn-sm" id="btn_add">添加</button>
		<button  onclick="todelect()" class="btn btn-danger btn-sm" id="btn_batchDel">批量删除</button>
	</div>
	<!-- 数据表格 -->
	<div class="table_content">
		<table class="table table-sm table-bordered table-hover text-center">
		  <thead>
		    <tr>
		      <th scope="col"><input type="checkbox"></th>
		      <th scope="col">姓名</th>
		      <th scope="col">电话</th>
		      <th scope="col">密码</th>
		      <th scope="col">入职时间</th>
		      <th scope="col">角色</th>
		      <th scope="col">操作</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${users}" var="user">
		    <tr>
				      <td><input type="checkbox" value="${user.id}" name="id"></td>
				      <td>${user.userName}</td>
				      <td>110</td>
				      <td>${user.password}</td>
				      <td>${user.workTime}</td>
				      <td>${user.role.power}</td>
				      <td>
						<i class='iconfont icon-edit' id='edit'></i>
						<a class='iconfont icon-shanchu' id='del1' href="user/deleteUser?id=${user.id}"></a>
				      </td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<!-- 分页 -->
		
	</div>
	
	<div style="position: relative;display: flex;justify-content: flex-end;">
		<nav aria-label="Page navigation example" >
			<c:if test="${users.size()>1 || select==null}">
			  <ul class="pagination" onclick="pageChange(event)">

			    <li class="page-item">
			      <a class="page-link" href="user/pages?currpage=${sessionScope.pu.curPage-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li class="page-item"><a class="page-link" href="#">${sessionScope.pu.curPage}</a></li>
			    <li class="page-item">
			      <a class="page-link" href="user/pages?currpage=${sessionScope.pu.curPage+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
	  			</ul>
	  			</c:if>
			</nav>
	</div>
	
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
	        <form onsubmit="return false" action="user/addUser" id="myForm" method="post" enctype="multipart/form-data">
			  <div class="form-group row" id="name_err">
			    <label for="input_realname" class="col-sm-2 col-form-label">姓名<span class="name_err" style="color: red;">请输入至少一位字母</span></label>
			    <input type="text" class="form-control col-sm-10" id="input_realname" name="userName" placeholder="请输入姓名" style="margin-left: -.5em" autofocus>
			    <span id="name_error" style="display:none;color:red;margin-top: 4em;left: 8em;font-size: 10px;">用户名不能为空</span>
			  </div>
			  <div class="form-group row" id="password_err">
			    <label for="input_password" class="col-sm-2 col-form-label">密码<span class="password_err" style="color: red;">请输入至少一位数字</span></label>
			    <input type="password" class="form-control col-sm-10" id="input_password" name="password" placeholder="请输入密码" style="margin-left: -.5em">
			    <span id="password_error" style="display:none;color:red;margin-top: 4em;left: 8em;font-size: 10px;">密码不能为空</span>
			  </div>
			  <div class="form-group row" id="money_err">
			    <label for="input_money" class="col-sm-2 col-form-label">工资<span class="password_err" style="color: red;">请输入至少一位数字</span></label>
			    <input type="text" class="form-control col-sm-10" id="input_money" name="salary" placeholder="请输入工资" style="margin-left: -.5em">
			  </div>
			  <div class="form-group row" id="time_err">
			    <label for="input_time" class="col-sm-2 col-form-label">入职<span class="password_err" style="color: red;">请输入至少一位数字</span></label>
			    <input type="date" class="form-control col-sm-10" id="input_time" placeholder="请选择入职时间" name="workTime" style="margin-left: -.5em">
			  </div>
			  <div class="form-group row" id="roles_err">
			    <label for="input_roles" class="col-sm-2 col-form-label">权限<span class="password_err" style="color: red;">请输入至少一位数字</span></label>
			    <select style="border: 1px solid #ced4da;border-radius: 5px;width: 405px;margin-left: -.6em;color:#495057;" id="roles" defaultValue="" name="roleId">
                                            <option value="">请选择角色</option>
                                            <c:forEach items="${powers}" var="p">
                                            <option value="${p.id}">${p.power}</option>
                                            </c:forEach>
                </select>	
			  </div>
			   <div class="form-group row">
			    <label for="exampleFormControlFile1" class="col-sm-2 col-form-label">照片</label>
			    <input type="file" class="form-control-file col-sm-10" id="exampleFormControlFile1" name="avator" style="margin-left: -1em;padding-top:.4em">
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
	<!-- 模态框结束 -->
</div>
<!-- 批量删除 -->

 <script>
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
		$('#input_realname').blur(function(){
			if($('#input_realname').val()==""){
				var span=document.getElementById('name_error');
				span.style.display="block"
			}else{
				var span1=document.getElementById('name_error');
				span1.style.display="none"
			}
		})
		$('#input_password').blur(function(){
			if($('#input_password').val()==""){
				var span=document.getElementById('password_error');
				span.style.display="block"
			}else{
				var span2=document.getElementById('password_error');
				span2.style.display="none"
			}
		})
		// 添加或修改数据
		$('#addWaiter').click(function(){
			if($('#input_realname').val()!=""&&$('#input_password').val()!=""){
				var span1=document.getElementById('name_error');
				var span2=document.getElementById('password_error');
				span1.style.display="none"
				span2.style.display="none"
				document.getElementById('myForm').submit()
			}else{
				if($('#input_password').val()=="" && $('#input_realname').val()==""){
					var span=document.getElementById('password_error');
					span.style.display="block"
					var span1=document.getElementById('name_error');
					span1.style.display="block"
				}else if($('#input_realname').val()==""||$('#input_realname').val()==""){
					if($('#input_password').val()==""){
						var span=document.getElementById('password_error');
						span.style.display="block"
					}else{
						var span=document.getElementById('name_error');
						span.style.display="block"
					}
				}
			}
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
			}

			
		})
		
		// 显示模态框
		$('#btn_add').click(function(){
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
		$('#btn_query').click(function(event){
			console.log($('#queryInput')[0].value)
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



<style>
	.btns{
		margin-bottom: 1em;
	}
	.btns button {
		margin-right: 0.5em;
	}
	/*删除成功弹出框*/
	#mySuccessAlert{
		width: 200px;
		position: absolute;
		right: 5%;
		top: 8.5%;
		z-index: 100;
	}
	/*删除失败弹出框*/
	#myWarnAlert{
		width: 250px;
		position: absolute;
		right: 5%;
		top: 8.5%;
		z-index: 100;
	}
	/*模态框姓名栏*/
	#name_err{
		position: relative;
	}
	/*表单验证提示——姓名*/
	.name_err{
		display: none;
	}
	#name_err span{
		position: absolute;
		right: 0;
	}
	/*模态框电话栏*/
	#telephone_err{
		position: relative;
	}
	/*表单验证提示——电话*/
	.telephone_err{
		display: none;
	}
	#telephone_err span{
		position: absolute;
		right: 0;
	}
	/*模态框密码栏*/
	#password_err{
		position: relative;
	}
	/*表单验证提示——密码*/
	.password_err{
		display: none;
	}
	#password_err span{
		position: absolute;
		right: 0;
	}
</style>