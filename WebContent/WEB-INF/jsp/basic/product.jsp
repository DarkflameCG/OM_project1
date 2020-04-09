<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>产品查询</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="../css/test1.css"
	rel="stylesheet" type="text/css">
<script src="../js/changetrcolor.js"
	type="text/javascript"></script>
</head>
<body>
   <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
	<tr>
		<TD class="page_title">产品查询</TD>
		<TD class="page_title_middle">&nbsp;</TD>
		<TD width=3><IMG height=32
			src="../images/m_mpr.gif" width=3></TD>
	</tr>
	</table>
	<form
		action=""
		method="post">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<th>名称</th>
				<td><input type="text" name="prod_name" /></td>
				<th>型号</th>
				<td><input type="text" name="prod_type" /></td>
				<th>批次</th>
				<td><input type="text" name="prod_batch" /></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="../help.html"><input class="common_button" type="button" value="帮助"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="common_button">查询</button>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
	<tr>
		<TD class="page_title">检索结果</TD>
		<TD class="page_title_middle">&nbsp;</TD>
		<TD width=3><IMG height=32
			src="../images/m_mpr.gif" width=3></TD>
	</tr>
	</table>
	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1>
		<tr>
			<th id="firstth">编号</th>
			<th>名称</th>
			<th>型号</th>
			<th>等级/批次</th>
			<th>单位</th>
			<th>单价（元）</th>
			<th>备注</th>
		</tr>
		
			<tr>
				<td class="list_data_number"></td>
				<td class="list_data_text"></td>
				<td class="list_data_text"></td>
				<td class="list_data_text"></td>
				<td class="list_data_text"></td>
				<td class="list_data_text"></td>
				<td class="list_data_text"></td>
			</tr>
	
		
		
		<tr>
			<th colspan="7" class="pager" align="right"
				style="padding-right: 20px;">
				<div class="pager">
					第页
					 <a
						href="">首页</a>
				
						<a
							href="">上一页</a>
			
						<font color="#ABA8AB">上一页</font>
				

				
						<a
							href="">下一页</a>
	
						<font color="#ABA8AB">下一页</font>
				
					<a
						href="">尾页</a>
				</div>
			</th>
		</tr>
	</table>
</body>
</html>