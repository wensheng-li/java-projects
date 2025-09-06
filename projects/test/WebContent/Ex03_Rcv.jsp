<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Ex03_Rcv</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>名前</th>
			<td>${param.t1}</td>
		</tr>
		
		<% if (request.getParameter("cb1") != null) { %>
		<tr>
			<th>趣味(EL式)</th>
			<td>${param.cb1}</td>
		</tr>
		<% } %>
		<!-- This is not working -->
		<%--
		${not empty param.cb1? "<tr><th>趣味</th><td>" : "" }
		${param.cb1}
		${not empty param.cb1? "</td></tr>":"" }
		 --%>
	</table>
</body>
</html>