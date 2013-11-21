<%-- 
    Document   : Borrow
    Created on : Nov 19, 2013, 9:16:56 PM
    Author     : vannaraloch
--%>

<%@page import="enterprise.web_jpa_war.entity.ItemCopy"%>
<%@page import="enterprise.web_jpa_war.entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrow item</title>

        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">

    </head>
    <script type="text/javascript">
        function gohome() {
            window.location = "ListBorrows";
         
        }

        function addToList() {
            var itemCopyCode = $("#itemCopyCode").val();
            
            $.ajax({
                url: "/Borrow?itemCopyCode=" + itemCopyCode,
                type: "GET"


            });
        }

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
                        <li><a href="ListBorrows"><b>Borrow</b></a></li>
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
                                <li><a href="ListOeuvres">Oeuvre</a></li>
                                <li><a href="ListCategories">Category</a></li>
                                <li><a href="ListItems">Item</a></li>
                                <li><a href="ListItemCopies">Item Copy</a></li>
                                <li class="divider"/>                      
                                <li><a href="#">User</a></li>                    
                            </ul>
                        </li>                
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>
        <div class="span12"> <h1 class="text-center">Borrow Item Transaction</h1>
        </div>
        <div class="span12"><br><br></div>

<!--        <div class="span12"> 
            <div class="span1"></div>
            <div class="span2 no-margin-left">
                <label class="span2 no-margin-left">Adherent Number:</label>
            </div>
            <div class="span5 no-margin-left">
                <input type="text" class ="span5  no-margin-left input-lg"/>

            </div>

        </div>-->
        <div class="span12 no-margin-left">
            <form id="listBorrowForm" action="Borrow" method="post" class="span12 no-margin-left">
            <div class="container">
                <div class="span2 no-margin-left"><label class="span2 no-margin-left">Adherent number:</label> </div>    
                <div class="span9 no-margin-left">
                    <input type="text" id="itemCopyId" class="span5 input-lg" name="adherentNumber"  value="<%=request.getAttribute("adherentNumber")%>" />                    
                </div>
                <div class="span2 no-margin-left"><label class="span2 no-margin-left">Item Copy Code:</label> </div>    
                <div class="span9 no-margin-left">
                    <input type="text" id="itemCopyId" class="span5 input-lg" name="itemCopyCode" />
                    <input type="submit" class="btn-primary btn-lg" onclick="addToList()" value="Add to List" name="action" />

                </div>

                <div class="span12"><br><br></div>
                <div class="span12">
                    <table class="table-hover table">
                        <tr>
                            <th class="span1">Copy ID</th>
                            <th class="span2">Copy Code</th>
                            <th class="span2">Category</th>
                            <th class="span2">Item title</th>
                            <th class="span2">Borrow Qty</th>  
<!--                            <th class="span2">Expected Return Date</th>  -->
                        </tr>
                        <%
                            List<ItemCopy> list = new ArrayList();
                            if (request.getAttribute("borrowList") != null) {
                                list.addAll((List) (request.getAttribute("borrowList")));

                            }
                        %>
                        <%            for (int i = 0; i < list.size(); i++) {
                        %>
                        <tr>
                            <td class="span1"><%=list.get(i).getItemCopyId()%></td>   
                            <td class="span2"><%=list.get(i).getItemCopyCode()%></td>   
                            <td class="span2"><%=list.get(i).getItem().getCategory().getCategoryName()%></td>   
                            <td class="span2"><%=list.get(i).getItem().getOeuvre().getTitle()%></td> 
                            <td class="span2">1</td>   
                        </tr> 

                        <%
                            }
                        %>                     
                    </table>
                    <br>
                    <input type="submit" class="btn-primary" name ="action" value="Save"/>
                    <input type="submit" class="btn-primary" name ="action" onclick="gohome()" value="Close" />

                    <br><br>

                </div>


            </div>
        </form>
                    </div>
        <script src="bootstrap/js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script>

        </script>
    </body>
</html>
