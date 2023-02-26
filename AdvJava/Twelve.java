//please make some legit changes and dont get caught if two or more programs are same
//create table owners (regno varchar(20) primary key, name varchar(50), address text, phone bigint);
// load some data into database before executing
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

@WebServlet("/vehicle")
public class Twelve extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", "username", "password");
        return conn;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Enter vehicle registration number:</h2>");
        out.println("<form method=\"post\">");
        out.println("  <label for=\"regno\">Registration number:</label>");
        out.println("  <input type=\"text\" name=\"regno\" id=\"regno\" required>");
        out.println("  <button type=\"submit\">Submit</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String regno = request.getParameter("regno");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement("SELECT name, address, phone FROM owners WHERE regno = ?");
            stmt.setString(1, regno);
            ResultSet rs = stmt.executeQuery();

            out.println("<html><body>");
            out.println("<h2>Owner details:</h2>");
            if (rs.next()) {
                out.println("<p>Name: " + rs.getString("name") + "</p>");
                out.println("<p>Address: " + rs.getString("address") + "</p>");
                out.println("<p>Phone number: " + rs.getString("phone") + "</p>");
            } else {
                out.println("<p>No owner found for registration number " + regno + "</p>");
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
