<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.services.Patientinfo"%>
<%@page import="database.services.DbConnection"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<html>
    <head>
        <title>MDDSS</title>

        <link href="css/style.css" rel="stylesheet"/>
        <style type="text/css">
            /* Start by setting display:none to make this hidden.
           Then we position it in relation to the viewport window
           with position:fixed. Width, height, top and left speak
           speak for themselves. Background we set to 80% white with
           our animation centered, and no-repeating */
            body{
                background-color:#18ab29;
            }

            table tr th,td
            {
                padding: 5px;

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
        <script src="library/jquery-1.11.3.min.js" language="javascript">

        </script>
        <script src="library/asthmaauto.js" language="javascript"></script>
        <script src="library/pneumoniaauto.js" language="javascript"></script>
        <script src="library/piles.js" language="javascript"></script>
        <script type="text/javascript">
            $body = $("body");
            $(document).ajaxStart(function() {
                $("body").addClass("loading");


            });
            $(document).ajaxStop(function() {
                $("body").removeClass("loading");

            });
            $(document).ready(function() {


                //form submitting to the servlet page              
                $("form").on("submit", function() {
                    var form = $("form");

                    $.ajax({
                        type: form.attr('method'),
                        url: form.attr('action'),
                        data: form.serialize(),
                        success: function(data) {


                            var result = $(".bottom_result_bar");
                            var scrollpos = result.offset().top;

                            $(window).scrollTop(scrollpos);
                            result.html(data);
                        }

                    });

                    return false;
                });

                //end of the form submitting form the form.         

            });

        </script>
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

            <div style="background-color:#DDDDDD;width:100%;height:86%">

                <div class="sideMenu" style="background-color: #F5F5F5;">
                    <div id="welcome" style="font-family:sans-serif;font-style:initial;font-size: 28px;">Patient Information<br/><br/>
                        <table border="0" style="margin-left: 25px;">
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

                                    <a href="history.jsp" class="btn  btn-success">View History!</a>
                                </td>
                            </tr>
                            <tr>   

                                <td colspan="2">
                                    <a href="logout.jsp" class="btn btn-primary">Logout</a>
                                </td>
                            </tr>
                        </table>
                    </div>




                </div><!-- End of sideMenu -->
                <div class="right_sidebar" style="background-color:#F5F5F5;"> 

                    <form action="proceed" method="post">
                        <h2>Select Symptoms</h2><br/>
                        <%
                            int disease_id = 0;
                            int symptoms_id;
                            String symptoms;
                            int count = 1;

                            int piles_count = 0, pneumonia_count = 0, asthma_count = 0, counter = 1;

                            try {
                                DbConnection db = new DbConnection();
                                while (count < 4) {
                                    PreparedStatement pst = db.con.prepareStatement("select id,symptom from symptoms where disease_id=?");
                                    pst.setInt(1, disease_id);
                                    db.rs = pst.executeQuery();
                                    while (db.rs.next()) {

                                        symptoms_id = db.rs.getInt(1);
                                        symptoms = db.rs.getString("symptom");

                        %>
                        <div  id="row<%= symptoms_id%>" style="background-color:white;border-radius: 3px;color: red;margin-bottom:3px;padding-top:7px;padding-left: 10px;font-size: 15px;">
                            <b><%=symptoms%></b>&nbsp;&nbsp; 
                            <div style="float:right;"class="radiocheck">
                                <input type="radio" name="symptom<%=symptoms_id%>" value="<%= disease_id + " " + symptoms_id%>" id="yes<%=symptoms_id%>"><label for="yes<%=symptoms_id%>">Yes</label>
                                <input type="radio" name="symptom<%=symptoms_id%>" value="null" id="no<%=symptoms_id%>"><label for="no<%=symptoms_id%>">No</label>
                                &nbsp;&nbsp;</div> <br/><br/>
                            <input type="hidden" name="username" value="<%= username%>">

                        </div>


                        <%
                                        counter++;
                                        if (disease_id == 0) {
                                            piles_count++;
                                            if (piles_count == 2) {
                                                disease_id = 1;
                                                break;
                                            }
                                        }
                                        if (disease_id == 1) {
                                            pneumonia_count++;
                                            if (pneumonia_count == 3) {
                                                disease_id = 2;
                                                break;
                                            }
                                        }
                                        if (disease_id == 2) {
                                            asthma_count++;
                                            if (asthma_count == 3) {
                                                break;
                                            }
                                        }
                                    }
                                    /*
                                     * end of the inner while loop
                                     */
                                    count++;
                                }
                                /* end of the  outer while loop*/
                            } catch (Exception ex) {
                                ex.getMessage();
                            }

                        %>
                        <br/>






                </div><!-- End of right sidebar --->
                <div class="right_sidebar_bellow">
                    <input type="submit" name="btn" id="submit_btn" value="Proceed" class="btn btn-lg btn-primary"> 

                </div>
                </form>	

                <div  class="bottom_result_bar" style="background-color:#F5F5F5;font-style: oblique;">


                </div> <!-- End of bottom result div -->
            </div>



        </div> <!-- end of container div -->

        <div class="modal">
        </div>
        <div id="footer"><h3 align="center">&copy;Bimal Tamang,Harish Thagunna and Man Bdr Chaudhary</h3></div>



    </body>


</html>
