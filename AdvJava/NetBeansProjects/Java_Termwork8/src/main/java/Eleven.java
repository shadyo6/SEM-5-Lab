//

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/placement")
public class Eleven extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/termwork_seven", "root", "2gi20cs181");
        return conn;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Enter CGPA value:</h2>");
        out.println("<form method=\"post\">");
        out.println("  <label for=\"cgpa\">CGPA:</label>");
        out.println("  <input type=\"number\" step=\"0.01\" min=\"0\" max=\"10\" name=\"cgpa\" id=\"cgpa\" required>");
        out.println("  <button type=\"submit\">Submit</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cgpaString = request.getParameter("cgpa");
        double cgpa = Double.parseDouble(cgpaString);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT name FROM student WHERE cgpa >= ?");
            stmt.setDouble(1, cgpa);
            ResultSet rs = stmt.executeQuery();

            out.println("<html><body>");
            out.println("<h2>Students eligible for placement:</h2>");
            while (rs.next()) {
                out.println("<p>" + rs.getString("name") + "</p>");
            }
            out.println("</body></html>");

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<html><body><h2>Error retrieving data from database</h2></body></html>");
            e.printStackTrace(out);
        }
    }
}