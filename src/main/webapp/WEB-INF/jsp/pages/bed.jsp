<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script>
	/* 页面逻辑 */
	$(function(){
		var url = "/room/get/"+$(this).val();
		$("select").on("change",function(){
			var url = "/room/get/"+$(this).val();
			console.log(url);
			var oForm = $("#form1");
			oForm.attr("action",url);
			oForm.submit();		
		});
		//$.get(url);
	})
</script>
<div id="bed" style="padding-top: 1em">
	<form id="form1" action="" method="get">
	<span>楼层选择 </span>
		<select name="floor" id="" style="width:150px;border: 2px solid black;height: 30px;">
			<option selected="selected" value="1">一楼</option>
			<option value="2">二楼</option>
			<option value="3">三楼</option>
		</select>
	</form>
	<!-- jstl -->
	<!-- 1-5号房间 -->
	<div style="width:100%;display: flex;justify-content: space-around;margin-top: 1em">
		<c:forEach items="${bedlist}" var="list1" begin="0" end="4">
			<div style="width: 200px;height: 200px;background-color: green;display: flex;flex-direction: column;">
				<c:forEach items="${list1 }" var="bed">
					<c:if test="${bed.roomState==1 }">
						<div style="width:100px;background-color: red;height: 50px;margin: 0 auto;margin-top: 2em">${bed.roomNumb }</div>
					</c:if>
					<c:if test="${bed.roomState==2 }">
						<div style="width:100px;background-color: yellow;height: 50px;margin: 0 auto;margin-top: 2em">${bed.roomNumb }</div>
					</c:if>
				</c:forEach>
				
			</div>
		</c:forEach>	
	</div>
	<div style="width: 100%;text-align: center;">
		<h1>过道</h1>
	</div>
	<!-- 6-10号房间 -->
	<div style="width:100%;display: flex;justify-content: space-around;margin-top: 1em">
		<c:forEach items="${bedlist}" var="list2" begin="5" end="9">
			<div style="width: 200px;height: 200px;background-color: green;display: flex;flex-direction: column;">
				<c:forEach items="${list2 }" var="bed">
					<c:if test="${bed.roomState==1 }">
						<div style="width:100px;background-color: red;height: 50px;margin: 0 auto;margin-top: 2em">${bed.roomNumb }</div>
					</c:if>
					<c:if test="${bed.roomState==2 }">
						<div style="width:100px;background-color: yellow;height: 50px;margin: 0 auto;margin-top: 2em">${bed.roomNumb }</div>
					</c:if>
				</c:forEach>
			</div>
		</c:forEach>	
	</div>
</div>