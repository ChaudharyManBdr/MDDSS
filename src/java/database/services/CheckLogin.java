/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.services;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bimal
 */
public class CheckLogin {
    public int check(String username)
    {
         int count=0;
        try {
           
            DbConnection db = new DbConnection();
            PreparedStatement pst = db.con.prepareStatement("select username from patient_info where username =?");
            pst.setString(1, username);
            db.rs=pst.executeQuery();
            while(db.rs.next())
            {
                count++;
                
            }
            if(count==1)
            {
                return count;
            }
            else
            {
            return 0;
            }
                
            
        } catch (Exception ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
       return count;
    }
}
