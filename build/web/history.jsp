<%-- 
    Document   : history
    Created on : Sep 5, 2015, 11:05:20 AM
    Author     : bimal
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.services.Patientinfo"%>
<%@page import="database.services.DbConnection"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet"/>
        <script src="library/jquery-1.11.3.min.js" language="javascript">

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>

        <style >




            .right_sidebar_history table   tr:nth-child(even) {background: #F5DEB3}
            .right_sidebar_history table  tr:nth-child(odd) {background: #f5f5f5}



            /* Start by setting display:none to make this hidden.
           Then we position it in relation to the viewport window
           with position:fixed. Width, height, top and left speak
           speak for themselves. Background we set to 80% white with
           our animation centered, and no-repeating */
            body{
                background-color: whitesmoke;
            }

            table tr th,td
            {
                padding: 0px;

            }
            a{
                text-decoration: none;

            }
            table tr th
            {
                text-align: left;


            }
            .modal {
                display:    none;
                position:   fixed;
                z-index:    1000;
                top:        0;
                left:       0;
                height:     100%;
                width:      100%;
                background: rgba( 255, 255, 255, .8 ) 
                    url('img/ajax-loader_new.gif') 
                    50% 50% 
                    no-repeat;
                // background: rgba( 255, 255, 255, .8 );


            }

            /* When the body has the loading class, we turn
               the scrollbar off with overflow:hidden */
            body.loading {
                overflow: hidden;   
            }

            /* Anytime the body has the loading class, our
               modal element will be visible */
            body.loading .modal {
                display: block;
            }


        </style>
    </head>
    <body>

        <%
            String username = (String) session.getAttribute("username");

            String name = null;
            int Age = 0;
            String Gender = null;
            if ((username != null)) {
                Patientinfo record = new Patientinfo();
                record.recieveData(username);
                name = record.getName();

                Age = record.getAge();

                Gender = record.getGender();

            } else {
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.forward(request, response);
            }

        %>

        <div class="container">


            <div id="header"><div id="banner"><img src="img/logo_mddss.jpg" /></div>



                <div class="navigation">
                    <div class="anchor_control">
                        <a href="nextpage.jsp" >Home</a>
                        <a href="#">Blogs</a>
                        <a href="#">Activity</a>
                        <a href="#">Documentation</a>
                        <a href="contacts.jsp">Contact Us</a>
                    </div>
                </div><!-- end of navigation--->
            </div>
            <div id="triangle"></div>

            <div style="background-color: #EAF2F2; width: 100%;height: 82%;">

                <div class="sideMenu" style="background-color:#f5f5f5;">
                    <div id="welcome" style="font-family: sans-serif;font-style: initial;font-size: 28px;">Patient Information</div>

                    <table border="0" style="margin-left: 0px;font-size: 20px;">
                        <tr>  
                            <th>Username:</th><td><%=username%></td>
                        </tr>

                        <tr>  
                            <th>Name:</th><td><%=name%></td>
                        </tr>

                        <tr>  
                            <th>Age:</th><td><%=Age%></td>
                        </tr>

                        <tr>  
                            <th>Gender:</th><td><%=Gender%></td>
                        </tr>
                        <tr>

                            <td colspan="2">

                                <a href="nextpage.jsp" class="btn  btn-success">Back To Home!</a>
                            </td>
                        </tr>
                        <tr>   

                            <td colspan="2">
                                <a href="logout.jsp" class="btn btn-primary">Logout</a>
                            </td>
                        </tr>
                    </table>






                </div><!-- End of sideMenu -->
                <div class="right_sidebar_history">  
                    <table style="border:1px solid black;border-collapse:collapse; font-size: 22px; width: 709px;margin-left: -9px;">
                        <tr style="height: 10px;">
                            <th style="border:1px solid black;">Id</th>
                            <th style="border:1px solid black;">Result</th>
                            <th style="border:1px solid black;">Date</th> 
                        </tr>  
                        <%
                            String userName = (String) session.getAttribute("username");
                            DbConnection db = new DbConnection();
                            PreparedStatement ps = db.con.prepareStatement("select * from history where username=?");
                            ps.setString(1, userName);
                            db.rs = ps.executeQuery();
                            while (db.rs.next()) {
                        %>
                        <tr style="height: 10px;">
                            <td style="border:1px solid black;"><%= db.rs.getInt("id")%></td>
                            <td style="border:1px solid black;"><%= db.rs.getString("result")%></td>
                            <td style="border:1px solid black;"><%= db.rs.getString("date")%></td>
                        </tr>  

                        <%
                            }
                        %>
                    </table>
                </div><!-- End of right sidebar history --->






            </div>
        </div> <!-- end of container div -->


        <div id="footer" style="margin-top: -35px;"><h3 align="center">&copy; Bimal Tamang, Harish Thagunna and Man Bdr. Chaudhary</h3></div>



    </body>

</html>
