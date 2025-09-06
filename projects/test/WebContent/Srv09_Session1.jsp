<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv09_Session1</title>
</head>
<body>
	<%
		String str = "ABCDEFG";
		// セッションにstrの値を格納(属性名:s1)
		session.setAttribute("s1", str);
		request.setAttribute("s2", "JKL");
		pageContext.setAttribute("s3", "XYZ");
	%>
	<a href="Srv09_Seesion2.jsp">Srv09_Seesion2</a>
	<br><br><br>
</body>
</html>