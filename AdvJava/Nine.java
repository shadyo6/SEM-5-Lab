//please make some legit changes and dont get caught if two or more programs are same
//database create table statements:
//create table books(id int primary key, Bname text, year int);
//create table authors(id int primary key, Aname text, bid int, foreign key(bid) references books(id));
import java.sql.*;
import java.util.Scanner;
public class Nine {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/termwork_seven";
    static final String USER = "root";
    static final String PASS = "2gi20cs181";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter author name: ");
            String authorName = sc.nextLine();

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "SELECT books.Bname, books.year " +
                        "FROM books, authors " +
                        "WHERE authors.Aname='" + authorName + "' AND books.id=authors.bid";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Books authored by " + authorName + ":");
            while (rs.next()) {
                String Bname = rs.getString("Bname");
                int year = rs.getInt("year");

                System.out.println("Name: " + Bname + ", Year: " + year);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}