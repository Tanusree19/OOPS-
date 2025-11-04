import java.sql.*;

public class UpdateEmployeeRecord {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/companydb", "root", "Tanu@1908");

            // Step 3: Create SQL UPDATE statement
            String query = "UPDATE employee SET name = ? WHERE emp_id = ?";

            // Step 4: Create PreparedStatement
            pstmt = con.prepareStatement(query);

            // Step 5: Set parameters
            pstmt.setString(1, "John Doe");  // New name
            pstmt.setInt(2, 101);            // Employee ID to update

            // Step 6: Execute update
            int rowsAffected = pstmt.executeUpdate();

            // Step 7: Check result
            if (rowsAffected > 0)
                System.out.println("Employee record updated successfully!");
            else
                System.out.println("No record found with that ID.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 8: Close connection
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}