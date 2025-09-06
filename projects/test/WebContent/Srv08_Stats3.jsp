<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv08_Stats3</title>
</head>
<body>
<%
	String str = request.getParameter("t1");
	// t1の送信ー出たが0文字か判定
	if (!str.equals("")) {
		// 0文字ではない場合、送信データに文字列を追加
		str += "追加の値";
		// リクエスト属性に値を格納(属性名を付与)
		request.setAttribute("addstr", str);
	}
%>

<%-- 転送 --%>
<jsp:forward page="Srv08_Stats3_2.jsp" />

</body>
</html>