<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/artDialog-master/css/ui-dialog.css">
<script src="<%=request.getContextPath()%>/js/artDialog-master/dist/dialog-plus-min.js"></script>
</head>
<body>
<form>
	<table border="100" cellspacing="0" cellpadding="0" bgcolor="pink" align="center">
		<tr align="center">
			<td>商品ID</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品库存</td>
			<td>出厂时间</td>
			<td>商品类型</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${goodsList }" var="goods">
			<tr align="center">
				<td>${goods.goodsId }</td>
				<td>${goods.goodsName }</td>
				<td>${goods.goodsPrice }</td>
				<td>${goods.goodsCount }</td>
				<td>${goods.goodsTimeStr }</td>
				<td>
					<c:if test="${goods.typeId==1 }">智能家居</c:if>
					<c:if test="${goods.typeId==2 }">床上用品</c:if>
					<c:if test="${goods.typeId==3 }">电子数码</c:if>
					<c:if test="${goods.typeId==4 }">体育用品</c:if>
					<c:if test="${goods.typeId==5 }">户外运动</c:if>
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteGoods(${goods.goodsId })"/>
					<input type="button" value="修改" onclick="toUpdateGoods(${goods.goodsId })"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
<script type="text/javascript">
	function deleteGoods(id){
		$.ajax({
			url:"<%=request.getContextPath()%>/goods/deleteGoods.do",
			type:"post",
			data:{"goodsId":id},
			dataType:"text",//规定返回值格式
			async:false,//同步上传
			success:function (data){//成功回调函数
				alert("删除成功！");
				location.href="<%=request.getContextPath()%>/goods/toListPage.do";
			},
			error :function(){//错误回调函数
			alert("删除错误,请联系管理员")
			}
			});
	}
	function toUpdateGoods(id){
		var updateHtml;
		$.ajax({
			url:"<%=request.getContextPath()%>/goods/toUpdateGoods.do",
			type:"post",
			data:{"goodsId":id},
			dataType:"text",//规定返回值格式
			async:false,//同步上传
			success:function (data){//成功回调函数
				updateHtml=data;
			},
			error :function(){//错误回调函数
			alert("删除错误,请联系管理员")
			}
			});
		var update_from= dialog({
			title:'修改商品',
			content: updateHtml,
			okValue:'确 定',
			ok:function () {
			updateGoods();
			},
			cancelValue:'取消',
			cancel:function () {
			this.title('已经取消..',1);
			}
			});
		    update_from.show();

	}
	
	function updateGoods(){
		$.ajax({
			url:"<%=request.getContextPath()%>/goods/updateGoods.do",
			type:"post",
			data:$("#update_form").serialize(),
			dataType:"text",//规定返回值格式
			async:false,//同步上传
			success:function (data){//成功回调函数
				alert("修改成功！");
			},
			error :function(){//错误回调函数
			alert("错误,请联系管理员")
			}
			});
	}
</script>
</html>