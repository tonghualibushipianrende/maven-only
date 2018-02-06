<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form id="update_form">
<input type="hidden" name="goodsId" value="${goods.goodsId }"/>
	<table border="100" cellspacing="0" cellpadding="0" bgcolor="red" align="center">
		<tr align="center">
			<td>商品名称：</td>
			<td><input name="goodsName" value="${goods.goodsName }"/></td>
		</tr>
		<tr align="center">
			<td>商品价格：</td>
			<td><input name="goodsPrice" value="${goods.goodsPrice }"/></td>
		</tr>
		<tr align="center">
			<td>商品库存：</td>
			<td><input name="goodsCount" value="${goods.goodsCount }"/></td>
		</tr>
		<tr align="center">
			<td>出厂时间：</td>
			<td><input  class="Wdate"  type="text"  name="goodsTime" onClick="WdatePicker()" value="${goods.goodsTimeStr }"></td>
		</tr>
		<tr align="center">
			<td>商品类型：</td>
			<td>
				<select name="typeId">
					<option value="-1">--请选择--</option>
					<option value="1" ${goods.typeId==1?"selected":"" }>智能家居</option>
					<option value="2" ${goods.typeId==2?"selected":"" }>床上用品</option>
					<option value="3" ${goods.typeId==3?"selected":"" }>电子数码</option>
					<option value="4" ${goods.typeId==4?"selected":"" }>体育用品</option>
					<option value="5" ${goods.typeId==5?"selected":"" }>户外运动</option>
				</select>
			</td>
		</tr>
	</table>
</form>

</body>
</html>