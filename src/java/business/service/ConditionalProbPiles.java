/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.service;

import database.services.DiseaseProbability;
import database.services.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used for the calculation for the piles disease.
 *
 * 
 */
public class ConditionalProbPiles {

    double pd;
    double ps;
    Map<Integer, Double> map;
    double returnValue = 1.0;

    /**
     *
     * @param dp
     * @return returnValue
     */
    public double findConditionalProb(DiseaseProbability dp){
        try {
            DbConnection db = new DbConnection();
            double prob_data;
            //probability of the disease.
            pd = dp.getP_d();
            //probability of the symptoms.
            ps = dp.getP_s();
            /*
            *
            *getSympProbMap() is to carry out the probability of the symptoms with symptoms_id
            */
            System.out.println("lastfunction calling");
            map = dp.getSympProbMap();
            System.out.println(map);
            double s1, s2, s3, s4, s5;
            double[] tempProb = new double[5];
            //for s1=BLEED
            for (int i = 0; i <= 1; i++) {
                
                s1 = map.get(1);
                
                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                s2 = map.get(2);
                                s3 = map.get(3);
                                s4 = map.get(4);
                                s5 = map.get(5);
                                if (j == 0) {
                                    s2 = 1 - s2;
                                }
                                if (k == 0) {
                                    s3 = 1 - s3;
                                }
                                if (l == 0) {
                                    s4 = 1 - s4;
                                }
                                if (m == 0) {
                                    s5 = 1 - s5;
                                }
                                
                                PreparedStatement ps = db.con.prepareStatement("SELECT PROB_PILES FROM piles WHERE BLEED=? AND ITCH=? AND LUMPHANG=? AND MUCUSDIS=? AND SWELL=?");
                                ps.setInt(1, 1);
                                ps.setInt(2, j);
                                ps.setInt(3, k);
                                ps.setInt(4, l);
                                ps.setInt(5, m);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                    tempProb[i] += rs.getFloat("PROB_PILES") * s1 * s2 * s3 * s4 * s5;
                                }
                                
                            }
                        }
                    }
                }
                
            }   //for s2=ITCH
            for (int i = 1; i < 2; i++) {
                
                s2 = map.get(2);
                
                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                s1 = map.get(1);
                                s3 = map.get(3);
                                s4 = map.get(4);
                                s5 = map.get(5);
                                if (j == 0) {
                                    s1 = 1 - s1;
                                }
                                if (k == 0) {
                                    s3 = 1 - s3;
                                }
                                if (l == 0) {
                                    s4 = 1 - s4;
                                }
                                if (m == 0) {
                                    s5 = 1 - s5;
                                }
                                
                                PreparedStatement ps = db.con.prepareStatement("SELECT PROB_PILES FROM piles WHERE BLEED=? AND ITCH=? AND LUMPHANG=? AND MUCUSDIS=? AND SWELL=?");
                                ps.setInt(1, j);
                                ps.setInt(2, 1);
                                ps.setInt(3, k);
                                ps.setInt(4, l);
                                ps.setInt(5, m);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                    tempProb[i] += rs.getFloat("PROB_PILES") * s1 * s2 * s3 * s4 * s5;
                                }
                                
                            }
                        }
                    }
                }
                
            }   //for s3=LUMPHANG
            for (int i = 2; i < 3; i++) {
                
                s3 = map.get(3);
                
                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                s1 = map.get(1);
                                s2 = map.get(2);
                                s4 = map.get(4);
                                s5 = map.get(5);
                                if (j == 0) {
                                    s1 = 1 - s1;
                                }
                                if (k == 0) {
                                    s2 = 1 - s2;
                                }
                                if (l == 0) {
                                    s4 = 1 - s4;
                                }
                                if (m == 0) {
                                    s5 = 1 - s5;
                                }
                                
                                PreparedStatement ps = db.con.prepareStatement("SELECT PROB_PILES FROM piles WHERE BLEED=? AND ITCH=? AND LUMPHANG=? AND MUCUSDIS=? AND SWELL=?");
                                ps.setInt(1, j);
                                ps.setInt(2, k);
                                ps.setInt(3, 1);
                                ps.setInt(4, l);
                                ps.setInt(5, m);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                    tempProb[i] += rs.getFloat("PROB_PILES") * s1 * s2 * s3 * s4 * s5;
                                }
                                
                            }
                        }
                    }
                }
                
            }   //for s4=MUCUSDIS
            for (int i = 3; i < 4; i++) {
                
                s4 = map.get(4);
                
                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                s1 = map.get(1);
                                s2 = map.get(2);
                                s3 = map.get(3);
                                s5 = map.get(5);
                                if (j == 0) {
                                    s1 = 1 - s1;
                                }
                                if (k == 0) {
                                    s2 = 1 - s2;
                                }
                                if (l == 0) {
                                    s3 = 1 - s3;
                                }
                                if (m == 0) {
                                    s5 = 1 - s5;
                                }
                                
                                PreparedStatement ps = db.con.prepareStatement("SELECT PROB_PILES FROM piles WHERE BLEED=? AND ITCH=? AND LUMPHANG=? AND MUCUSDIS=? AND SWELL=?");
                                ps.setInt(1, j);
                                ps.setInt(2, k);
                                ps.setInt(3, l);
                                ps.setInt(4, 1);
                                ps.setInt(5, m);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                    tempProb[i] += rs.getFloat("PROB_PILES") * s1 * s2 * s3 * s4 * s5;
                                }
                                
                            }
                        }
                    }
                }
                
            }   //for s5=SWELL
            for (int i = 4; i < 5; i++) {
                
                s5 = map.get(5);
                
                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                s1 = map.get(1);
                                s2 = map.get(2);
                                s3 = map.get(3);
                                s4 = map.get(4);
                                if (j == 0) {
                                    s1 = 1 - s1;
                                }
                                if (k == 0) {
                                    s2 = 1 - s2;
                                }
                                if (l == 0) {
                                s3 = 1 - s3;
                            }
                            if (m == 0) {
                                s4 = 1 - s4;
                            }

                            PreparedStatement ps = db.con.prepareStatement("SELECT PROB_PILES FROM piles WHERE BLEED=? AND ITCH=? AND LUMPHANG=? AND MUCUSDIS=? AND SWELL=?");
                            ps.setInt(1, j);
                            ps.setInt(2, k);
                            ps.setInt(3, l);
                            ps.setInt(4, m);
                            ps.setInt(5, 1);
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                tempProb[i] += rs.getFloat("PROB_PILES") * s1 * s2 * s3 * s4 * s5;
                            }

                        }
                    }
                }
            }

        }   //return value calculation
        for (int i = 0; i < 5; i++) {
            System.out.println("The value of the temp["+i+"] are:"+tempProb[i]);
            returnValue *= tempProb[i];
        }   
        } catch (Exception ex) {
            Logger.getLogger(ConditionalProbPiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (returnValue * pd)/ps;
    }

}
