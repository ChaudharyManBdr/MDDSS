<%-- 
    Document   : check_user
    Created on : Jul 26, 2015, 2:51:52 PM
    Author     : Manav
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.services.DbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            int count=0;
            String result;
         String name=request.getParameter("username");
         DbConnection db = new DbConnection();
         PreparedStatement pst = db.con.prepareStatement("select username from patient_info where username=?");
         pst.setString(1,name);
         db.rs =pst.executeQuery();
         while(db.rs.next())
         {
             count++;
         }
         if(count==0)
         {
             result="valid username";
         }
         else
         {
             result="invalid username";
         }
    response.setContentType("text/html");
        response.getWriter().write(result);
        %>
   
