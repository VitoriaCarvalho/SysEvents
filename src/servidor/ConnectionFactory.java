/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vitoria
 */
public class ConnectionFactory {
 
    public static Connection getConnection () throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/SysEvents", "root", "sprm1998");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    
}
