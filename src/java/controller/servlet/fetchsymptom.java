/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import business.service.Disease;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import database.services.Dynamicfetch;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manav
 */
@WebServlet(name = "fetchsymptom", urlPatterns = {"/fetchsymptom"})
public class fetchsymptom extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet fetchsymptom</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet fetchsymptom at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        // processRequest(request, response);
        String disease_id = request.getParameter("data");

        int symptoms[];
         //System.out.println(disease_id);
        //System.out.println(array[0]+array[1]+array[2]);
        String array[] = disease_id.split(" ");
        int size = array.length - 1;

        int disease = Integer.parseInt(array[0]);
        if (disease == 0) {
            symptoms = new int[size];
        } else {
            symptoms = new int[3];
        }
        if (disease == 0) {
            symptoms[0] = 1;
            symptoms[1] = 2;
        }
        if (disease == 2) {
            symptoms[0] = 14;
            symptoms[1] = 15;
            symptoms[2] = 16;
        }
        if (disease == 1) {
            symptoms[0] = 6;
            symptoms[1] = 7;
            symptoms[2] = 8;
        }

        Dynamicfetch fetch;
        fetch = new Dynamicfetch();

        fetch.setDisease_id(disease);
        fetch.setSymptoms_id(symptoms);
        List<Disease> list = fetch.fetch_data(fetch);
        Gson gson = new Gson();
        JsonElement element;
        element = gson.toJsonTree(list, new TypeToken<List<Disease>>() {
        }.getType());
        JsonArray jsonarray = element.getAsJsonArray();
        System.out.println(jsonarray);
        response.setContentType("application/json");
        response.getWriter().print(jsonarray);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
