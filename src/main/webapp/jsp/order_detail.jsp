<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文一覧</title>
</head>
<body>
<h1>注文一覧</h1>
<hr>
<c:if test="${empty details}">
購入する商品がありません。<br>
</c:if>

<c:if test="${not empty details}">
<table border="1">
<tr>
	<th>商品コード</th><th>商品名</th><th>単価</th><th>数量</th><th>小計</th><th></th>
</tr>
<c:forEach var="record" items="${details}" varStatus="status">
	<form action="/shopping_git/control" method="get">
		<input type="hidden" name="ACTION" value="ORDER_DELETE">
		<input type="hidden" name="NUMBER" value="${status.index}">
		<tr>
			<td>${record.item.code}</td>
			<td>${record.item.name}</td>
			<td>${record.item.price}</td>
			<td>${record.quantity}</td>
			<td>${record.item.price * record.quantity}</td>
			<td><input type="submit" value="削除"></td>
		</tr>
	</form>
</c:forEach>
<tr>
	<td colspan="5">合計</td><td>${total}</td>
</tr>
</table>
</c:if>

<a href="/shopping_git/control?ACTION=CUSTOMER_INPUT&FRUIT=apple">りんご</a>
<a href="/shopping_git/control?ACTION=CUSTOMER_INPUT&FRUIT=orange">みかん</a>
<br>
<a href="/shopping_git/control?ACTION=ITEM_LIST">商品一覧へ</a>

</body>
</html>