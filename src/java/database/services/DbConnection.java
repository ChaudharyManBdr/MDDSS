/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {

    public Connection con;
    public Statement st;
    public ResultSet rs;

    public DbConnection() throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String conString = "jdbc:mysql://localhost:3306/MDDSS";
        String userName = "root";
        String password = "";
        con = DriverManager.getConnection(conString, userName,
                password);
        st = con.createStatement();
        
    }

}
