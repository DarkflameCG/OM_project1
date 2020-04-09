<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	//每一个jsp都需要加基准路径   basePath
 	 String basePath = request.getScheme()+"://"+
 								 request.getServerName()+":"+
 								 request.getServerPort()+
 								 request.getContextPath()+"/";
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>交往记录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript"
	src="script/jquery-1.4.1.js"></script>
	
</head>
<body>
  <div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
	<div class="button_bar">
		<a href="showhelp"><input
			class="common_button" type="button" value="帮助"></a>
		<a href="cust/addActivities"><button class="common_button">新建</button></a>
		<input class="common_button" type="button" value="返回" onclick="back()">
	</div>

	<br />

	<table class="data_list_table">
		<tr>
			<th>地点</th>
			<th>概要</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
			<tr>
				<td class="list_data_text"></td>
				<td class="list_data_ltext"></td>
				<td class="list_data_ltext"></td>
				<td class="list_data_op">
				 <img
					onclick="to('cust/editActivities');"
					title="编辑"
					src="images/bt_edit.gif"
					class="op_button" />
					
					<img
					onclick="to('');"
					title="删除"
					src="images/bt_del.gif"
					class="op_button" /></td>
			</tr>
	</table>
</body>
</html>