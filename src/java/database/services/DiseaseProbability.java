package database.services;

import java.util.Map;

public class DiseaseProbability {

    double p_d;
    double p_s;
    Map<Integer, Double> sympProbMap;

    public Map<Integer, Double> getSympProbMap() {
        return sympProbMap;
    }

    public void setSympProbMap(Map<Integer, Double> sympProbMap) {
        this.sympProbMap = sympProbMap;
    }

    public double getP_d() {
        return p_d;
    }

    public void setP_d(double p_d) {
        this.p_d = p_d;
    }

    public double getP_s() {
        return p_s;
    }

    public void setP_s(double p_s) {
        this.p_s = p_s;
    }

}
