import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PointCounter")
public class PointCounter extends HttpServlet {
  private static final String COUNTER = "counter";

  @Override
  protected void doGet(HttpServletRequest request, 
                       HttpServletResponse response) 
            throws ServletException, IOException {
    response.setContentType(
      "text/html; charset=UTF-8");
    HttpSession session = request.getSession(true);
    int sum = 0, i = (int)(Math.random() * 5) + 6;
    try {
      sum = (int) session.getAttribute(COUNTER);
    } catch (NullPointerException 
           | NumberFormatException e) { 
    }
    sum += i;
    PrintWriter out = response.getWriter();
    out.println("<html><head></head><body>");
    out.printf("今回の来店ポイントは %d 点です。累計のポイントは %d 点になりました。", i, sum);
    out.println("</body></html>");
    session.setAttribute(COUNTER, sum);
    out.close();
  }
}