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
 *
 * @author 
 */
public class CalculateProbPneumonia {

    double pd;
    double ps;
    Map<Integer, Double> map;
    double returnValue = 1.0;

    public double findConditionalProb(DiseaseProbability dp) {
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
            double s1, s2, s3, s4, s5, s6, s7, s8;
            double[] tempProb = new double[8];
            /*
             *   for the symptoms FEVER
             */
            for (int i = 0; i < 1; i++) {
                s1 = map.get(6);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s2 = map.get(7);
                                            s3 = map.get(8);
                                            s4 = map.get(9);
                                            s5 = map.get(10);
                                            s6 = map.get(11);
                                            s7 = map.get(12);
                                            s8 = map.get(13);
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
                                            if (n == 0) {
                                                s6 = 1 - s6;
                                            }
                                            if (0 == 0) {
                                                s7 = 1 - s7;
                                            }
                                            if (p == 0) {
                                                s8 = 1 - s8;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from pneumonia where FEVER= ? and "
                                                    + "LOWERTEMP=? and COUGH=? and CHESTPAIN=? and BREATHSHORT=? "
                                                    + "and FATIGUE=? and NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, 1);
                                            ps.setInt(2, j);
                                            ps.setInt(3, k);
                                            ps.setInt(4, l);
                                            ps.setInt(5, m);
                                            ps.setInt(6, n);
                                            ps.setInt(7, o);
                                            ps.setInt(8, p);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms FEVER
             */

            /*
             *   for the symptoms LOWERTEMP
             */
            for (int i = 1; i < 2; i++) {
                s2 = map.get(7);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s1 = map.get(6);
                                            s3 = map.get(8);
                                            s4 = map.get(9);
                                            s5 = map.get(10);
                                            s6 = map.get(11);
                                            s7 = map.get(12);
                                            s8 = map.get(13);
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
                                            if (n == 0) {
                                                s6 = 1 - s6;
                                            }
                                            if (0 == 0) {
                                                s7 = 1 - s7;
                                            }
                                            if (p == 0) {
                                                s8 = 1 - s8;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from pneumonia where FEVER= ? and"
                                                    + " LOWERTEMP=? and COUGH=? and CHESTPAIN=? and BREATHSHORT=? and FATIGUE=? "
                                                    + "and NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, j);
                                            ps.setInt(2, 1);
                                            ps.setInt(3, k);
                                            ps.setInt(4, l);
                                            ps.setInt(5, m);
                                            ps.setInt(6, n);
                                            ps.setInt(7, o);
                                            ps.setInt(8, p);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms LOWERTEMP
             */
            /*
             *   for the symptoms COUGH
             */
            for (int i = 2; i < 3; i++) {
                s3 = map.get(8);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s1 = map.get(6);
                                            s2 = map.get(7);

                                            s4 = map.get(9);
                                            s5 = map.get(10);
                                            s6 = map.get(11);
                                            s7 = map.get(12);
                                            s8 = map.get(13);
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
                                            if (n == 0) {
                                                s6 = 1 - s6;
                                            }
                                            if (0 == 0) {
                                                s7 = 1 - s7;
                                            }
                                            if (p == 0) {
                                                s8 = 1 - s8;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from pneumonia where FEVER= ? and"
                                                    + " LOWERTEMP=? and COUGH=? and CHESTPAIN=? and BREATHSHORT=? and FATIGUE=? and"
                                                    + " NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, j);
                                            ps.setInt(2, k);
                                            ps.setInt(3, 1);
                                            ps.setInt(4, l);
                                            ps.setInt(5, m);
                                            ps.setInt(6, n);
                                            ps.setInt(7, o);
                                            ps.setInt(8, p);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms COUGH
             */
            /*
             *   for the symptoms CHESTPAIN
             */
            for (int i = 3; i < 4; i++) {
                s4 = map.get(9);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s1 = map.get(6);
                                            s2 = map.get(7);

                                            s3 = map.get(8);
                                            s5 = map.get(10);
                                            s6 = map.get(11);
                                            s7 = map.get(12);
                                            s8 = map.get(13);
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
                                            if (n == 0) {
                                                s6 = 1 - s6;
                                            }
                                            if (0 == 0) {
                                                s7 = 1 - s7;
                                            }
                                            if (p == 0) {
                                                s8 = 1 - s8;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from pneumonia "
                                                    + "where FEVER= ? and "
                                                    + "LOWERTEMP=? and COUGH=? and CHESTPAIN=? and BREATHSHORT=? and FATIGUE=? "
                                                    + "and NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, j);
                                            ps.setInt(2, k);
                                            ps.setInt(3, l);
                                            ps.setInt(4, 1);
                                            ps.setInt(5, m);
                                            ps.setInt(6, n);
                                            ps.setInt(7, o);
                                            ps.setInt(8, p);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms CHEASTPAIN
             */

            /*
             *   for the symptoms BREATHESHORT
             */
            for (int i = 4; i < 5; i++) {
                s5 = map.get(10);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s2 = map.get(7);
                                            s1 = map.get(6);
                                            s3 = map.get(8);
                                            s4 = map.get(9);
                                            s6 = map.get(11);
                                            s7 = map.get(12);
                                            s8 = map.get(13);
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
                                            if (n == 0) {
                                                s6 = 1 - s6;
                                            }
                                            if (0 == 0) {
                                                s7 = 1 - s7;
                                            }
                                            if (p == 0) {
                                                s8 = 1 - s8;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from "
                                                    + "pneumonia where FEVER= ? and "
                                                    + "LOWERTEMP=? and COUGH=? and CHESTPAIN=? and BREATHSHORT=?"
                                                    + " and FATIGUE=? and NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, j);
                                            ps.setInt(2, k);
                                            ps.setInt(3, l);
                                            ps.setInt(4, m);
                                            ps.setInt(5, 1);
                                            ps.setInt(6, n);
                                            ps.setInt(7, o);
                                            ps.setInt(8, p);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms BREATHESHORT
             */

            /*
             *   for the symptoms FATIGUE
             */
            for (int i = 5; i < 6; i++) {
                s6 = map.get(11);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s2 = map.get(7);
                                            s1 = map.get(6);
                                            s3 = map.get(8);
                                            s4 = map.get(9);
                                            s5 = map.get(10);
                                            s7 = map.get(12);
                                            s8 = map.get(13);
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
                                            if (n == 0) {
                                                s5 = 1 - s5;
                                            }
                                            if (0 == 0) {
                                                s7 = 1 - s7;
                                            }
                                            if (p == 0) {
                                                s8 = 1 - s8;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from pneumonia"
                                                    + " where FEVER= ? and "
                                                    + "LOWERTEMP=? and COUGH=? and CHESTPAIN=? and BREATHSHORT=? "
                                                    + "and FATIGUE=? and NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, j);
                                            ps.setInt(2, k);
                                            ps.setInt(3, l);
                                            ps.setInt(4, m);
                                            ps.setInt(5, n);
                                            ps.setInt(6, 1);
                                            ps.setInt(7, o);
                                            ps.setInt(8, p);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms FATIGUE
             */

            /*
             *   for the symptoms NAUSEA
             */
            for (int i = 6; i < 7; i++) {
                s7 = map.get(12);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s2 = map.get(7);
                                            s1 = map.get(6);
                                            s3 = map.get(8);
                                            s4 = map.get(9);
                                            s5 = map.get(10);
                                            s6 = map.get(11);
                                            s8 = map.get(13);
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
                                            if (n == 0) {
                                                s5 = 1 - s5;
                                            }
                                            if (0 == 0) {
                                                s6 = 1 - s6;
                                            }
                                            if (p == 0) {
                                                s8 = 1 - s8;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from pneumonia where"
                                                    + " FEVER= ? and LOWERTEMP=? and COUGH=? and CHESTPAIN=? and"
                                                    + " BREATHSHORT=? and FATIGUE=? and NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, j);
                                            ps.setInt(2, k);
                                            ps.setInt(3, l);
                                            ps.setInt(4, m);
                                            ps.setInt(5, n);
                                            ps.setInt(6, o);
                                            ps.setInt(7, 1);
                                            ps.setInt(8, p);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms NAUSEA
             */
            /*
             *   for the symptoms HEADACHE
             */
            for (int i = 7; i < 8; i++) {
                s8 = map.get(13);
                for (int j = 0; j <= 1; j++) {
                    for (int k = 0; k <= 1; k++) {
                        for (int l = 0; l <= 1; l++) {
                            for (int m = 0; m <= 1; m++) {
                                for (int n = 0; n <= 1; n++) {
                                    for (int o = 0; o <= 1; o++) {
                                        for (int p = 0; p <= 1; p++) {
                                            s2 = map.get(7);
                                            s1 = map.get(6);
                                            s3 = map.get(8);
                                            s4 = map.get(9);
                                            s5 = map.get(10);
                                            s6 = map.get(11);
                                            s7 = map.get(12);
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
                                            if (n == 0) {
                                                s5 = 1 - s5;
                                            }
                                            if (0 == 0) {
                                                s6 = 1 - s6;
                                            }
                                            if (p == 0) {
                                                s7 = 1 - s7;
                                            }
                                            PreparedStatement ps = db.con.prepareStatement("Select prob_pneumonia from pneumonia where"
                                                    + " FEVER= ? and LOWERTEMP=? and COUGH=? and CHESTPAIN=? and BREATHSHORT=? "
                                                    + "and FATIGUE=? and NAUSEA=? and HEADACHE=?");
                                            ps.setInt(1, j);
                                            ps.setInt(2, k);
                                            ps.setInt(3, l);
                                            ps.setInt(4, m);
                                            ps.setInt(5, n);
                                            ps.setInt(6, o);
                                            ps.setInt(7, p);
                                            ps.setInt(8, 1);
                                            ResultSet rs = ps.executeQuery();
                                            while (rs.next()) {
                                                tempProb[i] += rs.getFloat("prob_pneumonia") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8;
                                            }

                                        }

                                    }

                                }
                            }
                        }

                    }
                }

            }
            /*
             *   end of the symptoms HEADACHE
             */
            for (int i = 0; i < 5; i++) {
                System.out.println("The value of the temp[" + i + "] are:" + tempProb[i]);
                returnValue *= tempProb[i];
            }

        } catch (Exception ex) {
            Logger.getLogger(CalculateProbPneumonia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (returnValue * pd) / ps;
    }
}
