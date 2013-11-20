<%-- 
    Document   : CreateCategory
    Created on : Nov 03, 2013
    Author     : vannaraloch
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a category Record</title>
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
    </head>
    <script type="text/javascript">
        function goback() {
            window.location = "ListCategories";

        }

    </script>
    <body>
        <div>
            <nav class="navbar navbar-fixed-top" role="navigation">

                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand logo-nav"><img src="img/logo1.jpg" width="70%" height="50%"></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-ex1-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="AdminLogin.jsp"><b>Logout</b></a></li>
                            <li><a href="Borrow"><b>Borrow</b></a></li>
                            <li><a href="#Return"><b>Return</b></a></li>
                            <li><a href="#Order"><b>Order</b></a></li>
                            <li><a href="#ReceiveDelivery"><b>Receive Order</b></a></li>
                            <li><a href="#Reservation"><b>Reservation</b></a></li>
                            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Manage Adherent</b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="CreateAdherent.jsp">Create a new adherent</a></li>
                                    <li><a href="ListAdherents">List adherent</a></li> 
                                </ul>       
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <b> Configuration</b>                     
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="ListOeuvres">Oeuvre</a></li>
                                    <li><a href="ListCategories">Category</a></li>
                                    <li><a href="CreateItem.jsp">Item</a></li>
                                    <li class="divider"/>
                                    <li><a href="#">Adherent</a></li>
                                    <li><a href="#">User</a></li>                    
                                </ul>
                            </li>                
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container -->
            </nav>
        </div>
        <br> 
        <div class="container" >
            <div class="span12"> <h1 class="text-center">Category Record</h1>
            </div>
            <div class="span1"><br><br></div>
            <div class="span12">
                <div class="span3"><label></label></div>
                <div class="span5">
                    <form id="createCategoryForm" action="CreateCategory" target="categoryWindow" method="post" class="span6">
                        <table>
                            <tr><td><input type="text" class="hidden" id="categoryId" name="categoryId"  value="<%=request.getAttribute("categoryId")%>" /></td></tr> 
                            <tr><td>category name</td><td><input type="text" id = "categoryName" name="categoryName"  value="<%=request.getAttribute("categoryName")%>" required/></td></tr>
                            <tr><td>max Borrow duration</td><td><input type="text" id = "maxBorrowDuration" name="maxBorrowDuration"  value="<%=request.getAttribute("maxBorrowDuration")%>" required number/></td></tr>
                            <tr><td>max Borrow Qty</td><td><input type="text" id = "maxBorrowQty"  name="maxBorrowQty"  value="<%=request.getAttribute("maxBorrowQty")%>" required /></td></tr>
                            <tr><td>is Renewable</td><td><input type="checkbox" id="chkIsRenewable" name ="chkIsRenewable" value="<%=request.getAttribute("isRenewable")%>"/></td></tr>
                        </table>
                        <br>
                        <input type="submit" class="btn-primary" name ="action" value="Save & New"/>
                        <input type="submit" class="btn-primary" name ="action" value="Save & Close" />
                        <input type="button" class="btn-primary" onclick="goback()" value="Return"/>

                    </form>
                    <br><br>

                </div>
            </div>
        </div>
        <script src="bootstrap/js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>

    </body>
    <script type="text/javascript">
                            $(document).ready(function() {
                               var isRenewable= $("#chkIsRenewable").val();
                               if(isRenewable=="checked"){
                                   $("#chkIsRenewable").attr('checked','checked');
                               }
                               
                            });
    </script>
</html>
