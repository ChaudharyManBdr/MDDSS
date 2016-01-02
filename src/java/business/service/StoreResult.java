/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business.service;

import database.services.DbConnection;
import java.sql.PreparedStatement;

/**
 *
 * @author Manav
 */
public class StoreResult {
   
    
    public StoreResult(String uname, String result)throws Exception
    {
         
        DbConnection db=new DbConnection();
        PreparedStatement ps=db.con.prepareStatement("insert into history(username,result) values (?,?)");
        ps.setString(1, uname);
        ps.setString(2, result);
        ps.execute();
    }
   /* public static void main(String args[])throws Exception
    {
       new StoreResult("hello");
    }*/
    
}
