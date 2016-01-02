/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.services;

import database.services.DbConnection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bimal
 */
public class Patientinfo {
    private String name,username,gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    private int age;
    public void saveRecord()
    {
        try {
            DbConnection db = new DbConnection();
            String query="insert into patient_info(name,age,gender,username) values(?,?,?,?)";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.setString(3,gender);
            pst.setString(4, username);
            pst.execute();
            db.con.close();
           
        } catch (Exception ex) {
            System.err.println("Got an exception");
            System.err.println(ex.getMessage());
        }
    }
    public void recieveData(String username)
    {
        try {
            DbConnection db = new DbConnection();
            PreparedStatement pst = db.con.prepareStatement("select name,age,gender from patient_info where username=?");
            pst.setString(1, username);
             db.rs=pst.executeQuery();
             while(db.rs.next())
             {
                 setName(db.rs.getString("name"));
                 setAge(db.rs.getInt("age"));
                 setGender(db.rs.getString("gender"));
             }
        }catch (Exception ex) {
            Logger.getLogger(Patientinfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
