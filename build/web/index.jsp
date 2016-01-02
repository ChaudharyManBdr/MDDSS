<%-- 
    Document   : index
    Created on : Jul 10, 2015, 2:54:45 PM
    Author     : Bimal Tamang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>
            Link Page
        </title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet"/>
        <script src="library/jquery-1.11.3.min.js" language="javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script> 


        <script>
            $(document).ready(function() {

                $("#username").focusout(function() {
                    var value = $("#username").val();

                    if (value !== "" && value.length >= 4)
                    {
                        var datastring = 'username=' + value;

                        $.ajax({
                            type: "POST",
                            url: "check_user.jsp",
                            data: datastring,
                            cache: false,
                            success: function(data)
                            {

                                //alert(data);
                                if ($.trim(data) === "invalid username")
                                {
                                    $("#btn").prop("disabled", true);
                                    //$("#usenamespan").css("color","red");
                                    $("#usernamespan").html(data).show();
                                }
                                else
                                {
                                    //$("#usenamespan").css("color","green");
                                    $("#usernamespan").html(data).show();
                                }

                            }
                        });
                        // end of the ajax.


                    }
                    if (value.length < 4 && value.length > 1)
                    {
                        $("#usernamespan").text("length too short.. ").show();

                        $("#btn").prop("disabled", true);
                    }

                });
                $("#username").focusin(function() {
                    $("#btn").prop("disabled", false);
                    $("#usernamespan").hide();
                });


            });
        </script>

    </head>
    <body>
        <div id="container">
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog" style="width:500px;margin-top:180px;">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Login Section</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="SingleProceed" class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label class="control-label col-sm-2"style="margin-left:25px;">UserName:</label>
                                    <div class="col-sm-8">
                                        <input type="text" name="username"class="form-control" required="required" id="loginuser" autocomplete="off"/>
                                        <span class="help-block" style="display:none;" id="loginspan"></span>
                                    </div>
                                </div>
                                <div class="form-group">        
                                    <div class="col-sm-offset-2 col-sm-10"style="margin-left:110px;">

                                        <input type="submit" name="submit" value="Login"  class="btn btn-default"/>
                                    </div>
                                </div>
                                <!--start of the footer-->
                                <div class="modal-footer">
                                    <p>The project is in developing phase.</p>          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>

                                <!--end of the footer-->

                            </form>
                        </div>

                    </div>

                </div>
            </div>
            <!--end of the modal-->
            <div align="center">
                <img src="img/designtop.jpg"/> 


                <div align="center" style="width: 450px; padding:10px;" >
                    <form  method="post" action="NewProceed" class="form-horizontal" onsubmit="Submit.disabled = true;
                            return true;" role="form">
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="name">Name:</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="name" required="required" placeholder="Enter your name"style="width:250px;"id="name"/>
                                <span class="help-block" style="display:none;" id="namespan">Length must be 5</span>
                            </div>

                        </div>
                        <div class="form-group">

                            <label class="control-label col-sm-3" for="age">Age:</label>
                            <div class="col-sm-8">
                                <input class="form-control" type="text" name="age" required="required" placeholder="Enter age" style="width:250px;" id="age"/>
                                <span class="help-block" style="display:none;" id="agespan">Length must be 5</span>
                            </div>
                        </div>

                        <div class="form-group">

                            <label class="control-label col-sm-3">UserName:</label>
                            <div class="col-sm-8">
                                <input type="text" name ="username" required="required" autocomplete="off" class ="form-control"style="width:250px;" id="username" placeholder="Enter username.."/>
                                <span class="help-block"style="display:none;" id="usernamespan">Length must be 5</span>                
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-3" for="gender" > Gender: </label>

                            <div class="col-sm-8 radiocheck">
                                <input name="gender" type="radio" value="Male" id="male" />
                                <label for="male"> Male</label>  &nbsp;&nbsp;
                                <input name="gender" type="radio" value="Female" id="female"/>
                                <label for="female">Female</label> &nbsp;&nbsp;
                                <input name="gender" type="radio" value="Others" id="others"/>
                                <label for="others">Others</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" class="btn btn-lg btn-success" name="Submit" value="Submit"id="btn" />
                                <a href="#" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" title="Note!!!" id="click" data-trigger="hover" data-content="Login By Username">Existing User</a>
                            </div>
                        </div>
                        <script>
                            $(document).ready(function() {
                                $('#click').popover();

                            });
                        </script>
                    </form>

                </div>

            </div>
        </div>
    </body>

</html>


<!--jsp:forward page="nextpage.jsp"-->
