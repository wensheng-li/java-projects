<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Srv06_Action_EL</title>
</head>
<%--
	JSPアクションタグ：あらかじめ決められた処理を実行するためのJSP専用のタグ
	アクションタグの構文：
		セットのタグ:  <jsp:アクション名 属性1＝"値" 属性2＝"値">
					　  </jsp:アクション名>
		非セットタグ: <jsp:アクション名 属性1＝"値" 属性2＝"値" />
	
	非セットの場合、終了タグの代わりにタグの最後に「/」を記述
	
	アクションタグの例: <jsp:forward page="遷移先のページ" />
						　jsp:forward→ページ遷移する
		遷移先のページにパラメータ(値)を渡す場合
			<jsp:forward page="遷移先のページ">
				<jsp:param name="パラメータ1" value="値" />
				<jsp:param name="パラメータ2" value="値" />
			</jsp:forward>
			
	ページの遷移方法について:
		・forward
			→同じサーバー内で情報を渡して遷移し、遷移先の結果を返す
			　(クライアントの要求1回→サーバーの応答1回)
		・redirect
		　　→サーバー(A)から応答を返す
		　　　　(応答の情報内に次の要求先(B)が含まれている)
		　　→クライアントは次の要求先(B)に要求を出す
		　　→次のサーバー(B)から応答を返す
		　　　(クライアントの要求1+1回(2回)→サーバーのお応答1(A)+1(B)回(2回))
			　この場合のサーバー(A/B)は同一でなくてもよい
			アドレス(URL)は次の要求先(B)が表示される
	
	遷移方法の違いを知ることで、データをの方法の違い(使い分け)を
	理解できるようになる(request, session, page, application)→後日説明します
	
	ページの遷移方法は
		・アクションタグ(<jsp:forward>)
		・リンク(<a>)
		・フォームの送信(action属性)
		・サーブレットのRequestDispatcher等が存在する
 --%>
 <%-- 
 	EL式について:Expression　Language→EL
 		値の出力などを簡単に行う方法
 		<%=値 %>　式スクリプト
 		${値}		　　EL式
 		<h<%=i %>>見出し</h<%=i %>>
 		<ｈ${i}>見出し</ｈ${i}>
 		
 		${変数名}，${式}，${オブジェクト.プロパティ}等の記述も可能
  --%>
  <%--　
  	EL式で使用可能算術「さんじゅつ」式、記号
  	算術: +, -, *, /(div), %(mod)
  	比較: ==(eq), !=(ne), <(lt), >(gt), <=(le), >=(ge)
  	倫理: &&(and), ||(or), !(not)
  	検証: empty
  			(プロパティ等を判定
  				→存在しない場合:true
  				存在する場合:falseを返す)
  					↓
  			存在する場合にtrueを返すようにするには
  				${!empty 判定対象｝
  			または
  				${not empty 判定対象｝
  	
  	使用例：
  		${100%7}, ${100mod7}
  		${10+15>20}, ${10+15gt20}
  		${10+15<20}, ${10+15lt20}
  		
  	EL式内で使用可能な暗黙「あんもく」オブジェクト
  	暗黙「あんもく」オブジェクト:定義しないで使用可能な変数
	  	pageScope　　　　　　ページ属性
	  	requestScope　　　　リクエス属性
	  	sessionScope　　　　セッション属性
	  	applicationScope　 アプリケーション属性
	  	pageContext　　　　 JSPのコンテキスト
	  	param　　　　　　　　　リクエストパラメータ(送信データ)
	  	paramValues　　　　 リクエストパラメータ(同じ送信名の値の配列)
   --%>
   
<body>

<%--<jsp:forward page="Srv05_Jsp.jsp" /> --%>
<%--
<jsp:forward page="Srv02_Param">
	<jsp:param name="p1" value="XXX" />
	<jsp:param name="p2" value="YYY" />
	<jsp:param name="p2" value="ZZZ" />
</jsp:forward>
 --%>
 
	 <%
	 	List<String> list = Arrays.asList("月曜日","火曜日","水曜日","木曜日","金曜日","土曜日","日曜日");
	 	//　Listコレクションのインスタンス(オブジェクト)に
	 	//　「li」という属性名を「」し、pageContextに格納
	 	//　→スクリプトレットで宣言した変数がEL式で使用可能になる
	 	pageContext.setAttribute("li", list);
	 	
	 	// Mapコレクション
	 	Map<String, String> map = new HashMap<>();
	 	// 変数mapに値を格納する場合
	 	// map.put(key,value);
	 	map.put("dog","ワオーン！");
	 	map.put("cat","シャー！");
	 	map.put("lion","ガオー！");
	 	map.put("pig","ブー！");
	 	pageContext.setAttribute("animal", map);
	 %>
	 <!-- EL式で出力 -->
	 li[3]:${li[3]}<br>
	 <!-- 式スクリプトで出力 -->
	 <%=list.get(3) %><br>
	 <hr>
	 動物の鳴き「なき」声<br>
	 <!-- 属性名.keyの形式でvalueを取得可能 -->
	 犬:${animal.dog }<br>
	 猫:${animal.cat }<br>
	 ライオン:${animal.lion }<br>
	 豚:${animal.pig }<br>
	 <!-- 属性名["key"]の形式でもvalueを取得可能 -->
	 犬:${animal["dog"] }<br>
	 猫:${animal["cat"] }<br>
	 ライオン:${animal["lion"] }<br>
	 豚:${animal["pig"] }<br>
	 <br>
	 豚のvalue=="ブー！": ${animal.pig eq "ブー！"}<br>
	 豚のvalue=="ブー！": ${animal.pig=="ブー！"}<br>
	 豚のvalue=="ブー": ${animal.pig=="ブー"}<br>
	 <hr>
	 <!-- http://localhost:8080/test/Srv06_Action_EL.jsp?p1=aaa&p2=bbb&p3=ccc&p3=ddd&p3=eee -->
	 暗黙オブジェクトの値を取得→出力<br>
	 param.p1: ${param.p1 }<br>
	 param.p2: ${param.p2 }<br>
	 paramValues.p3[0]: ${paramValues.p3[0] }<br>
	 paramValues.p3[1]: ${paramValues.p3[1] }<br>
	 paramValues.p3[2]: ${paramValues.p3[2] }<br>
	 <br>
	 
</body>
</html>