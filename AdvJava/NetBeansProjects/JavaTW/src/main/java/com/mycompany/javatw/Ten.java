/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatw;
//please make some legit changes and dont get caught if two or more programs are same
//create table accounts (account_number int primary key, balance double);
import java.sql.*;
public class Ten {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/termwork_seven"; // database URL
        String user = "root"; // database username
        String password = "2gi20cs181"; // database password

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password); // connect to the database
            conn.setAutoCommit(false); // start a transaction

            // insert initial data into the accounts table
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO accounts (account_number, balance) VALUES (?, ?)");
            stmt.setInt(1, 1);
            stmt.setDouble(2, 1000.0);
            stmt.executeUpdate();
            stmt.setInt(1, 2);
            stmt.setDouble(2, 2000.0);
            stmt.executeUpdate();
            stmt.close();

            // withdraw 500 from account 1
            PreparedStatement withdrawStmt = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE account_number = ?");
            withdrawStmt.setDouble(1, 500.0);
            withdrawStmt.setInt(2, 1);
            withdrawStmt.executeUpdate();
            withdrawStmt.close();

            // deposit 500 to account 2
            PreparedStatement depositStmt = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_number = ?");
            depositStmt.setDouble(1, 500.0);
            depositStmt.setInt(2, 2);
            depositStmt.executeUpdate();
            depositStmt.close();

            conn.commit(); // commit the transaction
            System.out.println("Transaction successful.");
        } catch (SQLException e) {
            try {
                conn.rollback(); // rollback the transaction if there was an error
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.err.println("Transaction failed: " + e.getMessage());
        } finally {
            try {
                conn.close(); // close the connection to the database
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}