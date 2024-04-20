import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Mitsumori")
public class Mitsumori extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, 
                       HttpServletResponse response) 
            throws ServletException ,IOException {
    response.sendRedirect("Mitsumori.html");
  }
  
  @Override
  protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) 
            throws ServletException, IOException {
    response.setContentType(
      "text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head><body>");
    request.setCharacterEncoding("UTF-8");
    try {
        int bd = Integer.parseInt(request.getParameter("bd"));
        int ink = Integer.parseInt(request.getParameter("ink"));
        int paper = Integer.parseInt(request.getParameter("paper"));
        if (bd >= 0 && ink >= 0 && paper >= 0) {
            out.printf("<table border='1'>%n"); 
            out.printf("<tr><th>品名</th><th>単価</th><th>個数</th><th>小計</th></tr>%n");
            out.printf("<tr><td>BD-Rディスク</td><td>500円</td><td>%d</td><td>%d円</td></tr>%n", bd, 500 * bd); 
            out.printf("<tr><td>インクカードリッジ</td><td>2000円</td><td>%d</td><td>%d円</td></tr>%n", ink, 2000 * ink);
            out.printf("<tr><td>A4用紙 500枚</td><td>400円</td><td>%d</td><td>%d円</td></tr>%n", paper , 400 * paper);
            out.printf("<tr><td colspan='3'>合計</td><td>%d円</td></tr>%n", 500 * bd + 2000 * ink + 400 * paper);
        } else {
            out.printf("<h1>有効な値を入力してください</h1>");
        }
    } catch(NumberFormatException ex) {
        out.printf("<h1>有効な値を入力してください</h1>");
    }
    out.println("</body></html>");
    out.close();
  }
}