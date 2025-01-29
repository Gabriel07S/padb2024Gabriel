/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GabrielFS;

import java.sql.*;

/**
 *
 * @author 1886519
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Connection con = null;

        try {
            con = new ConnectionFactory().getConnection();

            // ********** CRUD ********** 
            String sqlC = "INSERT INTO customer (`store_id`, `first_name`, `last_name`, `email`, `address_id`, `active`)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstC = con.prepareStatement(sqlC);

            pstC.setInt(1, 1);
            pstC.setString(2, "Charles");
            pstC.setString(3, "Silva");
            pstC.setString(4, "Charles.silva@ifrn.edu.br");
            pstC.setInt(5, 10);
            pstC.setInt(6, 1);

            pstC.execute();
            pstC.close();

            Statement stC = con.createStatement();
            String query = "SELECT * FROM customer ORDER BY customer_id DESC LIMIT 5";

            ResultSet rsC = stC.executeQuery(query);

            ResultSetMetaData mdC = rsC.getMetaData();
            int colC = mdC.getColumnCount();

            for (int i = 1; i <= colC; i++) {
                System.out.print(mdC.getColumnName(i) + "\t");
            }
            System.out.println();

            while (rsC.next()) {
                for (int i = 1; i <= colC; i++) {
                    System.out.print(rsC.getString(i) + "\t");
                }
                System.out.println();
            }

            rsC.close();
            stC.close();

            String sqlU = "UPDATE customer"
                    + " SET store_id = ?,"
                    + " address_id = ?";

            PreparedStatement pstU = con.prepareStatement(sqlU);

            pstU.setInt(1, 2);
            pstU.setInt(2, 5);

            pstU.execute();
            pstU.close();

            Statement stU = con.createStatement();
            String queryU = "SELECT * FROM customer ORDER BY customer_id DESC LIMIT 5";

            ResultSet rsU = stU.executeQuery(queryU);

            ResultSetMetaData mdU = rsU.getMetaData();
            int colU = mdU.getColumnCount();

            for (int i = 1; i <= colU; i++) {
                System.out.print(mdU.getColumnName(i) + "\t");
            }
            System.out.println();

            while (rsU.next()) {
                for (int i = 1; i <= colU; i++) {
                    System.out.print(rsU.getString(i) + "\t");
                }
                System.out.println();
            }

            String sqlD = "DELETE FROM customer"
                    + " WHERE email = ?";

            PreparedStatement pstD = con.prepareStatement(sqlD);
            pstD.setString(1, "Charles.silva@ifrn.edu.br");

            pstD.execute();
            pstD.close();

            Statement stD = con.createStatement();
            String queryD = "SELECT * FROM customer ORDER BY customer_id DESC LIMIT 5";

            ResultSet rsD = stD.executeQuery(queryD);

            ResultSetMetaData mdD = rsD.getMetaData();
            int colD = mdD.getColumnCount();

            for (int i = 1; i <= colD; i++) {
                System.out.print(mdD.getColumnName(i) + "\t");
            }
            System.out.println();

            while (rsD.next()) {
                for (int i = 1; i <= colD; i++) {
                    System.out.print(rsD.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
            System.out.println("Connection closed!");

        }

    }
}
