<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv10_Input</title>
</head>
<body>
	<form action="Srv10_Send.jsp" method="POST">
		<table border="1">
			<%-- <caotion>${sessionScope.msg}</caotion>--%>
			<caption>${requestScope.msg}</caption>
			<tr>
				<th>ユーザー名</th>
				<td>
					<%--<input type="text" name = "user" value="${sessionScope.user }"> --%>
					<input type="text" name = "user" value="${requestScope.user }">
				</td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td>
					<input type="text" name = "pass" value="${sessionScope.pass}">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="送信">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>