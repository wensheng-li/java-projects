<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Ex01_Rev</title>
</head>
<body>
	<%
		// スクリプトレットで送信データを受け取る場合
		String str = request.getParameter("t1");
		String sel = request.getParameter("sel1");
		// String[] sel = request.getParameterValues("sel1");
		
		out.println("T1: " + str + "<br>");
		out.println("Sel1: " + sel + "<br>");
		
		// A-2: スクリプトレット内で属性名を設定
		pageContext.setAttribute("attr_t1", str);
		pageContext.setAttribute("attr_sel1", sel);
	%>
	<hr>
	<!-- A-2: 属性名をEL式で出力-->
	attr_t1: ${attr_t1 }<br>
	attr_sel1: ${attr_sel1 }<br>
	<hr>
	<!-- A-3: 式スクリプトで出力-->
	t1: <%=str %><br>
	sel1: <%=sel %><br>
	<hr>
	<%-- B: EL式で暗黙オブジェクトの値を取得→出力 --%>
	param.str: ${param.t1 }<br>
	param.sel1: ${param.sel1 }<br>
</body>
</html>