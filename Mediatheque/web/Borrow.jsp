<%-- 
    Document   : Borrow
    Created on : Nov 19, 2013, 9:16:56 PM
    Author     : vannaraloch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrow item</title>

        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">

    </head>
    <script type="text/javascript">
        function gohome() {
            window.location = "HomeAdmin.jsp";
        }

//        function addToList() {
//            var itemCopyId = $("#itemCopyId").val();
//            alert("called " + itemCopyId);
//            
//            $.ajax({
//                url: "/Borrow?action=add&itemCopyId=" + itemCopyId,
//                type: "GET"
//                
//            });
//        }

    </script>
    <body>
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
                        <li><a href="Borrow"><b>Borrow</b></a></li>
                        <li><a href="#Return"><b>Return</b></a></li>
                        <li><a href="#Order"><b>Order</b></a></li>
                        <li><a href="#ReceiveDelivery"><b>Receive Order</b></a></li>
                        <li><a href="#Reservation"><b>Reservation</b></a></li>
                        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Manage Adherent</b></a>
                            <ul class="dropdown-menu">
                                <li><a href="CreateAdherent">Create a new adherent</a></li>
                                <li><a href="ListAdherents">List adherent</a></li> 
                            </ul>       
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <b> Configuration</b>                     
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Oeuvre</a></li>
                                <li><a href="ListCategories">Category</a></li>
                                <li><a href="ListItems">Item</a></li>
                                <li class="divider"/>                      
                                <li><a href="#">User</a></li>                    
                            </ul>
                        </li>                
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>        
        <div class="container">
            <div class="span12"> <h1 class="text-center">Borrow Item Transaction</h1>
            </div>
            <div class="span12"><br><br></div>
            <form id="listBorrowForm" action="Borrow" method="post" class="span12 no-margin-left">

                <div class="span10">
                    <input type="text" id="itemCopyId" class="span5 input-lg" name="itemCopyId" required />
                    <button class="btn-primary btn-lg" id="btnAdd" name="btnAdd">Add to list</button>

                </div>

                <div class="span12"><br><br></div>
                <div class="span12">
                    <table class="table-hover table">
                        <tr>
                            <th class="span2">Copy Code</th>
                            <th class="span2">Category</th>
                            <th class="span2">Item title</th>
                            <th class="span2">Borrow Qty</th>                              
                        </tr>
                        <c:forEach var="item" begin="0" items="${requestScope.borrowList}" >
                            <tr>
                                <td class="span1">${item.itemCopyCode}</td> 
                                <td class="span2">${item.itemCopyCode}</td> 
                                <td class="span2">${item.itemCopyCode}</td> 
                                <td class="span2">${item.itemCopyCode}</td> 
                            </tr> 

                        </c:forEach>
                            <tbody id="borrowData">
                                
                            </tbody>

                    </table>
                    <br>
                    <input type="submit" class="btn-primary" name ="action" value="Save"/>
                    <input type="submit" class="btn-primary" name ="action" onclick="gohome()" value="Close" />

                    <br><br>

                </div>
            </form>

        </div>
        <script src="bootstrap/js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script>
            $(document).ready(function() {                        // When the HTML DOM is ready loading, then execute the following function...
                $('#btnAdd').click(function() {               // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
                    $.get('Borrow', function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                        $('#borrowData').html(responseText);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                    });
                });
            });
        </script>
    </body>
</html>
