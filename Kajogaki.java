import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Kajogaki")
public class Kajogaki extends HttpServlet {
	HashMap<String, String> hm = new HashMap<>();

	public void init() throws ServletException {
		hm.put("小豆",   "#96514d");
		hm.put("黄金",   "#e6b422");
		hm.put("萌葱",   "#006e54");
		hm.put("菖蒲",   "#cc7eb1");
		hm.put("撫子",   "#eebbcb");
		hm.put("紺碧",   "#007bbb");
		hm.put("豆がら", "#8b968d");
		hm.put("鉄",     "#005243");
	}

  @Override
  protected void doGet(HttpServletRequest request, 
                       HttpServletResponse response) 
            throws ServletException ,IOException {
    response.sendRedirect("Kajogaki.html");
  }
	
	@Override
  protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) 
            throws ServletException, IOException {
    response.setContentType(
      "text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head><body><ul>");
    request.setCharacterEncoding("UTF-8");
		String[] colors = request.getParameter("colors").split("\\s+");
		for (int i = 0; i < colors.length; i++) {
			String c = colors[i];
			out.printf("<li style='color: %s;'>%s</li>%n", hm.get(c), c);
    }
    out.println("</ul></body></html>");
    out.close();
  }
}
