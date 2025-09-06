package test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Srv04_Param2
 */
@WebServlet("/Srv04_Param2")
public class Srv04_Param2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv04_Param2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 送信データを受け取る
		String t1 = request.getParameter("t1");
		String t2 = request.getParameter("t2");
		String cb1 = request.getParameter("cb1");
		String cb2 = request.getParameter("cb2");
		String r1 = request.getParameter("r1");
		String r2 = request.getParameter("r2");
		String sel1 = request.getParameter("sel1");
		String sel2 = request.getParameter("sel2");
		String ta1 = request.getParameter("ta1");
		String sub1 = request.getParameter("sub1");
		String sub2 = request.getParameter("sub2");
		
		PrintWriter out = response.getWriter();
		String html1 = "<!DOCTYPE html>"
				+ "<html><hea>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Srv04_Param2</title>"
				+ "</head><body>"
				+ "<table border='1'>";
		String html2 = "</table></body></html>";
		
		out.println(html1);
		dispTbl(t1, "t1", out);
		dispTbl(t2, "t2", out);
		dispTbl(cb1, "cb1", out);
		dispTbl(cb2, "cb2", out);
		dispTbl(r1, "r1", out);
		dispTbl(r2, "r2", out);
		dispTbl(sel1, "sel1", out);
		dispTbl(sel2, "sel2", out);
		dispTbl(ta1, "ta1", out);
		dispTbl(sub1, "sub1", out);
		dispTbl(sub2, "sub2", out);
		out.println(html2);
		
	}
	// Tableを表示する
	public void dispTbl(String obj, String nm, PrintWriter out) {
		out.println("<tr><td>" + nm+ "</td><td>");
		// objがnullの場合
		if (obj == null) {
			out.println("NULL");
		} else if (obj.equals("")) {
			// objが０文字の場合
			out.println("0文字");
		} else {
			// objがnullではなく、かつ0文字以外の場合
			out.println(obj);
		}
		out.println("</td></tr>");
	}

}
