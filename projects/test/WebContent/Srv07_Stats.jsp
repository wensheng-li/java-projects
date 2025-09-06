<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv07_Stats</title>
</head>
<body>
	<%
		// 送信データをスクリプトレットで受け取る場合
		String str = request.getParameter("p1");
		// 送信データが0文字の文字列か判定
		if (str.equals("")) {
			// 0文字の文字列だった場合
			str = "0文字でした";
		} else if (str.equals("xxx")) {
			// xxxだった場合、データを変更
			str = "yyyyyy";
		}
		// スクリプトレットで宣言した変数(str)をEL式で使用する場合
		pageContext.setAttribute("s1", str);
	%>
	<!-- スクリプトレット内の変数で、値を取得できないことを確認 -->
	str: ${str }<br>
	<!-- 変数に付与「ふよ」した属性名使って出力 -->
	s1: ${s1 }<br>
	<!-- スクリプトレットで送信データを受け取らず、直接EL式で使用 -->
	param.p1: ${param.p1 }<br>
</body>
</html>