<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 	↑pageディレクティブ
		ディレクティブの構文：<%@~ 属性名="値" %>
	
	pageディレクティブ(directive)ではimport属性を使って
	Javaのライブラリのimportが可能
		<%＠page ~中略~ pageEncoding="UTF-8" import="java.util.*" %>
		import属性用に二つ目のpageディレクティブを記述してもよい
 --%>
 <%-- 
 	スクリプト:JSPないのJavaプログラムの記述
 			　　スクリプトの記述内で出力する場合
 					out.printlntln(出力対象);　と記述
  --%>
 
 <%!		// 宣言部の記述
 	int cnt = 0;
 	// 宣言部のみメソッドの定義が可能
 	// スクリプト内でメソッドを定義しても、定義として扱われない
 	// 		→実行も出来ない
 	String checkCnt() {
 		String str = "";
 		
 		if (cnt < 5) {
 			str = "cntは5未満です";
 		} else {
 			str = "cntが5以上になりました！";
 		}
 		return str;
 	}
 %>
 
<!DOCTYPE html>
<html>
	<head>
	<meta charset=UTF-8>
	<title>Srv05_Jsp</title>
	</head>
	<body>
		<%
			// cnt1ずつ増加
			cnt++;
		%>
		現在のcnt値は<%=cnt %><br>
		<%=checkCnt() %><br>
		<%=10 + 20 %><br>
		<%="A" + "B" %><br>
		<%=10 > cnt %><br>
		<h<%=cnt %>>見出し</h<%=cnt %>>
		<hr>
		<select>
			<option>リスト1</option>
			<option>リスト2</option>
			<option>リスト3</option>
		</select>
		<hr>
		<select>
		<% for(int i = 1; i < 10; i++) { %>
			<option>リスト<%=i %></option>
		<% } %>
		</select>
		<br>
		<table border="1">
			<tr>
				<td>AAA</td>
				<td>BBB</td>
			</tr>
			<!-- 繰り返す -->
			<!-- ↓スクリプトレット内にはJavaと同じ処理を記述可能 -->
			<% for (int i = 0; i < 3; i++) { %>
			<tr>
				<td>CCC</td>
				<td>DDD</td>
			</tr>
			<% } %>
		</table>
		<br>
		<h1>見出し1</h1>
		<h2>見出し2</h2>
		<%
			for (int i = 3; i <= 6; i++) {
				out.println("<h" + i + ">見出し</h" + i + ">");
			}
		%>
		<%
			for (int i = 0; i < 5; i++) {
				// iの値が偶数「ぐうすう」の場合(iを2で割ったよりがりが0=偶数)
				if (i % 2 == 0) {
		%>
			<img src="umatoma.jpg"><br>
		<%
				} else {
		%>
			<img src="dog.jpg"><br>
		<%
				}
			}
		%>
		↓JSPファイルを挿入<br>
		<%@include file = "Srv05_Inc.jsp" %>
		↑JSPファイルを挿入<br>
	</body>
</html>