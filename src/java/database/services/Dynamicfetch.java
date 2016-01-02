/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.services;

import business.service.Disease;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bimal
 */
public class Dynamicfetch {
    int disease_id;
    int symptoms_id[]={};
    Map<Integer,String>dmap = new HashMap<>();
    public Dynamicfetch()
    {
    }
    public int getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(int disease_id) {
        this.disease_id = disease_id;
    }

    public int[] getSymptoms_id() {
        return symptoms_id;
    }

    public void setSymptoms_id(int[] symptoms_id) {
        this.symptoms_id = symptoms_id;
    }
    public List fetch_data(Dynamicfetch d)
    {
        List<Disease> list = new ArrayList<>();
        try {
            DbConnection db = new DbConnection();
            PreparedStatement pst = db.con.prepareStatement("select symptom,id,probability from symptoms where disease_id=?");
            pst.setInt(1,d.disease_id);
            db.rs=pst.executeQuery();
            while(db.rs.next())
            {
                d.dmap.put(db.rs.getInt("id"),db.rs.getString("symptom"));
             }
            d.dmap.keySet().stream().forEach((key) -> {
                for(int i=0;i<d.symptoms_id.length;i++)
                {
                    if(key.equals(d.symptoms_id[i]))
                    {
                        d.dmap.remove(key);
                    }
                }
            });
        } catch (Exception ex) {
            
        }
        for(int key:d.dmap.keySet())
        {
           
            Disease f = new Disease();
            f.setSymptom_id(key);
            f.setSymptom(d.dmap.get(key));
            list.add(f);
            
        }
      return list;
    }
    
    
}

