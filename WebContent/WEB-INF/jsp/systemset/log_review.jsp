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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="js/changetrcolor.js"
	type="text/javascript"></script>
</head>
<body>
   	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<td class="page_title">检索结果</td>
			<td class="page_title_middle">&nbsp;</td>
			<td width=3><IMG height=32
				src="images/m_mpr.gif" width=3></td>
		</tr>
	</table>
	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1 style="text-align: center;">
		<tr>

			<th id="firstth">时间</th>
			<th>操作员</th>
			<th colspan="3">事件</th>
		</tr>
			<tr>
				<td>
				</td>
				<td colspan="3"></td>
			</tr>
		
		<tr>
			<td colspan="3"><a href="">首页</a>
				
					<a href="">上一页</a>
			
					<font color="#ABA8AB">上一页</font>

				
			
					<a href="">下一页</a>
			
					<font color="#ABA8AB">下一页</font>
			
				
				<a href="">尾页</a>
				</td>
		  </tr>
		  
		<tr>
			<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
				<a href="help.html"><input
					class="common_button" type="button" value="帮助"></a>&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp; 
			</td>
		</tr>

	</table>
</body>
</html>