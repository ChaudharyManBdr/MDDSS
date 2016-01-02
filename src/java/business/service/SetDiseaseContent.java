package business.service;

import java.util.ArrayList;


public class SetDiseaseContent {

    double prob_value;
    int symptoms_id[]=null;
    int disease_id;

    public SetDiseaseContent(int disease_id, ArrayList<Integer> list){
       int length;
        length=list.size();
        symptoms_id = new int[length];
        this.disease_id = disease_id;
        /*
        * testing the list value
        *
        */
      
        for (int i=0; i<length; i++) {
            symptoms_id[i] = list.get(i);
            /*
            * for testing the symptoms_id 
             */
            System.out.println("symptoms_id is"+symptoms_id[i]);
        }
        
        CalculateProb calc_prob=new CalculateProb();
        try
        {
        calc_prob.calculate(disease_id, symptoms_id);
        prob_value=calc_prob.get_result();
        System.out.println("Returning the probability value is "+prob_value);
        }catch(Exception e)
        {
            System.err.println("The error is something here"+e);
        }
    }
    

   public double get_probability() {

       //prob_value=0.01;
       return prob_value;
    }

}
