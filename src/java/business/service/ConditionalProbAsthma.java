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
 * @author Harish Thagunna
 */
public class ConditionalProbAsthma {

    double pd;
    double ps;
    Map<Integer, Double> map;
    double returnValue = 1.0;

    /**
     *
     * @param dp
     * @return returnValue
     */
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
            double s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
            double[] tempProb = new double[10];

            //for s1=INFLABRO
            for (int i = 0; i <1; i++) {

                s1 = map.get(14);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s2 = map.get(15);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (p == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, 1);
                                                    ps.setInt(2, j);
                                                    ps.setInt(3, k);
                                                    ps.setInt(4, l);
                                                    ps.setInt(5, m);
                                                    ps.setInt(6, n);
                                                    ps.setInt(7, o);
                                                    ps.setInt(8, p);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            } 

             //for s2=COUGHNIGHT
            for (int i = 1; i <2; i++) {

                s2 = map.get(15);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (p == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, 1);
                                                    ps.setInt(3, k);
                                                    ps.setInt(4, l);
                                                    ps.setInt(5, m);
                                                    ps.setInt(6, n);
                                                    ps.setInt(7, o);
                                                    ps.setInt(8, p);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
            //for s3=WHEEZ
            for (int i = 2; i <3; i++) {

                s3 = map.get(16);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (p == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, 1);
                                                    ps.setInt(4, l);
                                                    ps.setInt(5, m);
                                                    ps.setInt(6, n);
                                                    ps.setInt(7, o);
                                                    ps.setInt(8, p);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
             //for s4=SHORTBREATH
            for (int i = 3; i <4; i++) {

                s4 = map.get(17);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s3 = map.get(16);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (p == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, l);
                                                    ps.setInt(4, 1);
                                                    ps.setInt(5, m);
                                                    ps.setInt(6, n);
                                                    ps.setInt(7, o);
                                                    ps.setInt(8, p);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
            //for s5=CHESTPAIN
            for (int i = 4; i <5; i++) {

                s5 = map.get(18);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (p == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, l);
                                                    ps.setInt(4, m);
                                                    ps.setInt(5, 1);
                                                    ps.setInt(6, n);
                                                    ps.setInt(7, o);
                                                    ps.setInt(8, p);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
             //for s6=LOOSEBREATH
            for (int i = 5; i <6; i++) {

                s6 = map.get(19);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (p == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, l);
                                                    ps.setInt(4, m);
                                                    ps.setInt(5, n);
                                                    ps.setInt(6, 1);
                                                    ps.setInt(7, o);
                                                    ps.setInt(8, p);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
             //for s7=COUGH
            for (int i = 6; i <7; i++) {

                s7 = map.get(20);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s6 = 1 - s6;
                                                    }
                                                    if (p == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, l);
                                                    ps.setInt(4, m);
                                                    ps.setInt(5, n);
                                                    ps.setInt(6, o);
                                                    ps.setInt(7, 1);
                                                    ps.setInt(8, p);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
            //for s8=GROUCHY
            for (int i = 7; i <8; i++) {

                s8 = map.get(21);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s9 = map.get(22);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s6 = 1 - s6;
                                                    }
                                                    if (p == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (q == 0) {
                                                        s9 = 1 - s9;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, l);
                                                    ps.setInt(4, m);
                                                    ps.setInt(5, n);
                                                    ps.setInt(6, o);
                                                    ps.setInt(7, p);
                                                    ps.setInt(8, 1);
                                                    ps.setInt(9, q);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
            //for s9=LUNGCHANGE
            for (int i = 8; i <9; i++) {

                s9 = map.get(22);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s10 = map.get(23);
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
                                                    if (o == 0) {
                                                        s6 = 1 - s6;
                                                    }
                                                    if (p == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (q == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (r == 0) {
                                                        s10 = 1 - s10;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, l);
                                                    ps.setInt(4, m);
                                                    ps.setInt(5, n);
                                                    ps.setInt(6, o);
                                                    ps.setInt(7, p);
                                                    ps.setInt(8, q);
                                                    ps.setInt(9, 1);
                                                    ps.setInt(10, r);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            
             //for s10=COLDALLER
            for (int i = 9; i <10; i++) {

                s10 = map.get(23);

                for (int j = 1; j >= 0; j--) {
                    for (int k = 1; k >= 0; k--) {
                        for (int l = 1; l >= 0; l--) {
                            for (int m = 1; m >= 0; m--) {
                                for (int n = 1; n >= 0; n--) {
                                    for (int o = 1; o >= 0; o--) {
                                        for (int p = 1; p >= 0; p--) {
                                            for (int q = 1; q >= 0; q--) {
                                                for (int r = 1; r >= 0; r--) {

                                                    s1 = map.get(14);
                                                    s2= map.get(15);
                                                    s3 = map.get(16);
                                                    s4 = map.get(17);
                                                    s5 = map.get(18);
                                                    s6 = map.get(19);
                                                    s7 = map.get(20);
                                                    s8 = map.get(21);
                                                    s9 = map.get(22);
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
                                                    if (o == 0) {
                                                        s6 = 1 - s6;
                                                    }
                                                    if (p == 0) {
                                                        s7 = 1 - s7;
                                                    }
                                                    if (q == 0) {
                                                        s8 = 1 - s8;
                                                    }
                                                    if (r == 0) {
                                                        s9 = 1 - s9;
                                                    }

                                                    PreparedStatement ps = db.con.prepareStatement("SELECT prob_asthma FROM asthma WHERE INFLABRO=? AND COUGHNIGHT=? AND WHEEZ=? AND SHORTBREATH=? AND CHESTPAIN=? AND 	LOOSEBREATH=? AND COUGH=? AND GROUCHY=? AND LUNGCHANGE=? AND COLDALLER=?");
                                                    ps.setInt(1, j);
                                                    ps.setInt(2, k);
                                                    ps.setInt(3, l);
                                                    ps.setInt(4, m);
                                                    ps.setInt(5, n);
                                                    ps.setInt(6, o);
                                                    ps.setInt(7, p);
                                                    ps.setInt(8, q);
                                                    ps.setInt(9, r);
                                                    ps.setInt(10, 1);
                                                    ResultSet rs = ps.executeQuery();
                                                    while (rs.next()) {
                                                        tempProb[i] += rs.getFloat("prob_asthma") * s1 * s2 * s3 * s4 * s5 * s6 * s7 * s8 * s9 * s10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
//return value calculation
            for (int i = 0; i < 5; i++) {
              //  System.out.println("The value of the temp are:" + tempProb[i]);
                returnValue *= tempProb[i];
            }
        } catch (Exception ex) {
            Logger.getLogger(ConditionalProbPiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (returnValue * pd) / ps;
    }

}
