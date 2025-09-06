package test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Srv02_Param
 */
@WebServlet("/Srv02_Param")
public class Srv02_Param extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv02_Param() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * ==============
		 * 表示ページの文字化け対策
		 * ==============
		 */
		//response.setCharacterEncoding("UTF-8");
		// Auto insert the required package: Ctrl + Shift + o
		PrintWriter out = response.getWriter();
		/*
		 * 送信データを取得する方法
		 * 送信データを取得する際に必要なもの：name属性の値(送信名)
		 * <input type='~' name = '送信名'>
		 * 
		 * 送信名を使って送信データを取得
		 * request.getParameter("送信名");
		 * 
		 * 例：<input type = 'text' name = 't1'>
		 * 
		 * 			　↓
		 * 		　String str1 ＝request.getParameter(1);
		 * 				　~~~送信データを格納した変数
		 * 
		 * 送信データはクエリ文字列として
		 * アドレス欄に表示される場合もある
		 * 　htpp://localhost:8080/test/Srv02_Param?t1=送信データ
		 * 																~~~~~~~~~クエリ文字
		 */
		// 送信データの文字化け対策
		//request.setCharacterEncoding("UTF-8");
		// 送信データを受け取る
		String p1 = request.getParameter("p1");
		// データは同じなめで複数送信可能
		// 受信する場合:　request.getParameterValues("送信名");
		String[] arr1 = request.getParameterValues("p2"); 
		// 複数送信したデータをgetParameter()で受け取った場合
		String p2 = request.getParameter("p2");
		
		String html1 = "<!DOCTYPE html>"
				+ "<html><head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Srv02_Param</title>"
				+ "</head>"
				+ "<body>";
		String html2 = "</body></html>"; 
		out.println(html1);
		out.println("送信データの出力<br>");
		
		//　未送信時(送信フォームから送信していない場合)は、中の処理を実行しない
		if (p1 !=null) {
			out.println("p1: " + p1);
			out.println("<br>");
			for (String dt : arr1) {
				out.println(dt + " ");
			}
			out.println("<br>");
			out.println("p2: " + p2 + "<br>");
		}
		out.println(html2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Reuse the same logic
		doGet(request, response); 
	}

}
