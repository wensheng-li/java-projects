<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv10_Send</title>
</head>
<body>
	<%
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		if (user.equals("xxx") && pass.equals("yyy")) {
			// ユーザー名：xxx，パスワード:yyyの場合だけ処理
			//session.setAttribute("user", user);
			request.setAttribute("user", user);
			session.setAttribute("pass", pass);
			//session.setAttribute("msg", "ユーザー名とパスワードが違います");
			request.setAttribute("msg", "ユーザー名とパスワードが違います");
	%>
		<jsp:forward page="Srv10_Input.jsp" />
	<% } %>
	user: ${param.user}<br>
	pass: ${param.pass}<br>
</body>
</html>