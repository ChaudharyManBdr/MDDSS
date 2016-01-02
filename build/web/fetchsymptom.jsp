<%-- 
    Document   : fetchsymptom
    Created on : Jul 26, 2015, 7:36:45 PM
    Author     : bimal
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="database.services.Dynamicfetch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String values= request.getParameter("data");
            String symptoms[]=values.split(" ");
            int disease_id=0;
            int symptoms_id[]={};
            
            Map<Integer,String>dmap = new HashMap<>();
            for(int i=0;i<values.length();i++)
            {
              if(i==0)
              {
                  disease_id=Integer.parseInt(symptoms[i]);
              }
              symptoms_id[i-1]=Integer.parseInt(symptoms[i]);
            }
            Dynamicfetch object = new Dynamicfetch();
            object.setDisease_id(disease_id);
            object.setSymptoms_id(symptoms_id);
           // dmap=object.fetch_data();
            
                 
        %>
    </body>
</html>
