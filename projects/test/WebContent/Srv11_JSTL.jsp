<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<%--
	=========
	JSTLの基本構文
	=========
	非セット	<名前空間:処理名　属性名="値">
				非セットの場合、最後に「/」が必要
				(→JSP独自のタグで非セットの場合、「/」を記述するJSTL,アクションタグ)
	セットの場合の記述は省略
	-------------------
	coreカテゴリの処理:
	-------------------
		<c:out>				変数やオブジェクトを出力
		<c:set>				変数やオブジェクトに値を設定
		<c:remove>		変数やオブジェクトを削除
		<c:if>				条件分岐、条件成立時の処理を内容に記述
		<c:choose>		条件分岐、whenやotherwiseと組み合わせて使用
		<c:when>			条件成立時の処理を内容に記述
		<c:otherwise>	全てのwhenの条件が非成立時の処理を記述
		<c:forEach>		配列やリストの繰り返し処理
		<c:forTokens>		文字列を句切文字でで分割して個別処理
		<c:param>		パラメータを指定
		<c:import>		指定したリソースを取り込む
								外部コンテンツ（HTML, JSP, テキストなど）を読み込み。
								url, charEncoding, var などの属性で制御。
		<c:redirect>		指定したアドレスにリダイレクトする(させる)
		
	-----------------	
	fmtカテゴリの処理
	-----------------
		<fmt:formatNumber>		数値の出力形式を指定
		<fmt:formatDate>			日付時刻「じこく」データをの出力形式を指定
		<fmt:parseNumber>		文字列を数値データに変換
		<fmt:parseDate>			文字列を日付時刻データに変換
	
	formatNumberのpattern属性について：
		pattern="〇〇;●●"
		〇〇:正の値のパターン
		●●:負の値のパターン
		pattern内の記号:
		#: 数値、０は省略	(###，###.000←1620.54の場合)
		0:  数値、0も出力		→1620.540）
		;:  正の値と負の値のパターン区切
		
	formatDateのpattern属性について:
		pattern内の記号(文字):
		y:年			M:月				d:日			E:曜日
		a:AMPM		H:0~23時		h:0~11時
		m:分			s:秒
		w:年間のN週目(2025/09/05→32週目→32)
		W:月間のN週目(2025/09/05→1週目→1)
		D:年間のN日目		F:第Ｎ～曜日のN
	ーーーーーーーーーーーーーーーーーーーーーー	
	fnカテゴリ(EL式内での使用する関数)の処理
	ーーーーーーーーーーーーーーーーーーーーーー
		fn:	contains						指定文字が含まれるか
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:containsIgnoreCase		指定文字が含まれるか(大文字小文字問わず)
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:indexOf						指定文字列の出現位置
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:trim							前後ンお空白の削除
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:join							配列を結合(区切り文字を追加)
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:split							joinの逆、分割
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:replace						配列置換
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:length						文字列長、配列やコレクションのデータ数の取得
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:substring					文字列の一部抜粋「ばっすい」
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:substringAfter				指定位置以降の抜粋「ばっすい」
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:substringBefore			指定位置以前の抜粋「ばっすい」
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:toLowerCase				小文字変換
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:toUpperCase				大文字変換
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		fn:escapeXml					タグの無害化
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		<c:out>とEL式の出力について
		<c:out value="${変数名}" />
		${変数名}
		両方変数の値を出力する→EL式のみで良いのでは？
			→状況(値)によって同じ結果にならないものもある(後述「こうじゅつ」)
 --%>
<meta charset=UTF-8>
<title>Srv11_JSTL</title>
</head>
<body>
<%--値の設定、変数numに5を代入 --%>
<%--
	var:変数名の指定、value:変数に設定する値、出力対象
 --%>
 <c:set var="num" value="3" />
 値の出力<br>
 (EL式あり)<c:out value="${num}" /><br>
 <%-- 
 	numを変数として指定する場合、EL式を使う。EL式を使わない場合、文字列「num」を出力 
 --%>
 (EL式なし)<c:out value="num" /><br>
 <hr>
 <%-- 値の設定2 --%>
  <c:set var="str" value="ABC" />
  値の出力2<br>
  <c:out value="${str}" /><br>
  <%--　分岐「ぶんき」 --%>
  条件分岐<br>
  <%--　条件式はtest属性に記述 --%>
  	<c:if test="${num>3 }">
  		numは3より大きい<br>
  	</c:if>
  <%--
  	c:ifの条件非成立時の処理を記述する必要がある場合、
  	逆の条件のc:ifを記述する必要がある
  	(if文のelseに該当するものがない)
   --%>	
   <c:if test="${num<=3 }">
   	numは3以下<br>
   </c:if>
   条件分岐2<br>
   <c:choose>
   <%--
   	<c:when>は複数記述した場合、先頭から順に判定条件成立した<c:when>の内容を実行後、
   	<c:choose>の下に進む
   	条件成立した<c:when>がない場合、<c:otherwise>の内容を実行する
    --%>
    <c:when test="${num>5 }">
    	numは5より大きい<br>
    </c:when>
    <c:when test="${num>3 }">
    	numは(5以下かつ)３より大きい<br>
    </c:when>
    <c:otherwise>
    	numは3以下<br>
    </c:otherwise>
   </c:choose>
   <hr>
   
   <%
   		// Listコレクションに初期値を格納
   		List<String> list = Arrays.asList("ラーメン","カレー","ハンバーグ", "そば", "おかゆ");
   
   		// int(整数)型の配列に初期値を格納
   		int[] arr1 = {100,200,333,444,5555,6660,77,888,9,1};
   		// HashMapコレクションのインスタンスを生成
   		// keyの型：String,valueの型：String
   		Map<String, String> map = new HashMap<>();
   		// HashMapコレクションのインスタンス(map)に値を追加
   		map.put("cc", "コーヒー");
   		map.put("bb", "ビール");
   		map.put("tt", "紅茶");
   		// コレクションと配列に属性を付与
   		pageContext.setAttribute("li", list);
   		pageContext.setAttribute("ar", arr1);
   		pageContext.setAttribute("mp", map);
   %>
   <hr>
   listを繰り返し処理<br>
   <%--
   		items→コレクションや配列を指定
   		var→1つずつのデータを格納する変数名の指定
    --%>
    <c:forEach items="${li}" var = "d">
    	<c:out value="${d}" /><br>
    </c:forEach>
    配列を繰り返し処理1<br>
    <c:forEach items="${ar}" var = "num">
    	<c:out value="${num}" /><br>
    </c:forEach>
    
    配列を繰り返し処理2(状態確認)<br>
    <%--
    		varStatus：繰り返し処理の状態、属性を格納
    		current：varに格納した現在のオブジェクト
    		index：index番号
    		count：処理件数(1~)
    		first：ループの先頭かどうか(true/false)
    		last：ループの最後かどうか(true/false)
    		begin：begin属性の値
    		end：end属性の値
    		step：step属性の値
     --%>
    <c:forEach items="${ar}" var = "num" varStatus="st">
    	<c:out value="${st.current}" />,
    	<c:out value="${st.index}" />,
    	<c:out value="${st.count}" />,
    	<c:out value="${st.first}" />,
    	<c:out value="${st.last}" /><br>
    </c:forEach>
    <hr>
    条件を指定して繰り返し処理<br>
    <c:forEach items="${ar}" var = "num" varStatus="st" begin="1" end="8" step="2">
    	<c:out value="${st.current}" />,
    	<c:out value="${st.index}" />,
    	<c:out value="${st.count}" />,
    	<c:out value="${st.first}" />,
    	<c:out value="${st.last}" />
    	<c:out value="${st.begin}" />,
    	<c:out value="${st.end}" />,
    	<c:out value="${st.step}" /><br>
    </c:forEach>
    <hr>
    <%-- 文字列の設定 --%>
    <c:set var="arr" value="a@v@c@d@e@f@g@h" />
    <%-- 
    	token：コマ、駒「こま」
    	ゲームなどのカウンタとして使用したりする、小さいチップようなもの
     --%>
     <br>文字列を区切り文字で分割<br>
     <c:forTokens items="${arr}" var="dt" delims="@">
     	<c:out value="${dt}" /><br>
     </c:forTokens>
     
     <%--
     		<c:forTokens>もvarStatus属性の指定可能
      --%>
      ↓import↓<br>
      <c:import url="Srv05_Inc.jsp" />
      ↑import↑<br>
      <%--
      		<c:import>や<c:redirect>で指定したURLが
      		送信データを必要とする場合、<c:param>を使って指定する 
      --%>
      <%--
      <c:redirect url="Srv06_Action_EL.jsp">
      	<c:param name="p1" value ="aa1" />
      	<c:param name="p2" value ="bb2" />
      	<c:param name="p3" value ="cc3" />
      	<c:param name="p3" value ="dd4" />
      	<c:param name="p3" value ="ee5" />
      </c:redirect>
       --%>
       <hr>
       <%-- 値の設定 --%>
       <c:set var="dnum" value="-1694.2466" />
       c:out出力<br>
       <c:out value="${dnum }" /><br>
       fmt:formatNumber(初期値)<br>
       <fmt:formatNumber value="${dnum}" /><br><br>
       <%--
       		<fmt:formatNumber>の初期値設定の幼児
       		→数値として表示
       			・整数値の3桁区切り要の「,」を表示
       			・小数点第3位までの表示(第4位は姿勢五入で丸める)
        --%>
        fmt:formatNumber<br>
        pattern: △###,###.0000; ▼###,###.0000<br>
        <fmt:formatNumber value="${dnum}"  pattern="△###,###.0000; ▼###,###.0000" /><br>
        maxIntD:3,  maxFracD:3<br>
        <fmt:formatNumber value="${dnum }" maxIntegerDigits="3" maxFractionDigits="3" /><br>
        <%--
        	maxIntegerDigits:整数値の最大桁数
        	maxFractionDigits: 小数点の最大桁数
         --%>
         <hr>
         <%-- 現在の日付時刻 --%>
         <%--　dateという変数を宣言(インスタンスを生成)型はjava.util.Date --%>
         <jsp:useBean class="java.util.Date" id="date"></jsp:useBean>
         <%--
         	<jsp:useBean class="変数の型" id="変数名"　/>
         	→上記のインスタンス生成をスクリプトレットで記述した場合
         	java.util.Date date = new java.util.Date();
         	pageContext.setAttribute("date", date);
          --%>
</body>
</html>