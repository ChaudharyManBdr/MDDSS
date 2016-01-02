/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.service.SetDiseaseContent;
import business.service.StoreResult;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Manav
 */
@WebServlet(name = "proceed", urlPatterns = {"/proceed"})
public class proceed extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ArrayList<Integer> s_ids_piles = new ArrayList<>();
    ArrayList<Integer> s_ids_pneumonia = new ArrayList<>();
    ArrayList<Integer> s_ids_asthma = new ArrayList<>();

    int piles_id = 0;
    int pneumonia_id = 1;
    int asthma_id = 2;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       double prob1 = 0, prob2 = 0, prob3 = 0;
        String id[] = new String[26];
        for (int i = 0; i < 26; i++) {
            id[i] = "null";
            String symptom = "symptom" + i;
            if (request.getParameter(symptom) != null) {
                id[i] = request.getParameter(symptom);
            }
        }

        String[] in_symp;
        //for symptom1
        for (int i = 0; i < 26; i++) {
            if (!(id[i].equals("null"))) {
                in_symp = id[i].split(" ");
                System.out.println("The selected item is " + id[i]);
                System.out.println("The disease_id is " + in_symp[0]);
                // System.out.println("The symptoms_id is "+in_symp[1]);
                if (Integer.parseInt(in_symp[0]) == piles_id) {
                    s_ids_piles.add(Integer.parseInt(in_symp[1]));
                } else if (Integer.parseInt(in_symp[0]) == asthma_id) {
                    s_ids_asthma.add(Integer.parseInt(in_symp[1]));
                } else if (Integer.parseInt(in_symp[0]) == pneumonia_id) {
                    s_ids_pneumonia.add(Integer.parseInt(in_symp[1]));
                }

            }
        }

        if (!(s_ids_piles.isEmpty())) {
            System.out.println("**************************************************************************");
            SetDiseaseContent gdc1 = new SetDiseaseContent(piles_id, s_ids_piles);
            s_ids_piles.clear();
            prob1 = gdc1.get_probability();
            System.out.println("The probability of piles is " + prob1);
        }

        if (!(s_ids_pneumonia.isEmpty())) {
            System.out.println("**************************************************************************");

            SetDiseaseContent gdc2 = new SetDiseaseContent(pneumonia_id, s_ids_pneumonia);
            s_ids_pneumonia.clear();
            prob2 = gdc2.get_probability();
            System.out.println("The probability of pneumonia is " + prob2);
        }
        if (!(s_ids_asthma.isEmpty())) {
            System.out.println("**************************************************************************");
            SetDiseaseContent gdc3 = new SetDiseaseContent(asthma_id, s_ids_asthma);
            s_ids_asthma.clear();
            prob3 = gdc3.get_probability();
            System.out.println("The probability of asthma is " + prob3);
            System.out.println("**************************************************************************");
        }
        double per_piles = 0;
        if (prob1 > 0.00000131) {
            per_piles = ((prob1 - 0.00000132) / (0.00585973508 - 0.00000132)) * 100;
            System.out.println("Piles_Per: " + per_piles);
        }
        double per_pneumonia = 0;
        if (prob2 > 0.00118) {
            per_pneumonia = ((prob2 - 0.00118) / (0.6492 - 0.00118)) * 100;
            System.out.println("Pneumonia_per: " + per_pneumonia);
        }
        double per_asthma = 0;
        if (prob3 > 0.00360546) {
            per_asthma = ((prob3 - 0.00360547) / (0.4333516477 - 0.00360547)) * 100;
            System.out.println("Per_Asthma: " + per_asthma);
        }
        String result = null;
        if (per_piles > 25.0 || per_pneumonia > 25.0 || per_asthma > 25.0) {
            if (per_piles > per_pneumonia) {
                if (per_piles > per_asthma) {
                    result = "You have Piles";
                } else {
                    result = "You have Asthma";
                }
            } else {
                if (per_pneumonia > per_asthma) {
                    result = "You have pneumonia";
                } else {
                    result = "You have asthma";
                }
            }

        } else {
            result = "Not enough input";
        }
        if (!(result.equalsIgnoreCase("Not enough input"))) {
            try {
                String uname = request.getParameter("username");
                new StoreResult(uname, result);
            } catch (Exception ex) {
                Logger.getLogger(proceed.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // String result="<h3> Result: </h3><br/>The percentage of piles is "+per_piles+"<br/> The percentage of pneumonia is "+per_pneumonia+"<br/> The Percentage of asthma is "+per_asthma;
        String reply = "<h1> Result: </h1><br/>" + "<h2>" + result + "</h2>";
        response.setContentType("text/html");
        response.getWriter().write(reply);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
