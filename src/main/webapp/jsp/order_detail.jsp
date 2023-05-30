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
<table border="1">
<tr>
	<th>商品コード</th><th>商品名</th><th>単価</th><th>数量</th>
</tr>
<c:forEach var="record" items="${details}">
	<tr>
		<td>${record.item.code}</td>
		<td>${record.item.name}</td>
		<td>${record.item.price}</td>
		<td>${record.quantity}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>