/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package ADMIN;
/**
 *
 * @author G50-70
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    /**
     * @param args the command line arguments
     */
    public static Connection connectdb()
    {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","password");
            return con;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return null;
    }
}
    