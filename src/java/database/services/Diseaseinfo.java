/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.services;

import business.service.CalculateProb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bimal
 */
public class Diseaseinfo {
    public int diseaseid;
    public Map<Integer, Double> retrieveMap(int diseaseid)
    {
     int symptoms_id;
        Double symptoms_probability;
        Map<Integer, Double> map = new HashMap<>();
        try {
            DbConnection db = new DbConnection();
            PreparedStatement ps = db.con.prepareStatement("SELECT id,probability FROM symptoms where disease_id=?");
            ps.setInt(1, diseaseid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                symptoms_id = rs.getInt("id");
                symptoms_probability = rs.getDouble("probability");
                map.put(symptoms_id, symptoms_probability);
            }

        } catch (Exception ex) {
            Logger.getLogger(CalculateProb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
        
    }
    
    /**
     *
     * @param diseaseId
     * @return
     */
    public double getDiseaseProbability(int diseaseId) {
        DbConnection db;
        double prob = 0.0;
        try {
            db = new DbConnection();
            PreparedStatement ps = db.con.prepareStatement("SELECT d_prob from disease where disease_id=?");
            ps.setInt(1, diseaseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prob = rs.getFloat("d_prob");

            }

        } catch (Exception ex) {
            Logger.getLogger(CalculateProb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prob;

    }


    
    
}
