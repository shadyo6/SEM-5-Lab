import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EligibleStudents")
public class Termwork8a extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    double cgpa = 8.5;

    String filePath = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\Java_Termwork8\\src\\main\\java\\folder\\students.txt";
    BufferedReader reader = new BufferedReader(new FileReader(filePath));

    PrintWriter writer = response.getWriter();
    writer.println("<html><body>");
    writer.println("<h3>Eligible Students:</h3>");
    writer.println("<ul>");

    String line;
    while ((line = reader.readLine()) != null) {
      String[] parts = line.split(",");
      String name = parts[0];
      double studentCgpa = Double.parseDouble(parts[1]);
      if (studentCgpa >= cgpa) {
        writer.println("<li>" + name + "</li>");
      }
    }

    reader.close();

    writer.println("</ul>");
    writer.println("</body></html>");
  }
}
