<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv08_Stats3_2</title>
</head>
<body>
	<%
		// 転送された属性名を取得
		// setAttribute()で属性名を付与→getAttribute()で取得
		String adds = (String)request.getAttribute("addstr");
		if (adds != null) {
	%>
			<%=adds %><br>
	<% } %>
	<%
		// 送信されたデータを取得
		String send_t1 = request.getParameter("t1");
		// 属性名を付与
		pageContext.setAttribute("s_t1", send_t1);
	%>
	取得した送信データに属性名を付与し、出力<br>
	s_t1: ${s_t1}<br><br>
	転送前のJSPで付与した属性名で出力<br>
	addstr: ${addstr }<br>
	<hr>
	送信データをそのまま受け取る<br>
	param.t1: ${param.t1 }<br>
	Srv08_Stats3.jsp属性名を付与した値は、<br>
	param.属性名で受け取れるか確認<br>
	param.addstr: ${param.addstr }<br>
	<hr>
	<%
		// Srv08_Stats3.jspで属性名を付与、転送した値は
		// getParameter("")で取得できるか確認
		String ads = request.getParameter("addstr");
		pageContext.setAttribute("adds", ads);
	%>
	adds: ${adds }<br>
</body>
</html>