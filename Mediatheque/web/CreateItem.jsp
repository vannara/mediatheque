<!--
  Copyright (c) 2010, Oracle. All rights reserved.

  Redistribution and use in source and binary forms, with or without
  modification, are permitted provided that the following conditions are met:

  * Redistributions of source code must retain the above copyright notice,
    this list of conditions and the following disclaimer.

  * Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.

  * Neither the name of Oracle nor the names of its contributors
    may be used to endorse or promote products derived from this software without
    specific prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
  INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
  CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
  THE POSSIBILITY OF SUCH DAMAGE.
-->

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register an Item</title>
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/logo-nav.css" rel="stylesheet">
    </head>
    <script type="text/javascript">
          function goback() {
            window.location = "ListItems.jsp";
            window.close();
        }
        
        function createItem() {
           document.forms['createItemForm'].submit();
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
        <div class="span12 no-margin-left" >
            <div class="span12 no-margin-left"> <h1 class="text-center">Item Record</h1>
            </div>
            <div class="span1"><br><br></div>
            <div class="span12">
                <div class="span3"><label></label></div>
                <div class="span5">
                    <form id="createItemForm"  action="CreateItem" method="post" class="span6">
                        <table>
                            <tr><td>Code bar Article :</td><td><input type="text" id="itemnb" required name="itemnb" /></td></tr>
                            <tr><td>IdOeuvre</td><td><input type="text" id="oeuvreid" required name="oeuvreid" /></td></tr>
                            <tr><td>IdCategorie :</td><td><input type="text" id="categoryid" required name="categoryid" /></td></tr>
                        </table>
                        <hr>
                        <button class="btn-primary" onclick="SaveNew()" id="btnSaveNew">Save & New</button>
                        <button class="btn-primary" id="SaveClose" onclick="SaveClose()">Save & Close </button>
                        <button class="btn-primary" onclick="goback()">Create another Item</button>
                    </form>
                <br><br>
             
         
             
             
             
             
                </div>
                <div class="span4">
                <h2> Categories </h2>
                <table id="cateListTable" class="table table-hover">
                    <tr >
                        <th class="span1">ID</th>
                        <th class="span2">Category</th>
                    </tr>

                    <c:forEach var="cate" begin="0" items="${requestScope.categoryList}">
                        <tr>
                            <td class="span1">${cate.categoryId}&nbsp;&nbsp;</td> 
                            <td class="span2">${cate.categoryName}&nbsp;&nbsp;</td> 
                        </tr> 

                    </c:forEach>

                </table>
                </div>
                <br><br>
                <div class="span7 no-margin-left">
                <h2> Oeuvres </h2>
                <table id="cateListTable" class="table table-hover">
                    <tr >
                        <th class="span1">ID</th>
                        <th class="span1">Title</th>
                        <th class="span2">Author</th>
                        <th class="span2">Genre</th>
                    </tr>
                    <c:forEach var="oeuvre" begin="0" items="${requestScope.oeuvreList}">
                        <tr>
                            <td class="span1">${oeuvre.oeuvreId}&nbsp;&nbsp;</td> 
                            <td class="span1">${oeuvre.title}&nbsp;&nbsp;</td> 
                            <td class="span2">${oeuvre.author}&nbsp;&nbsp;</td> 
                            <td class="span2">${oeuvre.genre}&nbsp;&nbsp;</td> 
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
