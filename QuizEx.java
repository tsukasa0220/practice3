import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/QuizEx")
public class QuizEx extends HttpServlet {
  private static final String ANSWER  = "answer";
  private static final String SCORE   = "score";
  private static final String NUMBER  = "number";
  private static final String QUESTIONS = "questions";
  private static final String SELECTS = "selects";
  
  @Override
  protected void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
            throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response) 
            throws ServletException, IOException {
    response.setContentType(
      "text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head><body>");

    int i, number = 0, score = 0;
    ArrayList<String[]> questions;
    List<Integer> selects = new ArrayList<>();

    HttpSession session = request.getSession(true);

    if (session.isNew() 
      || session.getAttribute(QUESTIONS) == null) {
      questions = new ArrayList<String[]>();
      File f = new File(getServletContext()
                 .getRealPath("/WEB-INF/quiz.txt"));
      BufferedReader in 
        = new BufferedReader(new InputStreamReader(
            new FileInputStream(f), "UTF-8"));
      String line="";
      while ((line = in.readLine()) != null) {
        line = line.trim();
        if (line.trim().equals("")) continue;
        questions.add(line.split("\\s+")); 
      }
      in.close();
      session.setAttribute(QUESTIONS, questions);
      out.println("<p>ようこそ QUIZへ!<br />");
      out.println("   では最初の問題です。</p>");
    } else {
      try {
        number = (int)session.getAttribute(NUMBER);
        score  = (int)session.getAttribute(SCORE);
        questions = (ArrayList<String[]>)
                    session.getAttribute(QUESTIONS);
        selects = (List<Integer>)session.getAttribute(SELECTS);


        String[] tokens = questions.get(number - 1);
        int a = Integer.parseInt(
                  tokens[tokens.length - 1]);
        int answer = Integer.parseInt(
                       request.getParameter(ANSWER));
        if (a == answer) {
          out.println("正解です。<br />");
          score++;
        } else {
          out.println("残念でした。<br />");
        }
        selects.add(answer);
      } catch (Exception e) {
        session.removeAttribute(QUESTIONS);
        out.println(
            "想定外のアクセスでエラーが起こりました。"
          + "タブを閉じるかリロードしてください。");
        e.printStackTrace(out);
        out.println("</body></html>");
        out.close();
        return;
      }
    }

    if (number >= questions.size()) {
      String[] tokens;
      int a, answer;
      out.println("<br />");
      out.println("これで QUIZは終了です。<br />");
      out.printf("<table border='1'>%n"); 
      out.printf("<tr><th>番号</th><th>問題</th><th>正解</th><th>解答</th><th>正誤</th>%n");
      for (i = 0; i < number; i++) {
        tokens = questions.get(i);
        a = Integer.parseInt(tokens[tokens.length - 1]);
        answer = selects.get(i);
        out.printf("<tr><td>第%d問</td><td>%s</td><td>%s</td><td>%s</td>", i+1, tokens[0], tokens[a], tokens[answer]);
        if (a == answer) {
          out.printf("<td>〇</td></tr>%n");
        } else {
          out.printf("<td>×</td></tr>%n");
        }
      }
      out.printf("<tr><td colspan='5'>正解数は、%d問中%d問でした。</td></tr>%n",number, score);
      session.removeAttribute(QUESTIONS);
    } 
    else {
      String[] tokens = questions.get(number);
      out.println("次の問: " + tokens[0] + "<br />");
      out.println("<form method='post'>");
      for (i = 0; i < tokens.length - 2; i++) {
        out.print("<input type='radio'");
        out.print(" name='answer'");
        out.printf(" value='%d'　/> %s",
                   i + 1, tokens[i + 1]);
      }
      out.println("<br />");
      out.print("<input type='submit'");
      out.println(" value='送信' />");
      out.print("<input type='reset'");
      out.println(" value='やめ' />");
      out.println("</form>");

      number++;
      session.setAttribute(NUMBER, number);
      session.setAttribute(SCORE, score);
      session.setAttribute(SELECTS, selects);
    }
    out.println("</body></html>");
    out.close();
  }
}