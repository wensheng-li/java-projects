<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Ex02_Rcv</title>
<!-- 
	セレクタ{
		設定項目:値;
		設定項目:値;
	}
	セレクタ:設定対象を指定する
			　要素セレクタ、id名セレクタ、クラス名セレクタ等
	要素セレクタ:     タグ名を記述
	id名セレクタ:     #id名を記述
	クラス名セレクタ: .クラス名を記述
	
	セレクタ毎の優先度→対象が限定されるせセレクタの方が設定優先される
							　同一優先度の場合、下に記述した設定が反映される
	高い		→		低い	
	要素>>id名>>クラス
 -->
 <style>
 	table,td {
 		border: 5px solid black;
 	}
 	
 	#td1 {
 		border: 2px dotted red;
 	}
 	
 	#td1 {
 		border: 2px dashed green;
 	}
 	
 </style>
</head>
<body>
	<table>
		<tr>
			<th>名前</th>
			<td>${param.t1 }</td>
		</tr>
		<tr>
			<th id="td1">血液型</th>
			<td>${param.r1 }</td>
		</tr>
	</table>
</body>
</html>