<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
<h1>商品一覧</h1>
<hr>
<table border="1">
<tr>
	<th>商品コード</th><th>商品名</th><th>単価</th><th>数量</th><th></th>
</tr>

<c:forEach var="record" items="${LIST}">
	<tr>
		<td>${record.code}</td>
		<td>${record.name}</td>
		<td>${record.price}</td>
		<td>
			<select name="QUANTITY">
				<c:forEach var="i" begin="1" end="10">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
		</td>
		<td>ボタン</td>
	</tr>
</c:forEach>

</table>
</body>
</html>