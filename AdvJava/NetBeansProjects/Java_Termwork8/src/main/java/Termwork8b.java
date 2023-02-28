import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vehicleServlet")
public class Termwork8b extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.getWriter().println("<html><body>");
    response.getWriter().println("<form action='vehicleServlet' method='post'>");
    response.getWriter().println("<label>Enter Vehicle Registration Number:</label>");
    response.getWriter().println("<input type='text' name='regNumber'>");
    response.getWriter().println("<input type='submit' value='Submit'>");
    response.getWriter().println("</form>");
    response.getWriter().println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.getWriter().println("<html><body>");
    response.getWriter().println("<table border='1'>");
    response.getWriter().println("<tr>");
    response.getWriter().println("<th>Name</th>");
    response.getWriter().println("<th>Address</th>");
    response.getWriter().println("<th>Phone</th>");
    response.getWriter().println("</tr>");

    String regNumber = request.getParameter("regNumber");
    File file = new File("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\Java_Termwork8\\src\\main\\java\\folder\\vehicles.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;
    while ((line = br.readLine()) != null) {
      String[] details = line.split(",");
      if (details[0].equals(regNumber)) {
        String name = details[1];
        String address = details[2];
        String phone = details[3];

        response.getWriter().println("<tr>");
        response.getWriter().println("<td>" + name + "</td>");
        response.getWriter().println("<td>" + address + "</td>");
        response.getWriter().println("<td>" + phone + "</td>");
        response.getWriter().println("</tr>");
        break;
      }
    }

    br.close();
    response.getWriter().println("</table>");
    response.getWriter().println("</body></html>");
  }
}
