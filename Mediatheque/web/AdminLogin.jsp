<%-- 
    Document   : AdminLogin
    Created on : Nov 13, 2013, 10:03:52 PM
    Author     : vannaraloch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>

        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Add custom CSS here -->
        <link href="bootstrap/css/login.css" rel="stylesheet">   
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/themes/smoothness/jquery-ui.css" media="all" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="pnotify/css/jquery.pnotify.default.css">
        <link rel="stylesheet" type="text/css" href="pnotify/css/jquery.pnotify.default.icons.css">
    </head>
    <body background='img/bg.jpg'>
        <div class="container">

            <div class="span6"></div>   
            <div class="row center">

                <div class="col-xs-12 col-sm-12 col-md-7">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                Log in</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-xs-3 col-sm-3 col-md-3 separator social-login-box"> 

                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6 login-box">
                                    <form role="form">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                            <input type="text" id="txtUserName" class="form-control" placeholder="Username" required autofocus />
                                        </div>
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                            <input type="password" id="txtPassword" class="form-control" placeholder="Password" required />
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-3">

                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-8">
                                    <button type="button" class="btn btn-labeled btn-success" id="btnLogin">
                                        <span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Login</button>
                                    <button type="button" class="btn btn-labeled btn-danger" id="btnCancel">
                                        <span class="btn-label"><i class="glyphicon glyphicon-remove"></i></span>Cancel</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JavaScript -->
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- Make sure to add jQuery - download the most recent version at http://jquery.com/ -->
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="bootstrap/js/jquery.js"></script>
        <script type="text/javascript" src="pnotify/js/jquery.pnotify.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $(".social-login-box").height($(".login-box").height() - 160);

                $("#btnLogin").click(function() {
                    var username = $("#txtUserName").val();
                    var password = $("#txtPassword").val();
                    if (username == "admin" && password == "admin") {
                        window.location = "HomeAdmin.jsp";
                    }
                    else {
                        $.pnotify({
                            title: 'Bad attempt!',
                            text: 'Either username or password is wrong',
                            styling: 'jqueryui',
                            type: 'error',
                            delay: 3000,
                            stack:false                            
                        });
                    }
                });

                $("#btnCancel").click(function() {
                    //                    alert("hi");
                });
            });
        </script>

    </body>
</html>
