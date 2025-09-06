package test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Srv01_Tag
 */
@WebServlet(description = "HTMLタグを学習ために", urlPatterns = { "/Srv01_Tag" })
public class Srv01_Tag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv01_Tag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * =============
		 * HTMLタグの記述を追加
		 * =============
		 * HTMLタグは大文字、小文字は同じ扱うになる
		 * ページの先頭に記述するタグ：<!DOCTYPE　html>
		 * Webページの記述タグのバージョン指定になる(上記はHTML5)
		 * 
		 * 全体範囲を囲む「かこむ」<html></html>
		 * Webページ内の設定のタグをまとめる<head></head>
		 * Webページに表示する内容をまとめる<body></body>
		 * 
		 * <!DOCTYPE html>
		 * <html>
		 * 		<head></head>
		 * 		<body></body>
		 * </html>
		 * 
		 * ==============================
		 * <head>内のタグ
		 * 		<meta>ページの設定を記述
		 * 		<link>	ページに取り込むリソースの設定
		 * 		<title></title>　Webブラウザの表示する見出し
		 * 		<style>　ページ、タグのデザインを決める
		 * 			<head>内のタグで内容をWebブラウザ上で確認できるのは<title>のみ
		 */
		// サーブレットで変換する際の文字コードを指定
		// response.getWriter()前に行う
		response.setCharacterEncoding("UTF-8");
		
		// 入力中の候補「こうほ」リストの表示/入力補完「ほかん」→ctrl+space
		// PrintWriterはimport java.io.PrintWriter;記述が必要
		//					 ~~~~~~~~~~~~~~~~
		// 自動的にimportの記述を追加する方法→crtl+shift+o
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=UTF-8>");
		out.println("<title>Srv01_Tag</title>");
		out.println("</head>");
		/*
		 * <BODY>内のタグ
		 * 種類が多いので、一部抜粋「ばっすい：取り出す」
		 * 表形式で表示
		 * <table></table>　表形式の内容全体を囲む
		 * <tr></tr>　行を囲むTable Row
		 * <th></th>　セル(見出し)を囲む→(<tr>内に記述)Table Head
		 * <td></td>　セル(データ)を囲む→(<tr>内に記述)Table Data
		 * <caption></caption>　表全体の見出しを囲む(<table>内に記述)
		 * 
		 * 【タグの記述と呼び方について】
		 * <タグ名>内容</タグ名>　←～タグ
		 * 　　↑				　↑
		 * 開始タグ	　↑　終了タグ		
		 * 　　　　　タグ内容
		 * 
		 * <title>Srv01_Tag</title>
		 * 
		 * <title>タグの　　　　　<title>タグの
		 * 開始タグ	　↑　　　　　終了タグ		
		 * 　　　　<title>タグの
		 * 　　　　　　タグ内容 
		 * ====================================
		 * 
		 * table
		 * ┣caption
		 * ┣tr
		 * ┃┣th
		 * ┃┣th
		 * ┃┣…
		 * ┣tr
		 * ┃┣td
		 * ┃┣td
		 * ┃┣…
		 * ┣tr
		 * ┣…
		 */
		// out.println()の出力対象は
		// 文字列として変数に格納していもよい
		String tbl1 = "<table border = '1'>"
				+ "<caption>thタグでA,Bを囲む</caption>"
				+ "<tr><th>A</th><th>B</th></tr>"
				+ "<tr><td>CCC</td><td>DDD</td></tr>"
				+ "</table>";
		
		String tbl2 = "<table border = '1'>"
				+ "<caption>tdタグでA,Bを囲む</caption>"
				+ "<tr><td>A</td><td>B</td></tr>"
				+ "<tr><td>CCC</td><td>DDD</td></tr>"
				+ "</table>";
		String t1 = "<t3>>>>> Tableで表示 <<<<</t3>";
		out.println("<body>");
		out.println(t1);
		out.println(tbl1);
		out.println(tbl2);
		/*
		 * リスト形式で表示
		 * <ol></ol>　順序付きリストOrdered List
		 * <ul></ul>　順不同リストUnordered List
		 * <li></li>　　死すと項目List(<ol>、<ul>の内容として記述)
		 */
		String li1 = "<ol>" 
				+ "<li>りんご</li>"
				+ "<li>みかん</li>"
				+ "<li>バナナ</li>"
				+ "</ol>";
		
		String li2 = "<ul>" 
				+ "<li>りんご</li>"
				+ "<li>みかん</li>"
				+ "<li>バナナ</li>"
				+ "</ul>";
		String t2 = "<br><t3>>>> リストで表示 <<<<</t3>";
		out.println(t2);
		out.println(li1);
		out.println(li2);
		
		// 文字列を段落「だんらく」にまとめる(段落の前後に空白行を表示)
		//　<ｐ></ｐ>　Paragraph
		String p1 = "<p>"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "</p>";
		String p2 = "<p>"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいい<br>えええええおおおおお<br>"
				+ "あああああいいいいい<br>えええええおおおおお<br>"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "あああああいいいいいえええええおおおおお"
				+ "</p>";
		out.println("<br><t3>>>> Paragraph・段落で表示 <<<<</t3>");
		out.println(p1);
		out.println(p2);
		
		/*
		 * 内容を見出しとして扱う
		 * <h1></h1><h2></h2>…<h6></h6>Header1
		 */
		String hd = "<h1>見出し1</h1><h2>見出し2</h2>"
				+ "<h3>見出し3</h3><h4>見出し4</h4><h5>見出し5</h5>"
				+ "<h6>見出し6</h6>";
		out.println("<br><t3>>>> Headerで表示 <<<<</t3>");
		out.println(hd);
		
		/*
		 * リンクをせってする
		 * <a></a>　リンクを設定Anchor(錨：いかり)
		 * 				　　リンク：内容をクリックするとほかのページやサイトに遷移
		 * 						　　遷移先はhref属性「ぞくせい」に設定
		 */
		String link = "<a href = 'HelloServlet'>リンク文字列</a>"
				+ "<br>"
				+ "<a href = 'http://www.yahoo.co.jp'>Yahoo!</a>";
		out.println("<br><t3>>>> リンクで表示 <<<<</t3><br>");
		out.println(link);
		
		/*
		 * 属性について
		 * たぐの種類だけでは情報が足りない場合
		 * 設定の記述を行う場合に、タグ内に属性を指定する
		 * 属性の記述が行われない場合、設定内容は初期値になる
		 * 1つのタグに複数の属性を記述することも可能
		 * 
		 * <タグ名 属性名＝値 属性名＝値>
		 * 属性名の例
		 * id				設定した値はid名と呼ばれる
		 * 					1つのhtml内に同じid名を複数設定するは不可
		 * class			設定した値はclass名と呼ばれる
		 * 					複数のタグの設定をまとめて行う際などに使用
		 * href			参照/遷移先の指定
		 * src				imgタグやvideoたぐで指定
		 * width			表示幅を指定
		 * border		境界「きょうかい」線の表示/非表示を指定
		 */
		/*
		 * ========
		 * 画像を表示する
		 * ========
		 * <img>　src属性で表示画像を指定
		 * 			　　(絶対パス/相対パスのどちらでも指定可)　Image
		 * 
		 * ファイル名のみ指定した場合、同じフォルダにある画像を表示
		 * 		↓
		 * test/src/test1/Srv01_Tag サーブレット
		 * WebContent/dog.jpg		表示画像
		 * 
		 * フォルダが異なるが、同じフォルダに格納された扱いになる
		 * 
		 * 表示画像が以下の位置にある場合
		 * WebContent/imgs/banana.jpg
		 * 　src属性に設定する値は　'imgs/banana.jpg'になる
		 * 
		 * 　imgフォルダがSrv01_Tagと同じフォルダに格納されている扱い
		 * 　その中にあるファイルは「/」の後に記述する
		 * ~~~~ここまでで相対パスの説明~~~~
		 */
		out.println("<br><t3>>>> 画像表示<相対パスについて> <<<<</t3><br>");
		String img1 = "<img src='umatoma.jpg'>";
		out.println(img1);
		
		String img2 = "<img src = 'imgs/banana.jpg'>";
		out.println(img2);
		
		/*
		 * 絶対パスについて
		 * 表示するファイル(サーブレットやhtml)の位置に関係なく
		 * 表示対象の画像ファイルがどこに存在するかを指定する方法
		 * 今回のdog.jpgの場合
		 * 		http://localhost:8080/test/Srv01_Tag
		 * サーブレット(Srv01_Tag)の絶対パス
		 * 　　http://localhost:8080/test/Srv01_Tag
		 * 
		 * どのWebサーバーのどのフォルダに格納されているか、どいう情報を全てsrc属性の値として設定する
		 * 　→パスが長くなりやすいが、どこからでも(他のサーバーからでも)指定可能
		 */
		String img3 = "<img src ='http://localhost:8080/test/dog.jpg'>";
		out.println("<br><t3>>>> 画像表示<絶対パスについて> <<<<</t3><br>");
		out.println(img3);
		
		/*
		 * 体裁を整える　　体裁：ていさい、見た目、対外的なもの
		 * <hr>　水平線を表示Horizontal(水平)　ホライゾン
		 * 		　　　(Vertical)に関するタグは存在しない
		 */
		out.println("<hr>");
		out.println("<br>水平線<br>");
		// <br>　記述位置で改行Break
		//　***img,hr,brは開始タグのみ(非セットのタグ)***
		
		//　<div></div>　主に修飾「しゅうしょく」目的で使用する
		//						　他のタグをまとめるDivide
		String div = "<div>" + p1 + "</div>";
		out.println(div);
		out.println(p1);
		
		//　divのように、内容を囲むだけのタグ
		//　<span></span>　主に修飾目的で使用する
		//　　　　　　　　　　　　　　他のタグや1行分の内容をまとめる
		//　<div>や<span>は修飾目的で使用
		//　　修飾方法→CSS,<style>で指定
		
		//　ページの内容をまとめる
		//　<main></main>		ページ内の主要「しゅよう」な内容をまとめる
		//　<header></header>	ページ上部の内容(見出し、ロゴ、メニュー)
		//　<footer></footer>		ページ下部の内容(グループ企業リンク、企業理念、サイト責任者ページ)
		//　<aside></aside>		ページ内の補助「ほじょ」内容をまとめる(カテゴリ表示など)
		//　<menu></menu>		メニュー項目をまとめる
		
		//　内容をまとめるタグの目的について
		//　→囲んでも<h1><p>のような表示形式の変化はない
		//　→インターネット上の色々なページをまわり、除法を収集「しゅうしゅう」するプログラムが存在する
		//　　　(クロウラー/Webクロウラー(crawler))
		//　　　→クロウラーの情報収集時に有効なのがまとめるタグ
		
		/*
		 * =======================
		 * クライアント(ユーザー)が操作/入力可能なタグ
		 * =======================
		 * <form></form>以下の州力内容まとめる:
		 * <input>							入力欄、type属性の値によって色々rな入力方法に変化する
		 * <select></select>			ドロップダウンリスト
		 * <option></option>			リスト項目(<select>内に記述)
		 * <button></button>		クリック可能なボタンを表示
		 * <textarea></textarea>	文字列の入力欄(複数行入力可)
		 * 
		 * <input type='submit'>の役割
		 * 		入力したデータを送信する→どこに？
		 * 		<form action='送信先'>←action属性の設定場所
		 */
		String form1 = "<form>"
				+ "Text: <input type='text' name ='t1'><br>"
				+ "Checkbox: <input type='checkbox'><br>"
				+ "Radio: <input type='radio' name = 'r1'>"
				+ "<input type='radio' name = 'r1'>"
				+ "<input type='radio' name = 'r2'>"
				+ "<input type='radio' name = 'r2'><br>"
				+ "Password: <input type='password'><br>"
				+ "Button: <input type='button' value='ボタン'><br>"
				+ "Reset: <input type='reset'><br>"
				+ "Submit: <input type='submit'><br>"
				+ "</form>";
		
		String sel = "<select>"
				+ "<option>項目1</option>"
				+ "<option>項目2</option>"
				+ "<option>項目3</option>"
				+ "</select><br>";
		
		String tarea = "<textarea  cols='30' rows='6'></textarea>";
		
		String form2 = "<form>"
							+ sel
							+ tarea
							+ "</form>";
		out.println(form1);
		out.println(form2);
		
		/*
		 * <head><body>どちらにも記述可能なタグ
		 * <script></script>	JavaScriptの処理を記述、JSファイルの読み込み
		 */
		
		out.println("</body>");
		out.println("</html>");
	}

}
