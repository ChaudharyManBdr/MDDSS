/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcontroller;

/**
 *
 *
 */
import database.services.DbConnection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class RetrieveSymptoms {
    
   public void fetchSymptoms()
   { int disease_id=0;
       int symptoms_id;
       String symptoms;
       int count=1;
      int piles_count=0,pneumonia_count=0,asthma_count=0;
      
       try {
           DbConnection db = new DbConnection();
         while(count<4)
         {
           PreparedStatement pst=db.con.prepareStatement("select id,symptom from symptoms where disease_id=?");
           pst.setInt(1,disease_id);
           db.rs = pst.executeQuery();
           while(db.rs.next())
           {
             symptoms_id=db.rs.getInt(1);
             symptoms=db.rs.getString("symptom");
             System.out.println("Symptoms_id is "+symptoms_id+" symptoms is "+symptoms+" disease id is"+disease_id);
             if(disease_id==0)
             {
                 piles_count++;
                 if(piles_count==2)
                 {
                     disease_id=1;
                     break;
                 }
             }
             if(disease_id==1)
             {
                 pneumonia_count++;
                 if(pneumonia_count==3)
                 {
                   disease_id=2;
                   break;
                 }
             }
             if(disease_id==2)
             {
                 asthma_count++;
                 if(asthma_count==3)
                 {
                     break;
                 }
             }
           }
           /*
           * end of the inner while loop
            */
           count++;
         }
         /* end of the  outer while loop*/
       } catch (Exception ex) {
           Logger.getLogger(RetrieveSymptoms.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public static void main(String args[])
   {
       RetrieveSymptoms f= new RetrieveSymptoms();
       f.fetchSymptoms();
   }
   
   
}
