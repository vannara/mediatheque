<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register an ItemCopy</title>
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
    </head>
    <script type="text/javascript">
          function goback() {
            window.location = "CreateItemCopy.jsp";
            window.close();
        }
        
        function createItem() {
           document.forms['createItemCopyForm'].submit();
        }

        function SaveNew() {
            createItem();
            ClearForm();       
        }

        function SaveClose() {
                createItem();
                goback();    
        }  
    </script>
    <body>
        <div>
            <nav class="navbar navbar-fixed-top" role="navigation">

                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->
                        <a class="navbar-brand logo-nav"><img src="img/logo1.jpg" width="70%" height="50%"></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-ex1-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="AdminLogin.jsp"><b>Logout</b></a></li>
                            <li><a href="#Borrow"><b>Borrow</b></a></li>
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
                                    <li><a href="ListItems">Item</a></li>
                                    <li><a href="ListItemCopies">Item</a></li>
                                    <li class="divider"/>
                                    <li><a href="ListAdherents">Adherent</a></li>
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
            <div class="span12"> <h1 class="text-center">ItemCopy Record</h1>
            </div>
            <div class="span1"><br><br></div>
            <div class="span12">
                <div class="span3"><label></label></div>
                <div class="span5">
                    <form id="createItemCopyForm"  action="CreateItemCopy" method="post" class="span6">
                        <table>
                            <tr><td>Number of item copies :</td><td><input type="text" id="itemcopynb" required name="itemcopynb" /></td></tr>
                            <tr><td>Item Id associated</td><td><input type="text" id="itemid" required name="itemid" /></td></tr>
                        </table>
                        <hr>
                        <button class="btn-primary" onclick="SaveNew()" id="btnSaveNew">Save & New</button>
                        <button class="btn-primary" id="SaveClose" onclick="SaveClose()">Save & Close </button>
                        <button class="btn-primary" onclick="goback()">Return</button>
                    </form>
                <br><br>
                </div>
                <div class="span12">
                <h2> Items </h2>
                <table class="table table-hover">
                    <tr >
                        <th class="span1">ID</th>
                        <th class="span2">Item Number</th>
                        <th class="span2">Category</th>
                        <th class="span2">Title</th>                        
                    </tr>
                    <c:forEach var="item" begin="0" items="${requestScope.itemsList}">
                        <tr>
                            <td class="span1">${item.itemId}&nbsp;&nbsp;</td> 
                            <td class="span2">${item.itemNumber}&nbsp;&nbsp;</td> 
                            <td class="span2">${item.category.categoryName}&nbsp;&nbsp;</td> 
                            <td class="span2">${item.oeuvre.title}&nbsp;&nbsp;</td> 
                        </tr> 

                    </c:forEach>

                </table>
                </div>
      </div>
</div>
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</body>
</html>
