package business.service;

import database.services.DiseaseProbability;
import database.services.Diseaseinfo;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manav
 */
public class CalculateProb {

    double result_probability;
    
    public void calculate(int disease_id, int symptoms_id[]) {
        int flag = 0;
            System.out.println("The disease_id is "+disease_id);
        Map<Integer, Double> map = symptoms_map(disease_id);
        for (int key : map.keySet()) {
            for (int j = 0; j < symptoms_id.length; j++) {
                if (key == symptoms_id[j]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                map.put(key, 0.05);
            }
            flag = 0;
        }
 
        DiseaseProbability dp = new DiseaseProbability();
        Diseaseinfo data;
        data = new Diseaseinfo();
        if (disease_id == 0) {
            
            dp.setP_s(0.000075);
            
            dp.setP_d(data.getDiseaseProbability(disease_id));
            dp.setSympProbMap(map);
            ConditionalProbPiles cndp = new ConditionalProbPiles();
            result_probability = cndp.findConditionalProb(dp);
       
            
        } else if (disease_id == 1) {
            
            dp.setP_s(0.00000001875);
            dp.setP_d(data.getDiseaseProbability(disease_id));
             dp.setSympProbMap(map);
            CalculateProbPneumonia cndp = new CalculateProbPneumonia();
            result_probability = cndp.findConditionalProb(dp);
       
            
        } else if (disease_id == 2) {
            
            dp.setP_s(0.00000000005);
            dp.setP_d(data.getDiseaseProbability(disease_id));
             dp.setSympProbMap(map);
            ConditionalProbAsthma cndp = new ConditionalProbAsthma();
            result_probability = cndp.findConditionalProb(dp);
          
            
        }

    }

    Map<Integer, Double> symptoms_map(int disease_id) {

        Map<Integer, Double> map;
       
        Diseaseinfo data = new Diseaseinfo();
        map = data.retrieveMap(disease_id);
        return map;

    }


    public double get_result() {
        return this.result_probability;
    }

}
