<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv09_Seesion2</title>
</head>
<body>
	<%
		// 格納したセッション情報を取得
		// 格納時の情報
		// 　String str ＝"ABCDEFG"
		// session.setAttribut("s1",str);
		// 取得の際はString→Object型になっている
		Object obj = session.getAttribute("s1");
		// 文字列型(String)にしたい場合、強制型変換が必要
		String s  = (String)obj;
		// EL式で使用できるように属性名を付与
		pageContext.setAttribute("sss", s);
		// 違う暗黙オブジェクトで属性名を付与:"ssxx"→設定されている属性名です
		request.setAttribute("ssxx", s);
		
		String ss2 = (String)request.getAttribute("s2");
		request.setAttribute("s2", ss2);
		String ss3 = (String)pageContext.getAttribute("s3");
		pageContext.setAttribute("s3", ss3);
	%>
	ss2: <%=ss2 %><br><br>
	ss3: <%=ss3 %><br><br>
	<hr>
	sss: ${sss }<br><br>
	ssxx: ${ssxx }<br><br>
	s1: ${s1 }<br><br>
	<hr>
	sessionScope.s1: ${sessionScope.s1 }<br><br>
	requestScope.s1: ${requestScope.s1 }<br><br>
	pageScope.s1: ${pageScope.s1 }<br><br>
	<hr>
	sessionScope.sss: ${sessionScope.sss }<br><br>
	requestScope.sss: ${requestScope.sss }<br><br>
	pageScope.sss: ${pageScope.sss }<br><br>
	<hr>
	sessionScope.ssxx: ${sessionScope.ssxx }<br><br>
	requestScope.ssxx: ${requestScope.ssxx}<br><br>
	pageScope.ssxx: ${pageScope.ssxx }<br><br>
	<hr>
	<%-- 
		Srv09_Session1格納したs2,s3の値を~Scopeの形式で取得するには？
	 --%>
	 sessionScope.s2: ${sessionScope.s2 }<br><br>
	 requestScope.s2: ${reqeustScope.s2 }<br><br>
	 pageScope.s2: ${pageScope.s2 }<br><br>
	 sessionScope.s3: ${sessionScope.s3 }<br><br>
	 requestScope.s3: ${reqeustScope.s3 }<br><br>
	 pageScope.s3: ${pageScope.s3 }<br><br>
	 <hr>
	 
</body>
</html>